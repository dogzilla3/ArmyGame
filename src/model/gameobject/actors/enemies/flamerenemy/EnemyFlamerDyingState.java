/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.flamerenemy;

import model.gameobject.obstacles.projectiles.Explosion;
import model.gameobject.obstacles.projectiles.GroundScar;
import model.level.Level;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class EnemyFlamerDyingState extends _EnemyFlamerState {

    private int coolDown = 75;
    private int coolDownTime = coolDown;

    public EnemyFlamerDyingState(FlamerEnemy enemy) {
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
        enemy.setRotation(enemy.getRotation() + 6);
        enemy.move(enemy.getDx(), enemy.getDy());
        if (coolDownTime == 0) {
            enemy.isDone = true;
            GroundScar groundScar = new GroundScar(enemy.getX(), enemy.getY());
            groundScar.initialize();
            Explosion explosion = new Explosion(enemy.getX(), enemy.getY(), 0.1f, Utilities.randInt(0, 360));
            explosion.initialize();
            coolDownTime = coolDown;
            Level.numberOfEnemies--;
        }
    }
}
