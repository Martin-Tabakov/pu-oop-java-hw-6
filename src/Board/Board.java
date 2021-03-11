package Board;

import BaseClasses.Drawable;

import java.awt.*;

public class Board extends Drawable {

    private Tile[][] tiles;

    public Tile getTile(int x,int y){
        return tiles[y][x];
    }

    public void setTile(int x,int y, Tile t){
        this.tiles[y][x] = t;
    }

    public Board(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.fillColor = new Color(0,0,0);
        this.tiles = new Tile[height][width];
        fillBoard();
    }

    private void fillBoard(){
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++) tiles[i][j] = new Tile(width,height);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(fillColor);
        g.fillRect(x,y,width*10,height*10);
    }
}
