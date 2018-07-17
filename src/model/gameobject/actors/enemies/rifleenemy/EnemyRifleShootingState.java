/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.rifleenemy;

import model.gameobject.actors.enemies.EnemyState;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class EnemyRifleShootingState extends _EnemyRifleState implements EnemyState{

    private RifleEnemy enemy;
    
    public EnemyRifleShootingState(RifleEnemy enemy){
        this.enemy = enemy;
    }
    
    @Override
    public void nextState() {
        enemy.setState(new EnemyRifleWalkState(enemy));
        enemy.getAnimator().setAnimation("Walking");
    }

    @Override
    public void updateState() {
        float rotation = Utilities.getAngle(enemy.getX(), enemy.getY(), enemy.getTargetX(), enemy.getTargetY());
        enemy.setRotation(rotation);
        enemy.setTargetX(enemy.getPlayer().getX());
        enemy.setTargetY(enemy.getPlayer().getY());
        enemy.getWeapon().shoot(enemy.getTargetX(), enemy.getTargetY(), rotation);
        if(Math.abs(Math.hypot(enemy.getTargetX() - enemy.getX(), enemy.getTargetY() - enemy.getY())) > 400){
            nextState();
        }
    }
    
}
