package strategies;

import main.Player;
import main.PlayerStatistics;
import main.Situation;

public class DribbleStrategy implements SoccerStrategy {
    public int invoke(PlayerStatistics playerStatistics, Situation situation) {
        return (int) Math.round(
            Math.pow(
                (double) Player.getInstance().statistics.getDribbling() / 100,
                Math.max(1, situation.getDefenders())
            ) * 100
        );
    }
}
