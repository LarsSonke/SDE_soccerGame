package builders;

import main.Situation;

public class SituationBuilder {
    private int defenders;
    private int teammates;
    private int distanceFromGoal;
    private int difficulty;

    public SituationBuilder defenders(int defenders)  {
        this.defenders = defenders;
        return this;
    }

    public SituationBuilder teammates(int teammates)  {
        this.teammates = teammates;
        return this;
    }

    public SituationBuilder distanceFromGoal(int distanceFromGoal)  {
        this.distanceFromGoal = distanceFromGoal;
        return this;
    }

    public SituationBuilder difficulty(int difficulty)  {
        this.difficulty = difficulty;
        return this;
    }

    public Situation build() {
        return new Situation(defenders, teammates, distanceFromGoal, difficulty);
    }
}
