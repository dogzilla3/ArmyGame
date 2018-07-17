/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gamefigure.actors;

import java.awt.geom.Rectangle2D;
import model.gamefigure.GameObject;

/**
 *
 * @author Greg
 */
public abstract class Actor extends GameObject implements Collideable{
  
    public Actor(float x, float y) {
        super(x, y);
    }
    
    @Override
    public float getX(){
        return x;
    }
    
    @Override
    public float getY(){
        return y;
    }
    
    public abstract void moveFigure(float dx, float dy);
    public abstract void update();
    @Override
    public abstract Rectangle2D getCollisionBox();
    @Override
    public abstract void onCollision(GameObject collider);
    
}
