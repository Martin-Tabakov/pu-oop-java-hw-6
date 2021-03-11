package Containers;

import BaseClasses.Container;
import BaseClasses.Drawable;
import Board.Tile;

import java.awt.*;

public class Snake extends Container {

    public void add(Tile t, Node d){
        elements.addLast(d);
        t.setPlacedEntity(elements.getLast());
    }

    @Override
    public void draw(Graphics g) {
        for (Drawable n: elements) {
            n.draw(g);
        }
    }
}
