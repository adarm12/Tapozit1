package Game;

import java.awt.*;

public class Circle {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Circle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = new Color(255, 154, 0);
    }

    public Circle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void Paint(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillOval(this.x, this.y, this.width, this.height);
    }

    public void moveDown() {
        this.y++;
    }


    public void paint(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillOval(this.x, this.y, this.width, this.height);
    }
}
