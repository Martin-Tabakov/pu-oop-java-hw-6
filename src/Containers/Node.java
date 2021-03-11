package Containers;

import BaseClasses.Drawable;

import java.awt.*;

public class Node extends Drawable {

    public Node(int x, int y) {
        super(x, y, 10, 10);
        this.fillColor = new Color(200,200,200);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(fillColor);
        g.fillRect(x*width,y*height+30,width,height);
    }
}
