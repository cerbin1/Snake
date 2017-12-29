package snake;

public enum Difficulty {
    ZERO(1000), ONE(900), TWO(800), THREE(700), FOUR(600), FIVE(500), SIX(400), SEVEN(300), EIGHT(200), NINE(100), TEN(10);

    private int difficulty;

    Difficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
