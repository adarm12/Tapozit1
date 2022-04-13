package Game;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        Main main = new Main();

    }

    public static final int WINDOW_HEIGHT = 800;
    public static final int WINDOW_WEIGHT = 1500;
    public static final int WINDOW_GAME_SCENE_WEIGHT = (WINDOW_WEIGHT * 4) / 5;
    public static final int JBUTTON_WEIGHT = 150;
    public static final int JBUTTON_HEIGHT = 150;

    public Main() {
        this.setSize(WINDOW_WEIGHT, WINDOW_HEIGHT);
//        this.setBounds(0,0,WINDOW_WEIGHT, WINDOW_HEIGHT);
//       this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        JButton startButton = new JButton("Start game");
        this.add(startButton);
        startButton.setBounds((WINDOW_WEIGHT / 2) - (JBUTTON_WEIGHT / 2),
                (WINDOW_HEIGHT / 2) - (JBUTTON_HEIGHT / 2)
                , JBUTTON_WEIGHT
                , JBUTTON_HEIGHT);
        startButton.addActionListener((event) -> {
            startButton.setVisible(false);
            GameScene game = new GameScene(0, 0, WINDOW_GAME_SCENE_WEIGHT,WINDOW_HEIGHT);
            this.add(game);
//            Score score = new Score(WINDOW_GAME_SCENE_WEIGHT, 0, 300, WINDOW_HEIGHT);
//            this.add(score);
        });
    }
}

