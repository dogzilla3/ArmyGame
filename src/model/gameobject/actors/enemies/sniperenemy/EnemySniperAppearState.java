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
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class EnemySniperAppearState extends _EnemySniperState implements EnemyState {

    public EnemySniperAppearState(SniperEnemy enemy) {
        this.enemy = enemy;
        /*enemy.setX(enemy.getStartX());
        enemy.setY(enemy.getStartY());*/
        System.out.println("end x, y: " + enemy.getEndX() + ", " + enemy.getEndY());
    }

    @Override
    public void nextState() {
        enemy.setState(new EnemySniperIdleState(enemy));
        enemy.getAnimator().setAnimation("Idle");
    }

    @Override
    public void updateState() {
        if (enemy.getAlpha() + 0.02 < 1) {
            enemy.setAlpha(enemy.getAlpha() + 0.02f);
        }
        else
            enemy.setAlpha(1f);
        if (enemy.getAlpha() == 1) {
            nextState();
        }
        System.out.println("Alpha: " + enemy.getAlpha());
    }
}
