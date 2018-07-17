/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.radioenemy;

import model.gameobject.actors.enemies.mortarenemy.*;
import model.gameobject.actors.enemies.EnemyState;

/**
 *
 * @author Greg
 */
public abstract class _EnemyRadioState implements EnemyState{

    protected RadioEnemy enemy;
    
    public void setState(_EnemyRadioState state){
        enemy.setState(state);
    }
    @Override
    public abstract void nextState();
    @Override
    public abstract void updateState();
}
