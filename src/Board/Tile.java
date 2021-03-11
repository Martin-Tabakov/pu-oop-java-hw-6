package Board;
import BaseClasses.*;

public class Tile extends Entity {

    Entity placedEntity;

    public Entity getPlacedEntity() {
        return placedEntity;
    }
    public Drawable getPlacedDrawable(){
        return (Drawable) placedEntity;
    }

    public void setPlacedEntity(Entity placedEntity) {
        this.placedEntity = placedEntity;
    }

    public Tile(int x, int y) {
        super(x, y);
        this.placedEntity = null;
    }
    public boolean hasSameCoordinates(Tile t){
        return this.getX() == t.getX() && this.getY() ==t.getY();
    }
}
