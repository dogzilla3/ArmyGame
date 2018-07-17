/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.mortarenemy;

import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.EnemyState;

/**
 *
 * @author Greg
 */
public class EnemyMortarLoadingState extends _EnemyMortarState implements EnemyState{

    public EnemyMortarLoadingState(Enemy enemy) {
        this.enemy = (MortarEnemy) enemy;
        //enemy.getAnimator().setAnimation("Loading");
    }

    @Override
    public void nextState() {
        enemy.setState(new EnemyMortarDyingState(enemy));
    }

    @Override
    public void updateState() {
        
    }
    
}
