/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.flamerenemy;

import controller.Main;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import controller.animator.Animator;
import model.gameobject.CollisionBox;
import model.gameobject.GameObject;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.EnemyState;
import model.gameobject.actors.player.Player;
import model.weapons.Weapon;
import model.Collideable;

/**
 *
 * @author Greg
 */
public class FlamerEnemy extends Enemy {

    private Weapon flameThrower;
    private _EnemyFlamerState currentState;

    public FlamerEnemy(float x, float y) {
        super(x, y);
        this.targetX = x;
        this.targetY = y;
        this.speed = 3;
        this.damageable = true;
        this.isFriend = false;
    }

    @Override
    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void update() {
        checkDone();
        debugLog();
        hero = Main.gameData.getPlayer();
        currentState.updateState();
        animator.animate();
        flameThrower.updateWeapon();
    }

    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox((int) (x - (width / 2)), (int) (y - (height / 2)), (int) width, (int) height, this);
    }

    @Override
    public void onCollision(Collideable collider) {
        if (collider.getCollisionBox().getOwner().getDamage() > 0 && isDamageable() == true) {
            health -= collider.getCollisionBox().getOwner().getDamage() * 4;
            if (health <= 0 && isDamageable() == true) {
                setDamageable(false);
                setState(new EnemyFlamerDyingState(this));
            } else {
                setRotation(collider.getCollisionBox().getOwner().getRotation() + 180);
                setState(new EnemyFlamerHitState(this));
                setDamageable(false);
                targetX = hero.getX();
                targetY = hero.getY();
            }
        }
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.flameThrower = weapon;
    }

    @Override
    public Weapon getWeapon() {
        return flameThrower;
    }

    @Override
    public void setAnimator(Animator animator) {
        this.animator = animator;
    }

    @Override
    public void setState(EnemyState state) {
        currentState = (_EnemyFlamerState) state;
    }

    public Player getPlayer() {
        return hero;
    }

    @Override
    public Animator getAnimator() {
        return animator;
    }
}
