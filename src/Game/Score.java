package Game;

import javax.swing.*;
import java.awt.*;

public class Score extends JPanel {

    public static final int LIVES_IN_GAME = 3;
    public static final int SCORE_START = 0;

    private int lives;
    private int oranges;
    private OrangeTree trees;

    public Score(int x, int y, int weight, int height) {
        this.setBackground(new Color(8, 255, 7, 83));
        this.setBounds(x, y, weight, height);
        this.setLayout(null);
        this.setDoubleBuffered(true);

//        this.trees = new OrangeTree(weight - OrangeTree.TOP_WIDTH , height - OrangeTree.TOP_HEIGHT - OrangeTree.TRUNK_HEIGHT);
        this.setVisible(true);
   }

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

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.trees.paintComponent(graphics);
    }
}