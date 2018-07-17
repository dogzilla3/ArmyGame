/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.sniperenemy;

import model.gameobject.actors.enemies.rifleenemy.*;
import model.gameobject.actors.enemies.EnemyState;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class EnemySniperShootingState extends _EnemySniperState implements EnemyState {

    private int coolDown = 100;
    private int coolDownTime = coolDown;

    private SniperEnemy enemy;

    public EnemySniperShootingState(SniperEnemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void nextState() {
        enemy.setState(new EnemySniperDisappearState(enemy));
        enemy.getAnimator().setAnimation("Idle");
    }

    @Override
    public void updateState() {
        if (coolDownTime == coolDown) {
            float rotation = Utilities.getAngle(enemy.getX(), enemy.getY(), enemy.getTargetX(), enemy.getTargetY());
            enemy.setRotation(rotation);
            enemy.getWeapon().shoot(enemy.getTargetX(), enemy.getTargetY(), rotation);
        }
        else if(coolDownTime <= 0){
            System.out.println("Next state");
            coolDownTime = coolDown;
            nextState();
        }
        coolDownTime--;
        float rotation = Utilities.getAngle(enemy.getX(), enemy.getY(), enemy.getTargetX(), enemy.getTargetY());
        enemy.setRotation(rotation);
    }

}
