package main;

public class Player {
    public PlayerStatistics statistics;
    public PlayerLevel level;
    private static Player instance = null;

    public Player() {
        this.statistics = new PlayerStatistics();
        this.level = new PlayerLevel();
    }

    public static Player getInstance()
    {
        if (instance != null) return instance;
        instance = new Player();
        return instance;
    }

    public int pointsLeftOver()
    {
        return this.level.getSkillPoints() - this.statistics.pointsUsed();
    }

    public boolean canAffordUpgrade(int points)
    {
        return pointsLeftOver() >= points;
    }
}
