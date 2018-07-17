/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.sniperenemy;

import model.gameobject.actors.enemies.rifleenemy.*;
import model.gameobject.actors.enemies.Enemy;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class EnemySniperIdleState extends _EnemySniperState {

    private int coolDown = 100;
    private int coolDownTime;

    public EnemySniperIdleState(SniperEnemy enemy) {
        this.enemy = enemy;
        coolDownTime = coolDown;
        enemy.setDamageable(true);
    }
    
    @Override
    public void updateState() {
        enemy.setTargetX(enemy.getPlayer().getX());
        enemy.setTargetY(enemy.getPlayer().getY());
        enemy.setRotation(Utilities.getAngle(enemy.getX(), enemy.getY(), enemy.getTargetX(), enemy.getTargetY()));
        coolDownTime--;
        if (coolDownTime <= 0) {
            nextState();
        }
    }

    @Override
    public void nextState() {
        enemy.getAnimator().setAnimation("Shooting");
        enemy.setState(new EnemySniperShootingState(enemy));
    }

}
