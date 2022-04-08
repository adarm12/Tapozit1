package NewGame;

import javax.swing.*;

public class Main2 extends JFrame {
    public static void main(String[] args) {
        Game.Main main = new Game.Main();

    }
    public static final int WINDOW_HEIGHT = 1000;
    public static final int WINDOW_WEIGHT = 1500;

    public Main2() {
        this.setSize(WINDOW_WEIGHT, WINDOW_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

    }
}