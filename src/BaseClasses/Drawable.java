package BaseClasses;

import Containers.DType;

import java.awt.*;

public abstract class Drawable extends Entity{
    protected int width;
    protected int height;
    protected DType dType;

    public DType getdType() {
        return dType;
    }

    public void setdType(DType dType) {
        this.dType = dType;
    }

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

    public Drawable(int x, int y, int width, int height, DType DType) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.dType = DType;
    }

    protected Color getFillColor(){
        return switch (dType) {
            case body -> new Color(200, 200, 200);
            case food -> new Color(100, 200, 100);
            case obstacle -> new Color(200, 100, 100);
            case none -> new Color(0,0,0);
        };
    }

    public abstract void draw(Graphics g);
}
