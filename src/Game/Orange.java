package Game;

import java.awt.*;

public class Orange {

    private Circle orange;
    private Circle leaf;
    private int direction;

    public static final int ORANGE_WEIGHT = 45;
    public static final int ORANGE_HEIGHT = 45;
    public static final int LEAF_MARGIN = 3;
    public static final int LEAF_WEIGHT = 6;
    public static final int LEAF_HEIGHT = 12;

    public Orange(int x, int y) {
        this.orange = new Circle(x, y, ORANGE_WEIGHT, ORANGE_HEIGHT, new Color(255, 154, 0));
        this.leaf = new Circle(this.orange.getX() + (this.orange.getWidth() / 2),
                this.orange.getY() + LEAF_MARGIN, LEAF_WEIGHT, LEAF_HEIGHT, new Color(0, 204, 0));
    }

    public void moveDown()
    {
        this.orange.setY(this.orange.getY()+1);
        this.leaf.setY(this.leaf.getY()+1);
    }

    public void paint(Graphics graphics) {
        this.orange.paint(graphics);
        this.leaf.paint(graphics);
    }


    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}










