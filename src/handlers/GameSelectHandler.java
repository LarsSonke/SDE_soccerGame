package handlers;

import builders.SituationBuilder;
import helpers.RandomNumberGenerator;
import main.Game;
import main.LoopHandler;

import java.util.Random;

public class GameSelectHandler implements HandlerState {
    public GameSelectHandler()
    {
        menu();
    }

    public void invoke(String methodName, String[] args)
    {
        switch (methodName) {
            case "menu" -> menu();
            case "start" -> start(args);
            case "difficulties" -> difficulties();
            case "help" -> menu();
            case "back" -> goBack();
            default -> cantFindCommand(methodName, args);
        }
    }

    public void menu()
    {
        System.out.println("""
            -------------------------------
                   Game Select Menu
            -------------------------------
            
            menu: get this menu.
            start []: start a game of a difficulty.
            difficulties: show different difficulties.
            back: go back to main menu.
                      
        """);
    }

    public void start(String[] args)
    {
        String difficulty = args[0].toLowerCase();
        switch (difficulty) {
            case "easy" -> setSituation(0);
            case "medium" -> setSituation(1);
            case "hard" -> setSituation(2);
            case "expert" -> setSituation(3);
            case "nightmare" -> setSituation(6);
        }

        if (Game.getInstance().isPlayable()) LoopHandler.instance.changeState(new GameHandler());
        else System.out.println("Invalid situation, please select a new situation");
    }

    private void setSituation(int difficulty)
    {
        SituationBuilder situationBuilder = new SituationBuilder();
        situationBuilder.defenders(RandomNumberGenerator.createRandomInteger(difficulty + 1, difficulty + 2))
            .teammates(RandomNumberGenerator.createRandomInteger(6 - difficulty, 8 - difficulty))
            .distanceFromGoal(RandomNumberGenerator.createRandomInteger(25 + (difficulty * 10), 35 + (difficulty * 10)))
            .difficulty(difficulty);
        Game.getInstance().situation = situationBuilder.build();
    }

    private void difficulties()
    {
        System.out.println("""
            -------------------------------
                     Difficulties
            -------------------------------
            Easy difficulty maximum number of defenders ahead of you is 2, maximum number of teammates is 8 and the starting distance from the goal is the shortest away, meaning your dribbling, passing and shooting have a higher chance of succeeding compared to the other difficulties
            Medium difficulty maximum number of defenders ahead of you is 3, maximum number of teammates is 7 and the starting distance from the goal is further away, meaning your dribbling, passing and shooting have a lower chance of succeeding compared to easy difficulty
            Hard difficulty maximum number of defenders ahead of you is 4, maximum number of teammates is 6 and the starting distance from the goal is further away, meaning your dribbling, passing and shooting have a lower chance of succeeding compared to easy and medium difficulty  
            Expert difficulty maximum number of defenders ahead of you is 5, maximum number of teammates is 5 and the starting distance from the goal is further away, meaning your dribbling, passing and shooting have a lower chance of succeeding compared to easy, medium and hard difficulty
            Nightmare difficulty maximum number of defenders ahead of you is 8, maximum number of teammates is 2 and the starting distance from the goal is further away, meaning your dribbling, passing and shooting have a lower chance of succeeding compared to the other difficulties
        """);
    }

    private void goBack()
    {
        LoopHandler.instance.changeState(new MenuHandler());
    }
}
