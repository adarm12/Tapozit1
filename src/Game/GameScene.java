package Game;

import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameScene extends JPanel {
    public static final int FALLING_ORANGES_AMOUNT = 2;
    public static final int FALLING_ORANGES_SPEED = 50;


    private Player tapozitPlayer;
    private OrangeTree trees;
    private ArrayList<Orange> orangesList;

    public GameScene(int x, int y, int weight, int height) {
        this.setBounds(x, y, weight, height);
        this.setBackground(new Color(204, 255, 204));

        this.tapozitPlayer = new Player();
        this.mainGameScene();

        this.trees = new OrangeTree();

        this.orangesList = new ArrayList<>();

        }


    private void mainGameScene() {
        Thread move = new Thread(() -> {
            Movement movement = new Movement(this.tapozitPlayer);
            this.addKeyListener(movement);
            this.setFocusable(true);
            this.requestFocus();
            this.setLayout(null);
            this.setDoubleBuffered(true);

            while (true) {
                switch (this.tapozitPlayer.getDirection()) {
                    case Player.RIGHT:
                        this.tapozitPlayer.moveRight();
                        break;

                    case Player.LEFT:
                        this.tapozitPlayer.moveLeft();
                        break;
                }
                // צריך לחשב גבול, שהשחקנית לא תצא מהמסך TODO


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
//            for (int i = 0; i <= 32; i++) {

            while (true) {

                try {
                    repaint();
                    Orange orange = new Orange(random.nextInt(Main.WINDOW_WEIGHT), 0);
                    this.orangesList.add(orange);

                    for (Orange oranges : this.orangesList) {
                        Thread.sleep(FALLING_ORANGES_SPEED);
                        oranges.moveDown();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        fallingOranges.start();
    }


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.tapozitPlayer.paintComponent(graphics);
        this.trees.paintComponent(graphics);
        for (Orange orange : orangesList) {
            orange.paint(graphics);
        }
    }
}

