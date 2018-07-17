/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.rifleenemy;

import controller.Main;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.EnemyState;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class EnemyRifleWalkState extends _EnemyRifleState implements EnemyState {

    private float startX;
    private float startY;
    private float dx;
    private float dy;
    private float targetDistance = 0;

    public EnemyRifleWalkState(RifleEnemy enemy) {
        this.enemy = enemy;
        startX = enemy.getX();
        startY = enemy.getY();
        enemy.setRotation(utility.Utilities.getAngle(startX, startY, enemy.getTargetX(), enemy.getTargetY()));
        targetDistance = (float) Math.abs(Math.hypot(enemy.getTargetX() - enemy.getX(), enemy.getTargetY() - enemy.getY()));
    }

    @Override
    public void nextState() {
        //enemy.setTargetX(startX);
        //enemy.setTargetY(startY);
        enemy.setState(new EnemyRifleIdleState(enemy));
        enemy.getAnimator().setAnimation("Idle");
    }

    @Override
    public void updateState() {
        if (targetDistance <= 0) {
            enemy.setTargetX(startX);
            enemy.setTargetY(startY);
            nextState();
        } else {
            enemy.setRotation(Utilities.getAngle(enemy.getX(), enemy.getY(), enemy.getTargetX(), enemy.getTargetY()));
            targetDistance -= Math.abs(Math.hypot(enemy.getDx(), enemy.getDy()));
            enemy.move(enemy.getDx(), enemy.getDy());
        }
        checkBounds();
    }

    private void checkBounds() {
        if (enemy.getX() > Main.gamePanel.getWidth() - enemy.getWidth() / 2) {
            enemy.move(-dx, 0);
        } else if (enemy.getX() - enemy.getWidth() / 2 < 0) {
            enemy.move(dx, 0);
        }

        if (enemy.getY() - enemy.getHeight() / 2 < 0) {
            enemy.move(0, dy);
        }
        if (enemy.getY() + enemy.getHeight() / 2 > Main.gamePanel.getHeight()) {
            enemy.move(0, -dy);
        }

    }
}
