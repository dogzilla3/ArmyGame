/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.bossenemy;

import model.gameobject.actors.enemies.flamerenemy.*;
import controller.Main;

/**
 *
 * @author Greg
 */
public class EnemyBossHitState extends _EnemyBossState {

    private int coolDown = 10;
    private int coolDownTime = coolDown;

    EnemyBossHitState(BossEnemy enemy) {
        this.enemy = (BossEnemy) enemy;
        coolDownTime = coolDown;
    }

    @Override
    public void nextState() {
        enemy.getAnimator().setAnimation("Idle");
        enemy.setState(new EnemyBossShootingState(enemy));
    }

    @Override
    public void updateState() {
        if (enemy.getAlpha() >= 0.5f) {
            enemy.setAlpha(enemy.getAlpha() - 0.5f);
        } else if (enemy.getAlpha() <= 0f) {
            enemy.setAlpha(1f);
        }

        coolDownTime--;
        if (coolDownTime < 0) {
            enemy.setAlpha(1f);
            enemy.setDamageable(true);
            nextState();
        }
    }
}
