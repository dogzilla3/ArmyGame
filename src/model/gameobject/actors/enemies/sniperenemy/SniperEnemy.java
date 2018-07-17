/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.sniperenemy;

import model.gameobject.actors.enemies.rifleenemy.*;
import controller.Main;
import controller.animator.Animator;
import model.gameobject.CollisionBox;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.rifleenemy.EnemyRifleHitState;
import model.gameobject.actors.enemies.EnemyState;
import model.gameobject.actors.player.Player;
import model.weapons.Weapon;
import model.Collideable;

/**
 *
 * @author Greg
 */
public class SniperEnemy extends Enemy {

    private Weapon sniper;
    private _EnemySniperState currentState;
    private float startX = 0;
    private float startY = 0;
    private float endX = 0;
    private float endY = 0;

    public SniperEnemy(float x, float y) {
        super(x, y);
        this.startX = x;
        this.startY = y;
        this.speed = 0;
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
        sniper.updateWeapon();
    }

    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox((int) (x - (width / 2)), (int) (y - (height / 2)), (int) width, (int) height, this);
    }

    @Override
    public void onCollision(Collideable collider) {
        if (collider.getCollisionBox().getOwner().getDamage() > 0 && isDamageable() == true && isDamageable() == true) {
            health -= collider.getCollisionBox().getOwner().getDamage() * 4;
            if (health <= 0) {
                setDamageable(false);
                setState(new EnemySniperDyingState(this));
            } else {
                setRotation(collider.getCollisionBox().getOwner().getRotation() + 180);
                setState(new EnemySniperHitState(this));
                damageable = false;
                targetX = hero.getX();
                targetY = hero.getY();
            }

        }
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.sniper = weapon;
    }

    @Override
    public Weapon getWeapon() {
        return sniper;
    }

    @Override
    public void setAnimator(Animator animator) {
        this.animator = animator;
    }

    @Override
    public void setState(EnemyState state) {
        currentState = (_EnemySniperState) state;
    }

    public float getStartX() {
        return startX;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public Player getPlayer() {
        return hero;
    }

    @Override
    public Animator getAnimator() {
        return animator;
    }

    public float getEndX() {
        return endX;
    }

    public void setEndX(float endX) {
        this.endX = endX;
    }

    public float getEndY() {
        return endY;
    }

    public void setEndY(float endY) {
        this.endY = endY;
    }

}
