package strategies;

import main.Player;
import main.PlayerStatistics;
import main.Situation;

public class ShootStrategy implements SoccerStrategy {
    public int invoke(PlayerStatistics playerStatistics, Situation situation) {
        return (int) Math.round(
            Math.pow(
                (double) (Player.getInstance().statistics.getShooting() - (situation.getDifficulty() * 2)) / 100,
                Math.max(1, situation.getDistanceFromGoal() / 10)
            ) * 100
        );
    }
}
