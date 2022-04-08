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

    public Main() {
        this.setSize(WINDOW_WEIGHT, WINDOW_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);


        GameScene game = new GameScene(0,0,WINDOW_GAME_SCENE_WEIGHT , WINDOW_HEIGHT);
        this.add(game);


        this.setVisible(true);
    }


}

