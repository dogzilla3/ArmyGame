/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.sniperenemy;

import model.gameobject.actors.enemies.rifleenemy.*;
import model.gameobject.actors.enemies.flamerenemy._EnemyFlamerState;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.EnemyState;
import model.gameobject.actors.enemies.flamerenemy.FlamerEnemy;

/**
 *
 * @author Greg
 */
public abstract class _EnemySniperState implements EnemyState{
    
    protected SniperEnemy enemy;
    
    public void setState(_EnemySniperState state){
        enemy.setState(state);
    }
    
    @Override
    public abstract void nextState();
    @Override
    public abstract void updateState();
}
