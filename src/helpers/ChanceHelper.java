package helpers;

import main.Game;
import main.Player;
import strategies.SoccerStrategy;

public class ChanceHelper {
    public static boolean chanceSucceeded(int chance)
    {
        int randomNumber = RandomNumberGenerator.createRandomInteger(1, 100);

        return randomNumber < chance;
    }

    public static boolean chanceSucceeded(SoccerStrategy soccerStrategy)
    {
        int chance = soccerStrategy.invoke(Player.getInstance().statistics, Game.getInstance().situation);

        return chanceSucceeded(chance);
    }
}
