/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.sniperenemy;

import model.gameobject.actors.enemies.EnemyState;

/**
 *
 * @author Greg
 */
public class EnemySniperDisappearState extends _EnemySniperState implements EnemyState {

    public EnemySniperDisappearState(SniperEnemy enemy) {
        this.enemy = enemy;
        enemy.setDamageable(false);
    }

    @Override
    public void nextState() {
        System.out.println("Enemy x: " + (int)enemy.getX() + "EndX " + (int)enemy.getEndX());
        if ((int)enemy.getY() == (int)enemy.getEndY()) {
            enemy.setX(enemy.getStartX());
            enemy.setY(enemy.getStartY());
        }
        else if ((int)enemy.getY() == (int)enemy.getStartY()) {
            enemy.setX(enemy.getEndX());
            enemy.setY(enemy.getEndY());
        }
        enemy.setState(new EnemySniperAppearState(enemy));
        enemy.getAnimator().setAnimation("Idle");
    }

    @Override
    public void updateState() {
        if (enemy.getAlpha() > 0.02) {
            enemy.setAlpha(enemy.getAlpha() - 0.02f);
        }
        if (enemy.getAlpha() <= 0.02) {
            nextState();
        }
    }
}
