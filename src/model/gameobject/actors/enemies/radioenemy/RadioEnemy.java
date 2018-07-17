/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.radioenemy;

import controller.Main;
import controller.animator.Animator;
import model.gameobject.CollisionBox;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.EnemyState;
import model.gameobject.actors.player.Player;
import model.weapons.Weapon;
import model.Collideable;
import utility.ImageUtilities;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class RadioEnemy extends Enemy {

    private Weapon weapon;
    private _EnemyRadioState currentState;
    private int shootCountDown = 18;

    public RadioEnemy(float x, float y) {
        super(x, y);
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
                setState(new EnemyRadioDyingState(this));
            } else {
                setRotation(collider.getCollisionBox().getOwner().getRotation() + 180);
                setState(new EnemyRadioDyingState(this));
                damageable = false;
                targetX = hero.getX();
                targetY = hero.getY();
            }

        }
    }

    @Override
    public void setState(EnemyState state) {
        currentState = (_EnemyRadioState) state;
    }

    public Player getPlayer() {
        return hero;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public Weapon getWeapon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Animator getAnimator() {
        return animator;
    }

    @Override
    public void setAnimator(Animator animator) {
        this.animator = animator;
    }
}
