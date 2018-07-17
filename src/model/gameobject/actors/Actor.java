/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors;

import java.awt.geom.Rectangle2D;
import controller.animator.Animator;
import model.gameobject.CollisionBox;
import model.gameobject.GameObject;
import model.weapons.Weapon;
import model.Collideable;

/**
 *
 * @author Greg
 */
public abstract class Actor extends GameObject implements Collideable{
  
    protected Animator animator;
    
    public Actor() {
        
    }
    
    public Actor(float x, float y) {
        super(x, y);
    }
    
    public abstract void move(float dx, float dy);
    public abstract void setWeapon(Weapon weapon);
    public abstract Weapon getWeapon();
    public abstract Animator getAnimator();
    public abstract void setAnimator(Animator animator);
    //public abstract void setCollisionBox(CollisionBox collisionBox);
    //public abstract CollisionBox getCollisionBox();
    
    @Override
    public abstract CollisionBox getCollisionBox();
    @Override
    public abstract void onCollision(Collideable collider);
}
