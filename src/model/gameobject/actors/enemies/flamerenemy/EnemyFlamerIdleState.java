package model.gameobject.actors.enemies.flamerenemy;

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
public class EnemyFlamerIdleState extends _EnemyFlamerState {

    private int coolDown = 100;
    private int coolDownTime = coolDown;

    public EnemyFlamerIdleState(Enemy enemy) {
        this.enemy = (FlamerEnemy) enemy;
    }
    
    @Override
    public void updateState() {
        if(Math.abs(Math.hypot(enemy.getPlayer().getX() - enemy.getX(), enemy.getPlayer().getY() - enemy.getY())) < 300){
            enemy.setTargetX(enemy.getPlayer().getX());
            enemy.setTargetY(enemy.getPlayer().getY());
            setState((EnemyState) new EnemyFlamerWalkState(enemy));
            enemy.getAnimator().setAnimation("Walking");
        }
    }

    @Override
    public void nextState() {
        enemy.setState((EnemyState)new EnemyFlamerWalkState(enemy));
        enemy.getAnimator().setAnimation("Walking");
    }

}
