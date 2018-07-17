package model.gameobject.actors.enemies.bossenemy;

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
public class EnemyBossIdleState extends _EnemyBossState {

    private int coolDown = 200;
    private int coolDownTime = coolDown;

    public EnemyBossIdleState(Enemy enemy) {
        this.enemy = (BossEnemy) enemy;
    }
    
    @Override
    public void updateState() {
        coolDownTime--;
        if(coolDownTime == 0){
            coolDownTime = coolDown;
            nextState();
        }
    }

    @Override
    public void nextState() {
        enemy.setState(new EnemyBossShootingState(enemy));
    }

}
