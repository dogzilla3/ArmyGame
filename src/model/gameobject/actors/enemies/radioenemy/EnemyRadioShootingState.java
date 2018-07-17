/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.radioenemy;

import model.gameobject.actors.enemies.mortarenemy.*;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.EnemyState;
import model.gameobject.obstacles.projectiles.Plane;

/**
 *
 * @author Greg
 */
public class EnemyRadioShootingState extends _EnemyRadioState implements EnemyState{

    private int coolDown = 100;
    private int coolDownTime = coolDown;
    
    public EnemyRadioShootingState(Enemy enemy) {
        this.enemy = (RadioEnemy) enemy;
        //enemy.getAnimator().setAnimation("Loading");
    }

    @Override
    public void nextState() {
        enemy.setState(new EnemyRadioIdleState(enemy));
        enemy.getAnimator().setAnimation("Idle");
    }

    @Override
    public void updateState() {
        coolDownTime--;
        if(coolDownTime <= 0){
            System.out.println("Radio next state");
            Plane plane = new Plane(1500, enemy.getTargetY(), enemy.getRotation());
            plane.initialize();
            nextState();
        }
    }
    
}
