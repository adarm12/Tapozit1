package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameScene extends JPanel {
    public static final int FALLING_ORANGES_AMOUNT = 2;
    public static final int FALLING_ORANGES_SPEED = 30;

    public static final int SCORE_START = 0;
    Random random = new Random();

    private Player tapozitPlayer;
    private ArrayList<Orange> orangesList;
    private Orange orange;
    private OrangeTree orangeTree;


    public GameScene(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.tapozitPlayer = new Player();
        this.orangesList = new ArrayList<>();
        this.orange = new Orange(random.nextInt(Main.WINDOW_WEIGHT), 0);
        this.orangesList.add(orange);
        this.orangeTree = new OrangeTree(width - OrangeTree.TOP_WIDTH - OrangeTree.TREE_MARGIN,
                height - OrangeTree.TOP_HEIGHT - OrangeTree.TRUNK_HEIGHT - OrangeTree.TREE_MARGIN);
        Live score = new Live();
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
            this.setBackground(new Color(204, 255, 204));

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
                // for ()
                if (this.tapozitPlayer.isCollected(orange))
                    newOrange();
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
                    newOrange();
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
        while (this.tapozitPlayer.getRightHand().getX() + this.tapozitPlayer.getRightHand().getWidth() == Main.WINDOW_WEIGHT)
            this.tapozitPlayer.moveLeft();
        while (this.tapozitPlayer.getLeftHand().getX() - (Player.WEIGHT_BASKET / 2) == 0)
            this.tapozitPlayer.moveRight();
    }

    public void newOrange() {
        this.orange.setLocation(random.nextInt(Main.WINDOW_WEIGHT), 0);
    }


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.orangeTree.paintComponent(graphics);
        this.tapozitPlayer.paintComponent(graphics);
        this.orange.paint(graphics);
        for (Orange orange : orangesList) {
            orange.paint(graphics);
        }
    }
}