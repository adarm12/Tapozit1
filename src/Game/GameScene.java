package Game;

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
        this.trees = new OrangeTree(10, 450);
        this.orangesList = new ArrayList<>();

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
                    case Player.RIGHT:
                        this.tapozitPlayer.moveRight();
                        break;

                    case Player.LEFT:
                        this.tapozitPlayer.moveLeft();
                        break;
                }

                if (this.tapozitPlayer.getRightHand().getX() + this.tapozitPlayer.getRightHand().getWidth() == Main.WINDOW_GAME_SCENE_WEIGHT)
                    this.tapozitPlayer.moveLeft();


                else if (this.tapozitPlayer.getLeftHand().getX() == 0)
                    this.tapozitPlayer.moveRight();
//
//                if (this.player.getLocation() == this.stadium.getBoundX() + this.stadium.getBoundWidth() - this.player.getBodyWidth()) {
//                    this.player.moveLeft();
//                } else if (this.player.getLocation() == this.stadium.getBoundX()) {
//                    this.player.moveRight();
//                }
//                if (!shoot) {
//                    this.ball.dribble(this.player.legsX(), this.player.legsY());
//                }
//                if (this.ball.getDirection() == Ball.UP) {
//                    shoot = true;
//                    this.ball.goUp();
//                }
//                if (this.ball.getYLocation() == this.stadium.getBoundY() - 5) {
//                    shoot = false;
//                    this.ball.setDirection(Ball.NONE);
//                }
//                if (this.ball.getYLocation() == this.stadium.getBoundY() && (this.ball.getXLocation() > this.stadium.getGoalX() && this.ball.getXLocation() < this.stadium.getGoalX() + this.stadium.getGoalWidth())) {
//                    System.out.println("goal");
//                }else if (this.ball.getYLocation()==this.stadium.getBoundY()&&(this.ball.getXLocation()<this.stadium.getGoalX()||this.ball.getXLocation()>this.stadium.getGoalX()+this.stadium.getGoalWidth())){
//                    System.out.println("Missed");
//                }
//


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

            while (true) {
                repaint();
//                this.requestFocus(true);
//                this.setFocusable(true);
                Orange orange = new Orange(random.nextInt(Main.WINDOW_WEIGHT), 0);
                if (this.orangesList.size() <= FALLING_ORANGES_AMOUNT)
                    this.orangesList.add(orange);

                for (Orange oranges : this.orangesList) {
                    oranges.moveDown();
                }
                try {
                    Thread.sleep(FALLING_ORANGES_SPEED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        fallingOranges.start();
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