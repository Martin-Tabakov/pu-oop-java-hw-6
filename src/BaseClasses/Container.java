package BaseClasses;

import java.awt.*;
import java.util.LinkedList;

public abstract class Container {
    protected LinkedList<Drawable> elements;

    public LinkedList<Drawable> getElements() {
        return elements;
    }


    public Container()
    {
        this.elements = new LinkedList<>();
    }

    public abstract void draw(Graphics g);
}
