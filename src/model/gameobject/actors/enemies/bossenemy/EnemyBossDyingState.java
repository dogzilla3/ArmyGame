/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.bossenemy;

import model.gameobject.actors.enemies.flamerenemy.*;
import model.gameobject.obstacles.projectiles.Explosion;
import model.gameobject.obstacles.projectiles.GroundScar;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class EnemyBossDyingState extends _EnemyBossState {

    private int coolDown = 75;
    private int coolDownTime = coolDown;

    public EnemyBossDyingState(BossEnemy enemy) {
        this.enemy = enemy;
        enemy.getAnimator().setAnimation("Dying");
        enemy.setDamageable(false);
    }

    @Override
    public void nextState() {

    }

    @Override
    public void updateState() {
        coolDownTime--;
        enemy.setRotation(enemy.getRotation()+6);
        enemy.move(enemy.getDx(), enemy.getDy());
        if (coolDownTime < 0) {
            enemy.isDone = true;
            Explosion explosion = new Explosion(enemy.getX(), enemy.getY(), 0.1f, Utilities.randInt(0, 360));
            explosion.initialize();
            coolDownTime = coolDown;
            
        }
    }
}
