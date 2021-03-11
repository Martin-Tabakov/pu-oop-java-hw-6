package Containers;

import BaseClasses.Drawable;

import java.awt.*;

public class Node extends Drawable {

    public Node(int x, int y, DType DType) {
        super(x, y, 10, 10, DType);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getFillColor());
        g.fillRect(x*width,y*height+30,width,height);
    }
}
