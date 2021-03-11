package Containers;

import BaseClasses.Drawable;
import Board.Tile;

import java.awt.*;

public class Node extends Drawable {

    private Tile placedTile;

    public Tile getPlacedTile() {
        return placedTile;
    }

    public void setPlacedTile(Tile placedTile) {
        this.placedTile = placedTile;
    }

    public Node(int x, int y, DType DType) {
        super(x, y, 10, 10, DType);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getFillColor());
        g.fillRect(x*width,y*height+30,width,height);
    }
}
