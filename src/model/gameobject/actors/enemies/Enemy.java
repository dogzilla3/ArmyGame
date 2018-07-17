/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies;

import controller.Main;
import controller.animator.Animator;
import model.gameobject.actors.Actor;
import model.gameobject.actors.enemies.flamerenemy._EnemyFlamerState;
import model.gameobject.actors.player.Player;

/**
 *
 * @author Greg
 */
public abstract class Enemy extends Actor{
    
    protected Player hero;
    protected EnemyState currentState;
    protected float targetX;
    protected float targetY;
    
    public Enemy(float x, float y) {
        super(x, y);
        //hero = Main.gameData.getPlayer();
    }
    
    public abstract void setState(EnemyState state);

    public float getTargetX() {
        return targetX;
    }

    public void setTargetX(float targetX) {
        this.targetX = targetX;
    }

    public float getTargetY() {
        return targetY;
    }

    public void setTargetY(float targetY) {
        this.targetY = targetY;
    }
}
