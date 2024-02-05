package strategies;

import main.Player;
import main.PlayerStatistics;
import main.Situation;

public class PassStrategy implements SoccerStrategy {
    public int invoke(PlayerStatistics playerStatistics, Situation situation) {
        return Player.getInstance().statistics.getPassing()
                * Math.min(1, situation.getDefenders() / situation.getTeammates())
                * Math.min(1, situation.getDistanceFromGoal() / (situation.getDifficulty() * 5));
    }
}
