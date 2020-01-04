package recipes.mainProject;

public enum DegreesOfDifficulty {
    A("VERY EASY"),
    B("EASY"),
    C("MEDIUM"),
    D("HARD"),
    E("EXTRA HARD")
    ;

    private String difficultyDescription;

    DegreesOfDifficulty(String difficultyDescription) {
        this.difficultyDescription = difficultyDescription;
    }

    public String getDifficultyDescription() {
        return difficultyDescription;
    }

    public void setDifficultyDescription(String difficultyDescription) {
        this.difficultyDescription = difficultyDescription;
    }

    @Override
    public String toString() {
        return "DegreesOfDifficulty{" +
                "difficultyDescription='" + difficultyDescription + '\'' +
                '}';
    }
}
