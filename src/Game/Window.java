package Game;

import javax.swing.*;

public class Window extends JFrame {
    public static void main(String[] args) {
        Window main = new Window();
    }

    public static final int WINDOW_HEIGHT = 1000;
    public static final int WINDOW_WIDTH = 1400;
    //    public static final int WINDOW_GAME_SCENE_WEIGHT = (WINDOW_WEIGHT * 4) / 5;

    public Window() {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        Menu menu = new Menu(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
        this.add(menu);
        this.setVisible(true);
    }
}

