package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Live {
    public static final int LIVES_IN_GAME = 3;

    private ImageIcon live;
    private int amountLive;
    private int oranges;

    public Live() {
        this.live = new ImageIcon("heart.png");
        this.amountLive = LIVES_IN_GAME;
    }

    public void loseLive() {
        this.amountLive--;
    }

    public void collectedOranges() {
        this.oranges++;
    }

    public void paintComponent(Graphics graphics) {
       graphics.drawImage(live.getImage(), 15, 15, 100, 30, null);
//        graphics.drawImage(this.lives.get(1).getImage(), 50, 15, 100, 15, null);
//        graphics.drawImage(this.lives.get(2).getImage(), 90, 15, 100, 15, null);
    }
}