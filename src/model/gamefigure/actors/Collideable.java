
package model.gamefigure.actors;

import java.awt.geom.Rectangle2D;
import model.gamefigure.GameObject;

public interface Collideable {
    
    public Rectangle2D getCollisionBox();
    public void onCollision(GameObject collider);
}
