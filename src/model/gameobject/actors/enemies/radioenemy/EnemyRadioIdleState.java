package model.gameobject.actors.enemies.radioenemy;

import model.gameobject.actors.enemies.flamerenemy.*;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.EnemyState;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Greg
 */
public class EnemyRadioIdleState extends _EnemyRadioState {

    private int coolDown = 200;
    private int coolDownTime = coolDown;

    public EnemyRadioIdleState(Enemy enemy) {
        this.enemy = (RadioEnemy) enemy;
        coolDownTime = coolDown;
    }
    
    @Override
    public void updateState() {
        coolDownTime--;
        enemy.setTargetY(enemy.getPlayer().getY());
        if(coolDownTime == 0){
            nextState();
        }
    }

    @Override
    public void nextState() {
        enemy.setState((EnemyState)new EnemyRadioShootingState(enemy));
        enemy.getAnimator().setAnimation("Shooting");
    }

}
