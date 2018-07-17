/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.rifleenemy;

import model.gameobject.actors.enemies.Enemy;
import model.level.Level;

/**
 *
 * @author Greg
 */
public class EnemyRifleDyingState extends _EnemyRifleState{
    private int coolDown = 50;
    private int coolDownTime = coolDown;
    
    public EnemyRifleDyingState(Enemy enemy) {
        this.enemy = (RifleEnemy) enemy;
        coolDownTime = coolDown;
        enemy.getAnimator().setAnimation("Idle");
    }

    @Override
    public void nextState() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateState() {
        coolDownTime--;
        if(coolDownTime == 0){
            enemy.isDone = true;
            Level.numberOfEnemies--;
        }
        enemy.setRotation(enemy.getRotation() + 5);
        if(enemy.getAlpha() > 0.02f)
            enemy.setAlpha(enemy.getAlpha()-0.02f);
    }
}
