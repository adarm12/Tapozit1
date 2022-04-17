package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Live extends ImageIcon {
    public static final int LIVES_IN_GAME = 3;
    public static final int LIVE_WIDTH = 30;
    public static final int LIVE_HEIGHT = 30;
    public static final int LIVE_Y = 15;
    public static final int LIVE_MARGIN = 30;

    private int amountLive;
    private int oranges;
    private ImageIcon live;
    private ArrayList<ImageIcon> lives;


    public Live() {
        this.amountLive = LIVES_IN_GAME;
        this.live = new ImageIcon("heart.png");
        this.lives = new ArrayList<>(3);
        this.lives.add(0, live);
        this.lives.add(1, live);
        this.lives.add(2, live);
}

    public void loseLive() { // נסתיר את התמונה
        this.amountLive--;
    }

    public void collectedOranges() {
        this.oranges++;
    }

    public void paintComponent(Graphics graphics) {
        graphics.drawImage(lives.get(0).getImage(),
                Main.WINDOW_WEIGHT - Live.LIVE_WIDTH - Live.LIVE_MARGIN,
                Live.LIVE_Y, Live.LIVE_WIDTH, Live.LIVE_HEIGHT, null);
        graphics.drawImage(lives.get(1).getImage(),
                Main.WINDOW_WEIGHT - (Live.LIVE_WIDTH * 2) - Live.LIVE_MARGIN,
                Live.LIVE_Y, Live.LIVE_WIDTH, Live.LIVE_HEIGHT, null);
        graphics.drawImage(lives.get(2).getImage(),
                Main.WINDOW_WEIGHT - (Live.LIVE_WIDTH * 3) - Live.LIVE_MARGIN,
                Live.LIVE_Y, Live.LIVE_WIDTH, Live.LIVE_HEIGHT, null);
    }
}