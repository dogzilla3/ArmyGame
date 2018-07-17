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
public class TreeLeaves2 extends GameObject implements Collideable {

    public TreeLeaves2(float x, float y) {
        super(x, y);
        setImage(ImageUtilities.TREE_LEAVES_2);
        this.isFriend = false;
        this.drawLayer = 3;
    }

    public TreeLeaves2(float x, float y, float rotation) {
        super(x, y);
        setImage(ImageUtilities.TREE_LEAVES_2);
        this.isFriend = false;
        this.drawLayer = 3;
        this.rotation = rotation;
    }

    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox((int) (x - (width / 2)), (int) (y - (height / 2)), (int) width - 2, (int) height - 2, this);
    }

    @Override
    public void onCollision(Collideable collider) {

    }

    @Override
    public void debugLog() {

    }
}
