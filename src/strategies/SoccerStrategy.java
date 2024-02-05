package strategies;

import main.PlayerStatistics;
import main.Situation;

public interface SoccerStrategy {
    int invoke(PlayerStatistics playerStatistics, Situation situation);
}
