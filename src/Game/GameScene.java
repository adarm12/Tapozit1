package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class GameScene extends JPanel {
    public static final int FALLING_ORANGES_AMOUNT = 2;
    public static final int FALLING_ORANGES_SPEED = 10;
    public static final int EXIT_BUTTON_X = 40;
    public static final int EXIT_BUTTON_Y = 875;
    public static final int EXIT_BUTTON_WIDTH = 100;
    public static final int EXIT_BUTTON_HEIGHT = 40;

    public static final int SCORE_START = 0;
    Random random = new Random();

    private Player tapozitPlayer;
    private ArrayList<Orange> orangesList;
    private Orange orange;
    private OrangeTree orangeTree;
    private Live live;
    private Score score;
    private JButton exitButton;

    public GameScene(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.tapozitPlayer = new Player();
        this.orangesList = new ArrayList<>();
        this.orange = new Orange(random.nextInt(Window.WINDOW_WIDTH), 0);
        this.orangesList.add(orange);
        this.orangeTree = new OrangeTree(width - OrangeTree.TOP_WIDTH - OrangeTree.TREE_MARGIN,
                height - OrangeTree.TOP_HEIGHT - OrangeTree.TRUNK_HEIGHT - OrangeTree.TREE_MARGIN);
        this.mainGameScene();
        this.fallingOranges();
        this.live = new Live();
        this.score = new Score(x, y, width, height);
        this.exitButton();
        this.scoreBoard();
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
                if (this.tapozitPlayer.isCollected(orange)) {
                    this.newOrange();
                    int point = this.score.addPoint();
                    System.out.println(point);
                    this.addPoint();
                    this.delete();
                    if (this.score.getPoints() == 30) {
                        this.win();
                    }
                }
                this.limit();
                repaint();
                try {
                    Thread.sleep(1);
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
                if (this.orange.getOrange().getY() == Window.WINDOW_HEIGHT) {
                    this.newOrange();
                    this.live.loseLive();
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

//    private void score() {
//        Thread score = new Thread(() -> {
//            while (true) {
//                this.addPoint();
//                repaint();
//            }
//        });
//        score.start();
//    }

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
        while (this.tapozitPlayer.getRightHand().getX() + this.tapozitPlayer.getRightHand().getWidth() == Window.WINDOW_WIDTH)
            this.tapozitPlayer.moveLeft();
        while (this.tapozitPlayer.getLeftHand().getX() - (Player.WEIGHT_BASKET / 2) == 0)
            this.tapozitPlayer.moveRight();
    }

    public void newOrange() {
        this.orange.setLocation(random.nextInt(Window.WINDOW_WIDTH), 0);
    }

    public void exitButton() {
        JButton exitButton = new JButton("Exit");
        this.add(exitButton);
        exitButton.setBounds(EXIT_BUTTON_X, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        exitButton.addActionListener((event) -> {
            Window main = new Window();
        });
    }

    public void scoreBoard() {
        JLabel score = new JLabel("Score: ");
        Font myFont = new Font("Ariel", Font.ITALIC, 20);
        score.setFont(myFont);
        score.setBounds(1250, 25, 100, 100);
        this.add(score);
    }

    public void addPoint() {
        JLabel points = new JLabel(String.valueOf(this.score.getPoints()));
        Font myFont = new Font("Ariel", Font.ITALIC, 20);
        points.setFont(myFont);
        points.setBounds(1320, 25, 50, 100);
        this.add(points);
    }

    public void delete() {
        JLabel delete = new JLabel("  ");
        Font myFont = new Font("Ariel", Font.ITALIC, 20);
        delete.setFont(myFont);
        delete.setBounds(1320, 25, 100, 100);
        this.add(delete);
    }

    public void win() {
        JLabel win = new JLabel("You win!!");
        Font myFont = new Font("Ariel", Font.ITALIC, 20);
        win.setFont(myFont);
        win.setBounds(100, 600, 1200, 200);
        this.add(win);
        this.setBackground(Color.WHITE);
        this.setBounds(0, 0, Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.orangeTree.paintComponent(graphics);
        this.tapozitPlayer.paintComponent(graphics);
        this.orange.paint(graphics);
        for (Orange orange : orangesList) {
            orange.paint(graphics);
        }
        this.live.paintComponent(graphics);
    }
}



