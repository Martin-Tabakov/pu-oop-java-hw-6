package BaseClasses;

import java.awt.*;

public abstract class Drawable extends Entity{
    protected int width;
    protected int height;
    protected Color fillColor = null;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Drawable(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public abstract void draw(Graphics g);
}
