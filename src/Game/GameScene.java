package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameScene extends JPanel {
    public static final int FALLING_ORANGES_AMOUNT = 2;
    public static final int FALLING_ORANGES_SPEED = 30;

    private Player tapozitPlayer;
    private OrangeTree trees;
    private ArrayList<Orange> orangesList;
    private Orange orange;

    public GameScene(int x, int y, int weight, int height) {
        this.setBounds(x, y, weight, height);
        this.setBackground(new Color(204, 255, 204));
        this.tapozitPlayer = new Player();
        this.trees = new OrangeTree(10, 450);
        this.orangesList = new ArrayList<>();
        Random random = new Random();
        this.orange = new Orange(random.nextInt(Main.WINDOW_WEIGHT), 0);
        this.orangesList.add(orange);

        this.mainGameScene();
        this.fallingOranges();
    }

    private void mainGameScene() {
        Thread move = new Thread(() -> {
            MovementKey movementKey = new MovementKey(this.tapozitPlayer);
            this.addKeyListener(movementKey);
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
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        move.start();
    }

    private void fallingOranges() {
        Thread fallingOranges = new Thread(() -> {
            while (true) {
                this.orange.moveDown();
                if (this.orange.getOrange().getY() == Main.WINDOW_HEIGHT) {
                    this.orange.getOrange().setY(0);
                    this.orange.getLeaf().setY(0);
                    Random random = new Random();
                    int randomX = random.nextInt(Main.WINDOW_WEIGHT);
                    this.orange.getOrange().setX(randomX);
                    this.orange.getLeaf().setX(this.orange.getOrange().getX() + (this.orange.getOrange().getWidth() / 2));

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


//        Thread fallingOranges = new Thread(() -> {
//            Random random = new Random();
//
//            while (true) {
//                Orange orange = new Orange(random.nextInt(Main.WINDOW_WEIGHT), 0);
//                if (this.orangesList.size() <= FALLING_ORANGES_AMOUNT)
//                    this.orangesList.add(orange);
//                for (Orange oranges : this.orangesList) {
//                    oranges.moveDown();
//                }
//                repaint();
//                try {
//                    Thread.sleep(FALLING_ORANGES_SPEED);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        fallingOranges.start();
//    }

    public void limit() {
        while (this.tapozitPlayer.getRightHand().getX() + this.tapozitPlayer.getRightHand().getWidth() == Main.WINDOW_GAME_SCENE_WEIGHT)
            this.tapozitPlayer.moveLeft();
        while (this.tapozitPlayer.getLeftHand().getX() == 0)
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