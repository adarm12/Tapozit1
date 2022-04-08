package Game;

import java.awt.*;

public class Orange  {
    private Circle orange;


    public static final int ORANGE_X = 20;
    public static final int ORANGE_Y = 30;
    public static final int ORANGE_WEIGHT = 25;
    public static final int ORANGE_HEIGHT = 25;

    public Orange() {
        this.orange = new Circle(ORANGE_X, ORANGE_Y, ORANGE_WEIGHT, ORANGE_HEIGHT, Color.ORANGE);

    }

    public void paint(Graphics graphics) {
        this.orange.paint(graphics);
    }
}










