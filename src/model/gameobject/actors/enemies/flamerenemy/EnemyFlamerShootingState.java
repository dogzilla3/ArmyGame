/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.flamerenemy;

import model.gameobject.actors.enemies.EnemyState;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class EnemyFlamerShootingState extends _EnemyFlamerState{

    private FlamerEnemy enemy;
    
    public EnemyFlamerShootingState(FlamerEnemy enemy){
        this.enemy = enemy;
    }
    
    @Override
    public void nextState() {
        enemy.setState((EnemyState) new EnemyFlamerWalkState(enemy));
        enemy.getAnimator().setAnimation("Walking");
    }

    @Override
    public void updateState() {
        float rotation = Utilities.getAngle(enemy.getX(), enemy.getY(), enemy.getTargetX(), enemy.getTargetY());
        enemy.setRotation(rotation);
        enemy.setTargetX(enemy.getPlayer().getX());
        enemy.setTargetY(enemy.getPlayer().getY());
        enemy.getWeapon().shoot(enemy.getTargetX(), enemy.getTargetY(), rotation);
        if(Math.abs(Math.hypot(enemy.getTargetX() - enemy.getX(), enemy.getTargetY() - enemy.getY())) > 200){
            nextState();
        }
    }
    
}
