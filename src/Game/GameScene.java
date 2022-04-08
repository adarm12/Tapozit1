package Game;

import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {

    private Player tapozitPlayer;
    private Orange orange;

    public GameScene(int x, int y, int weight, int height) {
        this.setBounds(x, y, weight, height);
        this.tapozitPlayer = new Player();
        this.mainGameScene();
        Movement movement = new Movement(this.tapozitPlayer);
        this.addKeyListener(movement);

        this.setLayout(null);
        this.setDoubleBuffered(true);
        this.setBackground(new Color(204, 255, 204));
        this.setFocusable(true);
        this.requestFocus();

        this.orange = new Orange();

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


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.tapozitPlayer.paint(graphics);
        this.orange.paint(graphics);
    }
}

