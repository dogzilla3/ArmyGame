package model.gameobject.obstacles.projectiles;

import controller.Main;
import java.awt.geom.Rectangle2D;
import model.gameobject.GameObject;
import model.gameobject.CollisionBox;
import utility.ImageUtilities;
import utility.Utilities;
import model.Collideable;
import model.gameobject.actors.Actor;

public class Flames extends GameObject implements Collideable {

    private float dx = 0;
    private float dy = 0;
    private final float targetX;
    private final float targetY;
    private final float speed = 2;
    private static int layer = 4;
    private int damage = 5;
   

    public Flames(float originX, float originY, float x, float y, float rotation, boolean isFriend) {
        super(originX, originY);
        this.rotation = rotation;
        this.targetX = x;
        this.targetY = y;
        this.isFriend = isFriend;
        
    }

    public void initialize() {
        size = 0.5f;
        drawLayer = 3;
        setImage(ImageUtilities.FLAMES);
        dx += speed * ((float) Math.cos(Math.toRadians(rotation)));
        dy += speed * ((float) Math.sin(Math.toRadians(rotation)));
        this.width = image.getWidth();
        this.height = image.getHeight();
        /*Main.gameData.renderObjects.add(this);
        Main.gameData.enemyColliders.add(this);*/
        layer++;
        if (layer > 3) {
            layer = 1;
        }
        this.drawLayer = layer;
    }

    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void update() {
        size += 0.04;
        move(dx, dy);

        if (Utilities.inBounds(x, y) == false) {
            Main.gameData.renderObjects.remove(this);
            Main.gameData.enemyColliders.remove(this);
        }
        if (size > 2) {
            Main.gameData.renderObjects.remove(this);
            Main.gameData.enemyColliders.remove(this);
        }
        
        if (isDone == true) {
            Main.gameData.renderObjects.remove(this);
            if (isFriend == true) {
                Main.gameData.friendColliders.remove(this);
            } else {
                Main.gameData.enemyColliders.remove(this);
            }

        }
        move(dx, dy);
        if (Utilities.inBounds(x, y) == false) {
            isDone = true;
        }
    }

    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox(x, y, width/2, height/2, this);
    }

    @Override
    public void onCollision(Collideable collider) {
        //Main.gameData.gameObjects.remove(this);
        
        System.out.println("it burns!");
    }
    
    @Override
    public int getDamage(){
        return damage;
    }
}
