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
import model.gameobject.actors.Actor;
import utility.ImageUtilities;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class MortarRound extends GameObject implements Collideable {

    private Actor source;
    private int damage = 10;
    private float targetX;
    private float targetY;
    private float targetDistance = 0;

    public MortarRound(float originX, float originY, float x, float y, float rotation, Actor source, boolean isFriend) {
        super(originX, originY);
        this.speed = 5;
        this.rotation = rotation;
        this.source = source;
        this.isFriend = isFriend;
        this.targetX = x;
        this.targetY = y;
        this.drawLayer = 3;
    }

    public void initialize() {
        setImage(ImageUtilities.MORTAR_ROUND);
        size = 0.5f;
        setAlpha(0.5f);
        setRotation(rotation);
        targetDistance = (float) Math.abs(Math.hypot(targetX - x, targetY - y));
    }

    @Override
    public void move(float dx, float dy) {
        x += dx;
        y += dy;
        targetDistance -= Math.abs(Math.hypot(dx, dy));
        if (targetDistance <= 0) {
            if (isDone == false) {
                isDone = true;
                GroundScar groundScar = new GroundScar(x, y);
                groundScar.initialize();
                Explosion explosion = new Explosion(x, y, 0.1f, Utilities.randInt(0, 360));
                explosion.initialize();
            }
        }

        if (Utilities.inBounds(x, y) == false) {
            isDone = true;
        }
    }

    @Override
    public void update() {
        checkDone();
        move(dx, dy);
    }

    public Actor getSource() {
        return source;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox((int) (x - (width / 2)), (int) (y - (height / 2)), (int) width, (int) height, this);
    }

    @Override
    public void onCollision(Collideable collider) {

    }
}
