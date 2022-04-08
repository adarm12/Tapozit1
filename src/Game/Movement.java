package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {
    private Player player;

    public Movement(Player player) {
        this.player = player;
    }

    public void keyTyped(KeyEvent e) {


    }

    public void keyPressed(KeyEvent e) {
        this.player.setDirection(Player.RIGHT);
        this.player.setDirection(Player.LEFT);
        System.out.println("Key pressed");
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.player.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.player.moveLeft();
        }
    }

    public void keyReleased(KeyEvent e) {

    }

}

