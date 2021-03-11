package BaseClasses;

import Board.Tile;
import Containers.Node;

import java.awt.*;
import java.util.LinkedList;

public abstract class Container {
    protected LinkedList<Drawable> elements;

    public LinkedList<Drawable> getElements() {
        return elements;
    }

    public void add(Tile t, Node d){
        elements.addLast(d);
        t.setPlacedEntity(elements.getLast());
    }

    public Container()
    {
        this.elements = new LinkedList<>();
    }

    public void draw(Graphics g) {
        for (Drawable n: elements) {
            n.draw(g);
        }
    }
}
