package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameScene extends JPanel {
    public static final int FALLING_ORANGES_AMOUNT = 2;
    public static final int FALLING_ORANGES_SPEED = 2;


    private Player tapozitPlayer;
    private OrangeTree trees;
    private ArrayList<Orange> orangesList;

    public GameScene(int x, int y, int weight, int height) {
        this.setBounds(x, y, weight, height);
        this.setBackground(new Color(204, 255, 204));
        this.tapozitPlayer = new Player();
        this.trees = new OrangeTree(10, 450);
        this.orangesList = new ArrayList<>();


//        Rectangle sky = new Rectangle(0, 0, Main.WINDOW_GAME_SCENE_WEIGHT, (Main.WINDOW_HEIGHT / 5), new Color(88, 236, 236, 255));

        this.mainGameScene();
    }

    private void mainGameScene() {
        Thread move = new Thread(() -> {
            MovementKey movement = new MovementKey(this.tapozitPlayer);
            this.addKeyListener(movement);
            this.setFocusable(true);
            this.requestFocus();
            this.setLayout(null);
            this.setDoubleBuffered(true);

            while (true) {

                switch (this.tapozitPlayer.getDirection()) {
                    case Player.RIGHT: {
                        this.tapozitPlayer.moveRight();
                        break;
                    }
                    case Player.LEFT: {
                        this.tapozitPlayer.moveLeft();
                        break;
                    }
                }
                limit();
                repaint();
                try {
                    Thread.sleep(Player.PLAYER_SPEED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        move.start();

        Thread fallingOranges = new Thread(() -> {
            Random random = new Random();

            while (true) {
                Orange orange = new Orange(random.nextInt(Main.WINDOW_WEIGHT), 0);
                if (this.orangesList.size() <= FALLING_ORANGES_AMOUNT)
                    this.orangesList.add(orange);
                for (Orange oranges : this.orangesList) {
                    oranges.moveDown();
                }
                repaint();
                try {
                    Thread.sleep(FALLING_ORANGES_SPEED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        fallingOranges.start();
    }

    public void limit() {
        if (this.tapozitPlayer.getRightHand().getX() + this.tapozitPlayer.getRightHand().getWidth() == Main.WINDOW_GAME_SCENE_WEIGHT)
            this.tapozitPlayer.moveLeft();
        else if (this.tapozitPlayer.getLeftHand().getX() == 0)
            this.tapozitPlayer.moveRight();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.trees.paintComponent(graphics);
        this.tapozitPlayer.paintComponent(graphics);
        for (Orange orange : orangesList) {
            orange.paint(graphics);
        }
    }
}