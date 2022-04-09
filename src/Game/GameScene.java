package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameScene extends JPanel {
    public static final int FALLING_ORANGES_AMOUNT = 3;


    private Player tapozitPlayer;
    private ArrayList<Orange> orangesList;

    public GameScene(int x, int y, int weight, int height) {
        this.setBounds(x, y, weight, height);
        this.tapozitPlayer = new Player();
        this.mainGameScene();
        Movement movement = new Movement(this.tapozitPlayer);
        this.addKeyListener(movement);

        this.orangesList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < FALLING_ORANGES_AMOUNT; i++) {
            Orange orange = new Orange(random.nextInt(Main.WINDOW_WEIGHT),0);
            this.orangesList.add(orange);
        }

        this.setLayout(null);
        this.setDoubleBuffered(true);
        this.setBackground(new Color(204, 255, 204));
        this.setFocusable(true);
        this.requestFocus();


    }

    private void mainGameScene() {
        Thread move = new Thread(() -> {
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
    }

//    Thread fallingOranges = new Thread(() -> {
//        while (true) {
//            switch () {
//
//            repaint();
//            try {
//                Thread.sleep(300);
//
//            } catch (InterruptedException e) {
//
//                e.printStackTrace();
//            }
//        }
//    });
//        move.start();
//}


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.tapozitPlayer.paintComponent(graphics);
        for (Orange orange : orangesList) {
            orange.paint(graphics);
        }
      }
}

