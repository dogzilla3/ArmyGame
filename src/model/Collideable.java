
package model;

import java.awt.geom.Rectangle2D;
import model.gameobject.CollisionBox;
import model.gameobject.GameObject;

public interface Collideable {
    
    public CollisionBox getCollisionBox();
    public void onCollision(Collideable collider);
}
