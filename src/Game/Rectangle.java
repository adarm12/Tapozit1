package Game;

import java.awt.*;

public class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Rectangle (int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void moveRight()
    {
        this.x++;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void moveLeft()
    {
        this.x--;
    }

    public void paint (Graphics graphics)
    {
        graphics.setColor(this.color);
        graphics.fillRect(this.x, this.y, this.width, this.height);
    }

}
