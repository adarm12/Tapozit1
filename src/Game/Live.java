package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Live {
    public static final int LIVES_IN_GAME = 3;
    public static final int LIVE_WIDTH = 30;
    public static final int LIVE_HEIGHT = 30;
    public static final int LIVE_Y = 15;
    public static final int LIVE_MARGIN = 30;

    private int amountLive;
    private int oranges;

    public Live() {
        this.amountLive = LIVES_IN_GAME;
    }

    public void loseLive() { // נסתיר את התמונה
        this.amountLive--;
    }

    public void collectedOranges() {
        this.oranges++;
    }

//    public void paintComponent(Graphics graphics) {
//        graphics.drawImage(this.lives.get(1).getImage(), 50, 15, 100, 15, null);
//        graphics.drawImage(this.lives.get(2).getImage(), 90, 15, 100, 15, null);
//    }
}