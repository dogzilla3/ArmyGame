/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.rifleenemy;

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
public class RifleEnemy extends Enemy {

    private Weapon rifle;
    private _EnemyRifleState currentState;
    private float startX = 0;
    private float startY = 0;

    public RifleEnemy(float x, float y) {
        super(x, y);
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
        if (Math.abs(Math.hypot(hero.getX() - x, hero.getY() - y)) < 400 && currentState.getClass() != EnemyRifleHitState.class && currentState.getClass() != EnemyRifleDyingState.class) {
            targetX = hero.getX();
            targetY = hero.getY();
            setState(new EnemyRifleShootingState(this));
            animator.setAnimation("Shooting");
        }
        currentState.updateState();
        animator.animate();
        rifle.updateWeapon();
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
                setState(new EnemyRifleDyingState(this));
            }
            else{
                setRotation(collider.getCollisionBox().getOwner().getRotation() + 180);
                setState(new EnemyRifleHitState(this));
                damageable = false;
                targetX = hero.getX();
                targetY = hero.getY();  
            }

        }
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.rifle = weapon;
    }

    @Override
    public Weapon getWeapon() {
        return rifle;
    }

    @Override
    public void setAnimator(Animator animator) {
        this.animator = animator;
    }

    @Override
    public void setState(EnemyState state) {
        currentState = (_EnemyRifleState) state;
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
}
