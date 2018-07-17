package model.gameobject.obstacles.projectiles;

import controller.Main;
import model.gameobject.GameObject;
import model.gameobject.CollisionBox;
import utility.ImageUtilities;
import utility.Utilities;
import model.Collideable;
import model.gameobject.actors.Actor;
import model.gameobject.actors.player.Player;

public class SniperBullet extends GameObject implements Collideable {

    private Actor source;
    private boolean isFriend = false;
    private int damage = 40;

    public SniperBullet(float originX, float originY, float x, float y, float rotation, Actor source, boolean isFriend) {
        super(originX, originY);
        this.speed = 50;
        this.rotation = rotation;
        this.source = source;
        this.isFriend = isFriend;
    }

    public void initialize() {
        setImage(ImageUtilities.SNIPER_BULLET);
        setRotation(rotation);
        /*Main.gameData.renderObjects.add(this);
        Main.gameData.friendColliders.add(this);*/
    }

    @Override
    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void update() {
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
        isDone = true;
    }

    public Actor getSource() {
        return source;
    }
    
    @Override
    public int getDamage(){
        return damage;
    }
}
