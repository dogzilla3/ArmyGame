/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.flamerenemy;

import controller.Main;

/**
 *
 * @author Greg
 */
public class EnemyFlamerHitState extends _EnemyFlamerState {

    private int coolDown = 20;
    private int coolDownTime = coolDown;

    EnemyFlamerHitState(FlamerEnemy enemy) {
        this.enemy = (FlamerEnemy) enemy;
        coolDownTime = coolDown;
    }

    @Override
    public void nextState() {
        enemy.setState(new EnemyFlamerWalkState(enemy));
        enemy.getAnimator().setAnimation("Walking");
    }

    @Override
    public void updateState() {
        enemy.move(-enemy.getDx(), -enemy.getDy());
        checkBounds();

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

    private void checkBounds() {
        if (enemy.getX() > Main.gamePanel.getWidth() - enemy.getWidth() / 2) {
            enemy.move(enemy.getDx(), 0);
        } else if (enemy.getX() - enemy.getWidth() / 2 < 0) {
            enemy.move(enemy.getDx(), 0);
        }

        if (enemy.getY() - enemy.getHeight() / 2 < 0) {
            enemy.move(0, enemy.getDy());
        }
        if (enemy.getY() + enemy.getHeight() / 2 > Main.gamePanel.getHeight()) {
            enemy.move(0, enemy.getDy());
        }

    }
}
