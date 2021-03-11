package Board;

import BaseClasses.Drawable;
import Containers.DType;

import java.awt.*;
import java.util.Random;

public class Board extends Drawable {

    private Tile[][] tiles;

    public Tile getTile(int x,int y){
        return tiles[y][x];
    }

    public void setTile(int x,int y, Tile t){
        this.tiles[y][x] = t;
    }

    public Tile getRandomEmptyTile(){
        while (true){
            int x = new Random().nextInt(width);
            int y = new Random().nextInt(height);
            Tile t;
            if((t = getTile(x,y)).placedEntity== null) return t;
        }
    }

    public Board(int x, int y, int width, int height) {
        super(x, y, width, height, DType.none);
        this.tiles = new Tile[height][width];
        fillBoard();
    }

    private void fillBoard(){
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++) tiles[i][j] = new Tile(j,i);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getFillColor());
        g.fillRect(x,y,width*10,height*10);
    }
}
