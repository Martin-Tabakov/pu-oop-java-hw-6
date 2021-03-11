package Containers;

import BaseClasses.Container;
import BaseClasses.Drawable;
import Board.Board;
import Board.Tile;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Snake extends Container {

    private Tile destination;
    LinkedList<Tile> route;

    public void setDestination(Tile destination, Board b) {
        this.destination = destination;
        findRoute(b);
    }
    public boolean hasDestination() {
        if(route == null) return false;
        return !route.isEmpty();
    }

    public Node getHead() {
        return (Node) elements.getFirst();
    }

    public void move() {

        if(getHead().getPlacedTile().equals(destination)){
            route=null;
            destination = null;
            return;
        }
        Tile newHeadPos =  route.getFirst();
        getHead().setPlacedTile(newHeadPos);
        newHeadPos.setPlacedEntity(getHead());


        route.remove();

    }



    private void findRoute(Board b) {
        route = null;
        Queue<NodeData> toVisit = new LinkedList<>();
        LinkedList<NodeData> visited = new LinkedList<>();
        toVisit.add(new NodeData(getHead().getPlacedTile(), getHead().getPlacedTile()));

        traverse(toVisit, visited, b);

        route = clearRoute(visited);
    }

    private LinkedList<Tile> clearRoute(LinkedList<NodeData> visited){
        LinkedList<Tile> route = new LinkedList<>();
        NodeData current = visited.getLast();
        while (!current.getCurrentTile().equals(current.getPreviousTile())) {

            route.add(current.getCurrentTile());
            current = getPrev(current,visited);
        }
        Collections.reverse(route);
        return  route;
    }

    private NodeData getPrev(NodeData current,LinkedList<NodeData> visited){
        for (NodeData nd: visited) {
            if(nd.getCurrentTile().equals(current.getPreviousTile())) return nd;
        }
        return null;
    }


    private LinkedList<Tile> getNeighbours(Board b, Tile current) {
        int x = current.getX();
        int y = current.getY();
        LinkedList<Tile> toReturn = new LinkedList<>();
        toReturn.add(b.getTile(assertWithinBoard(x + 1, b.getWidth()), assertWithinBoard(y, b.getHeight())));
        toReturn.add(b.getTile(assertWithinBoard(x - 1, b.getWidth()), assertWithinBoard(y, b.getHeight())));
        toReturn.add(b.getTile(assertWithinBoard(x, b.getWidth()), assertWithinBoard(y + 1, b.getHeight())));
        toReturn.add(b.getTile(assertWithinBoard(x, b.getWidth()), assertWithinBoard(y - 1, b.getHeight())));

        return toReturn;
    }

    private int assertWithinBoard(int val, int max) {
        if (val >= max) return 0;
        if (val < 0) return max - 1;
        return val;
    }

    private void traverse(Queue<NodeData> toVisit, LinkedList<NodeData> visited, Board b) {
        while (toVisit.peek() != null) {

            NodeData current = toVisit.peek();
            toVisit.remove();
            visited.add(current);
            if(current.getCurrentTile().hasSameCoordinates(destination)) return;

            for (Tile neighbour : getNeighbours(b, current.getCurrentTile())) {
                if (visited.stream().noneMatch(o -> o.getCurrentTile().hasSameCoordinates(neighbour) )) {
                    if(neighbour.getPlacedDrawable() == null){
                        toVisit.add(new NodeData(neighbour, current.getCurrentTile()));
                        continue;
                    }
                    DType neighbourType = neighbour.getPlacedDrawable().getdType();
                    switch (neighbourType) {
                        case obstacle, body -> {}
                        case food, none -> toVisit.add(new NodeData(neighbour, current.getCurrentTile()));
                    }
                }

            }
        }
    }
}

class NodeData {
    private Tile currentTile;
    private Tile previousTile;

    public Tile getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }

    public Tile getPreviousTile() {
        return previousTile;
    }

    public void setPreviousTile(Tile previousTile) {
        this.previousTile = previousTile;
    }

    NodeData(Tile currentTile, Tile previousTile) {
        this.currentTile = currentTile;
        this.previousTile = previousTile;

    }
}
