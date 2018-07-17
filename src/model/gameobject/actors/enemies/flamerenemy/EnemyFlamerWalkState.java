/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.flamerenemy;

import controller.Main;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.EnemyState;
import model.gameobject.actors.enemies.flamerenemy.FlamerEnemy;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class EnemyFlamerWalkState extends _EnemyFlamerState {

    private float startX;
    private float startY;
    private float dx = 0;
    private float dy = 0;
    private float speed = 3;
    private float targetDistance = 0;

    public EnemyFlamerWalkState(FlamerEnemy enemy) {
        this.enemy = enemy;
        startX = enemy.getX();
        startY = enemy.getY();
        enemy.setRotation(utility.Utilities.getAngle(startX, startY, enemy.getTargetX(), enemy.getTargetY()));
        targetDistance = (float) Math.abs(Math.hypot(enemy.getTargetX() - enemy.getX(), enemy.getTargetY() - enemy.getY()));
    }

    @Override
    public void nextState() {
        enemy.setTargetX(startX);
        enemy.setTargetY(startY);
        enemy.setState((EnemyState) new EnemyFlamerIdleState(enemy));
        enemy.getAnimator().setAnimation("Idle");
    }

    @Override
    public void updateState() {
        enemy.setRotation(Utilities.getAngle(enemy.getX(), enemy.getY(), enemy.getTargetX(), enemy.getTargetY()));
        enemy.setTargetX(enemy.getPlayer().getX());
        enemy.setTargetY(enemy.getPlayer().getY());
      
        enemy.move(enemy.getDx(), enemy.getDy());

        if (Math.abs(Math.hypot(enemy.getPlayer().getX() - enemy.getX(), enemy.getPlayer().getY() - enemy.getY())) < 200) {
            setState((EnemyState) new EnemyFlamerShootingState(enemy));
            enemy.getAnimator().setAnimation("Shooting");
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
