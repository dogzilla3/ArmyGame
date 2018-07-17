package model.gameobject.obstacles.projectiles;

import controller.Main;
import model.gameobject.GameObject;
import model.gameobject.CollisionBox;
import utility.ImageUtilities;
import utility.Utilities;
import model.Collideable;
import model.gameobject.actors.Actor;
import model.gameobject.actors.player.Player;

public class Rocket extends GameObject implements Collideable {

    private Actor source;
    private boolean isFriend = true;
    private int damage = 40;
    private int explosionCoolDown = 50;
    private int explosionCoolDownTime = explosionCoolDown;

    public Rocket(float originX, float originY, float x, float y, float rotation, Actor source, boolean isFriend) {
        super(originX, originY);
        this.speed = 15;
        this.rotation = rotation;
        this.source = source;
        this.isFriend = isFriend;
    }

    public void initialize() {
        setImage(ImageUtilities.ROCKET);
        setRotation(rotation);
    }

    @Override
    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void update() {
        explosionCoolDownTime--;
        if (isDone == true) {
            Main.gameData.renderObjects.remove(this);
            if (isFriend == true) {
                Main.gameData.friendColliders.remove(this);
            } else {
                Main.gameData.enemyColliders.remove(this);
            }

        } else {
            if (explosionCoolDownTime <= 0) {
                Explosion explosion = new Explosion(x, y, 0.1f, Utilities.randInt(0, 360));
                explosion.initialize();
            }
            move(dx, dy);
            if (Utilities.inBounds(x, y) == false) {
                isDone = true;
            }
        }
    }

    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox(x, y, width / 2, height / 2, this);
    }

    @Override
    public void onCollision(Collideable collider) {
        isDone = true;
        Explosion explosion = new Explosion(x, y, 0.1f, Utilities.randInt(0, 360));
        explosion.initialize();
    }

    public Actor getSource() {
        return source;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
