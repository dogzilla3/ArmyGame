/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.obstacles.trees;

import model.gameobject.obstacles.rocks.*;
import model.gameobject.actors.Actor;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import model.gameobject.GameObject;
import model.gameobject.actors.Actor;
import model.gameobject.CollisionBox;
import model.Collideable;
import utility.ImageUtilities;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class TreeTrunk extends GameObject implements Collideable{

    public TreeTrunk(float x, float y) {
        super(x, y);
        setImage(ImageUtilities.TREE_TRUNK);
        this.isFriend = false;
        this.drawLayer = 2;
    }

    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox((int) (x - (width / 2)), (int) (y - (height / 2)),(int) width-2, (int) height-2, this);
    }

    @Override
    public void onCollision(Collideable collider) {
        GameObject owner = collider.getCollisionBox().getOwner(); 
        float angle = Utilities.getAngle(x, y, owner.getX(), owner.getY());
        float dx = owner.getSpeed() * ((float) Math.cos(Math.toRadians(angle)));
        float dy = owner.getSpeed() * ((float) Math.sin(Math.toRadians(angle)));
        owner.move(dx, dy);
    }

    @Override
    public void debugLog() {
        
    }
}
