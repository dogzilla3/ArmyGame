/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.bossenemy;

import model.gameobject.actors.enemies.flamerenemy.*;
import model.gameobject.actors.enemies.EnemyState;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class EnemyBossShootingState extends _EnemyBossState {

    private BossEnemy enemy;
    private float targetX;
    private float targetY;
    private int targetRotation;

    public EnemyBossShootingState(BossEnemy enemy) {
        this.enemy = enemy;
        this.targetX = enemy.getTargetX();
        this.targetY = enemy.getTargetY();
        this.targetRotation = (int) Utilities.getAngle(enemy.getX(), enemy.getY(), targetX, targetY);

    }

    @Override
    public void nextState() {
        enemy.getAnimator().setAnimation("Idle");
    }

    @Override
    public void updateState() {

        if (enemy.getRotation() < targetRotation && enemy.getRotation() != targetRotation) {
            enemy.rotate(0.5f);
        } else if (enemy.getRotation() > targetRotation && enemy.getRotation() != targetRotation) {
            enemy.rotate(-0.5f);
        } else {
            enemy.getWeapon().shoot(targetX, targetY, enemy.getRotation());
            enemy.setState(new EnemyBossIdleState(enemy));
        }
        /*float rotation = Utilities.getAngle(enemy.getX(), enemy.getY(), enemy.getTargetX(), enemy.getTargetY());
        enemy.setRotation(rotation);
        enemy.setTargetX(enemy.getPlayer().getX());
        enemy.setTargetY(enemy.getPlayer().getY());
        enemy.getWeapon().shoot(enemy.getTargetX(), enemy.getTargetY(), rotation);
        if(Math.abs(Math.hypot(enemy.getTargetX() - enemy.getX(), enemy.getTargetY() - enemy.getY())) > 200){
            nextState();
        }*/
    }

}
