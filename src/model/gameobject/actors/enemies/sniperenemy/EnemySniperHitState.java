/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.sniperenemy;

import model.gameobject.actors.enemies.rifleenemy.*;
import controller.Main;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.EnemyState;

/**
 *
 * @author Greg
 */
public class EnemySniperHitState extends _EnemySniperState {

    private int coolDown = 20;
    private int coolDownTime = coolDown;

    public EnemySniperHitState(SniperEnemy enemy) {
        this.enemy = (SniperEnemy) enemy;
        coolDownTime = coolDown;
        enemy.setDamageable(false);
    }

    @Override
    public void updateState() {
        enemy.move(-enemy.getDx(), -enemy.getDy());

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

    @Override
    public void nextState() {
        enemy.setState(new EnemySniperDisappearState(enemy));
    }
}
