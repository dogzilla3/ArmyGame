/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.player;

import controller.animator.animations.playeranimation.HeroWalkAnimation;
import controller.animator.animations.playeranimation.HeroIdleAnimation;
import controller.animator.animations.playeranimation.HeroShootingAnimation;
import controller.Main;
import utility.ImageUtilities;
import view.GamePanel;
import model.gameobject.actors.player.states.*;
import model.weapons.playerweapons.*;
import model.weapons.Weapon;
import controller.animator.Animator;
import model.gameobject.GameObject;
import model.gameobject.actors.Actor;
import java.awt.geom.Rectangle2D;
import model.gameobject.CollisionBox;
import model.Collideable;

/**
 *
 * @author Greg
 */
public class Player extends Actor {

    private Animator animator;
    private PlayerState currentState;
    private Weapon weapon;
    private int health = 100;


    /*public Player() {
        drawLayer = 2;
        image = ImageUtilities.HERO;
        width = image.getWidth();
        height = image.getHeight();
        weapon = new HeroRifle(this);
        animator = new Animator(this);
        animator.addAnimation("Walking", new HeroWalkAnimation());
        animator.addAnimation("Idle", new HeroIdleAnimation());
        animator.addAnimation("Shooting", new HeroShootingAnimation());
        animator.setAnimation("Idle");
        currentState = HeroIdleState.getInstance();
        this.setDamageable(true);
        this.speed = 6;
        this.isFriend = true;
    }*/
    public Player(float x, float y) {
        super(x, y);
        drawLayer = 2;
        image = ImageUtilities.HERO;
        width = image.getWidth();
        height = image.getHeight();
        weapon = new HeroRifle(this);
        animator = new Animator(this);
        animator.addAnimation("Walking", new HeroWalkAnimation());
        animator.addAnimation("Idle", new HeroIdleAnimation());
        animator.addAnimation("Shooting", new HeroShootingAnimation());
        animator.setAnimation("Idle");
        currentState = new HeroIdleState(this);
        this.setDamageable(true);
        this.speed = 6;
        GamePanel.health = 100;
    }

    @Override
    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void update() {
        debugLog();
        currentState.updateState();
        weapon.updateWeapon();
        animator.animate();
        if(health <= 0){
            Main.gameEngine.playerDead();
        }
    }

    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox((int) (x - (width / 2)), (int) (y - (height / 2)), (int) width - 2, (int) height - 2, this);
    }

    @Override
    public void onCollision(Collideable collider) {

        System.out.println("Health: " + health);
        if (collider.getCollisionBox().getOwner().getDamage() > 0 && isDamageable() == true) {
            health -= collider.getCollisionBox().getOwner().getDamage();
            GamePanel.health -= collider.getCollisionBox().getOwner().getDamage();
            if (health <= 0) {
                //do dying state here
            }
            setRotation(collider.getCollisionBox().getOwner().getRotation() + 180);
            setState(new HeroHitState(this));
            damageable = false;
        }

    }

    @Override
    public void debugLog() {

    }

    public void setState(PlayerState state) {
        if (state instanceof HeroIdleState) {
            currentState = state;
            animator.setAnimation("Idle");
        } else if (state instanceof HeroWalkingState) {
            if (!(currentState instanceof HeroWalkingState) && !(currentState instanceof HeroHitState)) {
                currentState = state;
                animator.setAnimation("Walking");
            }
        } else if (state instanceof HeroShootingState) {
            currentState = state;
            animator.setAnimation("Shooting");
        } else if (state instanceof HeroHitState) {
            currentState = state;
        }
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }

    public void shoot(float targetX, float targetY) {
        setState(new HeroShootingState(this));
        HeroShootingState state = (HeroShootingState) currentState;
        state.resetCoolDown();
        animator.setAnimation("Shooting");
    }

    @Override
    public Animator getAnimator() {
        return animator;
    }

    public PlayerState getCurrentState() {
        return currentState;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        GamePanel.weaponName = weapon.getName();
        this.weapon = weapon;
    }

    @Override
    public void setAnimator(Animator animator) {
        this.animator = animator;
    }
    
    public void setHealth(int health){
        this.health = health;
    }


    /*@Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }*/
}
