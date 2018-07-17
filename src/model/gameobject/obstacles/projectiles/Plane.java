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
public class Plane extends GameObject implements Collideable {

    private Actor source;
    private int damage = 0;
    private int bombCoolDown = 20;
    private int bombCoolDownTime = bombCoolDown;

    public Plane(float originX, float originY, float rotatio) {
        super(originX, originY);
        this.speed = 5;
        this.drawLayer = 3;
    }

    public void initialize() {
        setImage(ImageUtilities.PLANE);
        setRotation(rotation);
        Main.gameData.renderObjects.add(this);
    }

    @Override
    public void move(float dx, float dy) {
        x += dx;
        y += dy;

        if(inBounds(x, y) == false){
            isDone = true;
        }
    }

    @Override
    public void update() {
        checkDone();

        move(-15, dy);
        bombCoolDownTime--;
        if (bombCoolDownTime == 0) {
            bombCoolDownTime = Utilities.randInt(5, 15);
            
            Explosion explosion = new Explosion(x + 250, y + Utilities.randInt(-50, 50), 0.01f, Utilities.randInt(0, 360));
            explosion.initialize();
            /*GroundScar groundScar = new GroundScar(x + 100, y);
            groundScar.initialize();*/
        }
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

    private boolean inBounds(float x, float y) {
        float levelWidth = Main.gameData.getCurrentLevel().getWidth();
        float levelHeight = Main.gameData.getCurrentLevel().getHeight();

        if (x > levelWidth+500 || x < -500) {
            return false;
        } else if (y > levelHeight || y < 0) {
            return false;
        } else {
            return true;
        }
    }
}
