package main;

import handlers.GameSelectHandler;
import helpers.ChanceHelper;
import strategies.DribbleStrategy;
import strategies.PassStrategy;
import strategies.ShootStrategy;
import strategies.SoccerStrategy;

public class Game {
    private static Game instance = null;
    public Situation situation;
    public int succeededActions;
    public static Game getInstance()
    {
        if (instance != null) return instance;
        instance = new Game();
        instance.reset();
        return instance;
    }

    public boolean isPlayable()
    {
        return situation != null;
    }

    public void pass()
    {
        if (!ChanceHelper.chanceSucceeded(new PassStrategy())) {
            System.out.printf(
                    """
                    -----------------------------------
                            You passed the ball
                    -----------------------------------
                    
                    You tried passing the ball to one of your teammates...
                    Unlucky! Your pass was inaccurate and the opponent was able to steal the ball
                    
                    GAME OVER

                    """
            );
            lose();
            return;
        }

        int metersGained = Player.getInstance().statistics.getPassing() / 10;
        System.out.printf(
                """
                -----------------------------------
                        You passed the ball
                -----------------------------------

                You tried passing the ball to one of your teammates...
                Great! Your teammate received the ball without a problem

                You walk closer to goal to receive the ball back from your teammate

                After receiving the ball from your teammate at %d meters from goal.

                """, metersGained);

        situation.comeCloserToGoal(metersGained);
        checkTooClose();
    }

    public void dribble()
    {
        if (!ChanceHelper.chanceSucceeded(new DribbleStrategy())) {
            System.out.printf(
                """
                -----------------------------------
                        You dribble forward
                -----------------------------------
                
                You tried to dribble past the defenders ahead of you...
                Oei oei oei, you failed to fool the defenders and lost the ball.
                
                GAME OVER
                
                """
            );
            lose();
            return;
        }

        int metersGained = Player.getInstance().statistics.getDribbling() / 10;
        situation.comeCloserToGoal(metersGained);

        System.out.printf(
            """
            -----------------------------------
                    You dribble forward
            -----------------------------------
            
            You tried to dribble past the defenders ahead of you...
            Good job! You managed dribbling past the defenders with some great skill
            
            After your little show you are now %d meters away from goal.
            
            """,
            situation.getDistanceFromGoal()
        );

        checkTooClose();
    }

    public void shoot()
    {
        if (!ChanceHelper.chanceSucceeded(new ShootStrategy())) {
            System.out.printf(
                """
                -----------------------------------
                        You decide to shoot
                -----------------------------------
                
                You tried to shoot...
                Unfortunately you do not manage to hit the ball properly and miss
                
                GAME OVER
                
                """
            );
            lose();
            return;
        }

        win();
    }

    public void lose()
    {
        int experienceReceived = 5 * succeededActions * situation.getDifficulty();
        Player.getInstance().level.addExperience(experienceReceived);
        System.out.printf("You received %d experience.\n", experienceReceived);
        reset();

        LoopHandler.instance.changeState(new GameSelectHandler());

    }

    public void win()
    {
        System.out.println("You scored!.\n");

        int experienceReceived = (10 * succeededActions * situation.getDifficulty()) + 100 * situation.getDifficulty();
        Player.getInstance().level.addExperience(experienceReceived);
        System.out.printf("You received %d experience.\n", experienceReceived);
        reset();

        LoopHandler.instance.changeState(new GameSelectHandler());
    }

    public void checkTooClose()
    {
        if (situation.getDistanceFromGoal() > 6 + situation.getDifficulty()) return;

        System.out.println(
            """
            During your action, you got too close to the keeper and lost the ball.
            
            GAME OVER
            
            """
        );
        lose();
    }

    public void reset()
    {
        this.situation = null;
        this.succeededActions = 0;
    }
}
