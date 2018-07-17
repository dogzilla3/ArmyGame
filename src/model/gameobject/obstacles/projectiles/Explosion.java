/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.obstacles.projectiles;

import controller.Main;
import model.Collideable;
import model.gameobject.CollisionBox;
import model.gameobject.GameObject;
import utility.ImageUtilities;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class Explosion extends GameObject implements Collideable{
    
    private int damage = 20;
    
    public Explosion(float x, float y, float initialSize, float rotation) {
        super(x, y);
        this.size = initialSize;
        this.rotation = rotation;
        this.image = ImageUtilities.EXPLOSION;
        this.isFriend = false;
    }

    @Override
    public void update(){
        checkDone();
        rotation+=10;
        if(size < 1.5)
            size+=0.15;
        else
            isDone = true;
    }
    
    public void initialize() {
        size = 0.1f;
        drawLayer = 3;
        setImage(ImageUtilities.EXPLOSION);
        this.width = image.getWidth();
        this.height = image.getHeight();
        Main.gameData.renderObjects.add(this);
        Main.gameData.enemyColliders.add(this);
    }
        
    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox((int) (x - (width / 2)), (int) (y - (height / 2)),(int) width, (int) height, this);
    }

    @Override
    public void onCollision(Collideable collider) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getDamage(){
        return damage;
    }
}
