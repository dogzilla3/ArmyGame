/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.rifleenemy;

import model.gameobject.actors.enemies.Enemy;

/**
 *
 * @author Greg
 */
public class EnemyRifleIdleState extends _EnemyRifleState {

    private int coolDown = 200;
    private int coolDownTime;

    public EnemyRifleIdleState(Enemy enemy) {
        this.enemy = (RifleEnemy) enemy;
        coolDownTime = coolDown;
    }
    
    @Override
    public void updateState() {
        coolDownTime--;
        if (coolDownTime <= 0) {
            nextState();
        }
    }

    @Override
    public void nextState() {
        enemy.setState(new EnemyRifleWalkState(enemy));
        enemy.getAnimator().setAnimation("Walking");
    }

}
