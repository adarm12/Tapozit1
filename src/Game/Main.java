package Game;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        Main main = new Main();

    }

    public static final int WINDOW_HEIGHT = 1000;
    public static final int WINDOW_WEIGHT = 1400;
//    public static final int WINDOW_GAME_SCENE_WEIGHT = (WINDOW_WEIGHT * 4) / 5;
    public static final int BUTTON_WEIGHT = 150;
    public static final int BUTTON_HEIGHT = 150;

    public Main() {
        this.setSize(WINDOW_WEIGHT, WINDOW_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        JButton startButton = new JButton("Start game");
        this.add(startButton);
        startButton.setBounds((WINDOW_WEIGHT / 2) - (BUTTON_WEIGHT / 2),
                (WINDOW_HEIGHT / 2) - (BUTTON_HEIGHT / 2)
                , BUTTON_WEIGHT
                , BUTTON_HEIGHT);
        startButton.addActionListener((event) -> {
            startButton.setVisible(false);
//
//            Score score = new Score(WINDOW_GAME_SCENE_WEIGHT, 0, Main.WINDOW_WEIGHT - WINDOW_GAME_SCENE_WEIGHT , WINDOW_HEIGHT);
//            this.add(score);

            GameScene game = new GameScene(0, 0, WINDOW_WEIGHT,WINDOW_HEIGHT);
            this.add(game);

        });
    }
}

