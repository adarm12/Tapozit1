package Game;

public class Score {

    public static final int LIVES_IN_GAME = 3;
    public static final int SCORE_START = 0;

    private int lives;
    private int oranges;


    public Score() {
        this.lives = LIVES_IN_GAME;
        this.oranges = SCORE_START;
    }

    public void loseLive() {
        this.lives--;
    }

    public void collectedOranges() {
        this.oranges++;
    }
}