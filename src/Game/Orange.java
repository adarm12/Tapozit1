package Game;

import java.awt.*;

public class Orange {

    private Circle orange;
    private Circle leaf;

    public static final int ORANGE_X = 20;
    public static final int ORANGE_Y = 30;
    public static final int ORANGE_WEIGHT = 45;
    public static final int ORANGE_HEIGHT = 45;
    public static final int LEAF_MARGIN = 3;
    public static final int LEAF_WEIGHT = 6;
    public static final int LEAF_HEIGHT = 12;

    public Orange() {
        this.orange = new Circle(ORANGE_X, ORANGE_Y, ORANGE_WEIGHT, ORANGE_HEIGHT, new Color(255, 154, 0));
        this.leaf = new Circle(this.orange.getX() + (this.orange.getWidth() / 2),
                this.orange.getY() + LEAF_MARGIN, LEAF_WEIGHT, LEAF_HEIGHT, new Color(0,204,0));
    }

    public void paint(Graphics graphics) {
        this.orange.paint(graphics);
        this.leaf.paint(graphics);
    }
}










