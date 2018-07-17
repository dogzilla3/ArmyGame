/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject;

import java.awt.geom.Rectangle2D;

/**
 *
 * @author Greg
 */
public class CollisionBox {
    
    private GameObject owner;
    private Rectangle2D.Float collider;
    
    public CollisionBox(float x, float y, float width, float height, GameObject owner){
        collider = new Rectangle2D.Float(x,y,width,height);
        this.owner = owner;
    }

    public Rectangle2D.Float getBounds() {
        return collider;
    }
    
    public GameObject getOwner(){
        return owner;
    }
    
    public void rotateCollider(){
        //collider.
    }
}
