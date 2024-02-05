package main;

public class Situation {
    private int defenders;
    private int teammates;
    private int distanceFromGoal;
    private int difficulty;

    public Situation(int defenders, int teammates, int distanceFromGoal, int difficulty) {
        this.defenders = defenders;
        this.teammates = teammates;
        this.distanceFromGoal = distanceFromGoal;
        this.difficulty = difficulty;
    }

    public int getDefenders() {
        return defenders;
    }

    public void setDefenders(int defenders) {
        this.defenders = defenders;
    }

    public int getTeammates() {
        return teammates;
    }

    public void setTeammates(int teammates) {
        this.teammates = teammates;
    }

    public int getDistanceFromGoal() {
        return distanceFromGoal;
    }

    public void comeCloserToGoal(int distance) {
        this.distanceFromGoal -= distance;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}

