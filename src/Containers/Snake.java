package Containers;

import BaseClasses.Container;
import Board.Tile;

public class Snake extends Container {

    private Tile destination;

    public void setDestination(Tile destination){
        this.destination = destination;
    }
}
