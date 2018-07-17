/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.mortarenemy;

import model.gameobject.actors.enemies.EnemyState;

/**
 *
 * @author Greg
 */
public abstract class _EnemyMortarState implements EnemyState{

    protected MortarEnemy enemy;
    
    public void setState(_EnemyMortarState state){
        enemy.setState(state);
    }
    @Override
    public abstract void nextState();
    @Override
    public abstract void updateState();
}
