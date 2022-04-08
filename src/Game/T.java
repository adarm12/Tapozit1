package Game;

import java.awt.*;

public class T {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public T(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void paint (Graphics graphics)
    {
        graphics.setColor(this.color);
        graphics.fillRect(x, y, width, height);
    }
}
