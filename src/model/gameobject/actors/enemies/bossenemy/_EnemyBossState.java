/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.bossenemy;

import model.gameobject.actors.enemies.flamerenemy.*;
import model.gameobject.actors.enemies.EnemyState;

/**
 *
 * @author Greg
 */
public abstract class _EnemyBossState implements EnemyState{
    
    protected BossEnemy enemy;
    
    public void setState(EnemyState state){
        enemy.setState(state);
    }
    
    @Override
    public abstract void nextState();
    @Override
    public abstract void updateState();
}
