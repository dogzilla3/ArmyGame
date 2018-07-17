/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.radioenemy;

import model.gameobject.actors.enemies.mortarenemy.*;
import model.gameobject.actors.enemies.EnemyState;
import model.gameobject.obstacles.projectiles.Explosion;
import model.gameobject.obstacles.projectiles.GroundScar;
import model.level.Level;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class EnemyRadioDyingState extends _EnemyRadioState implements EnemyState {

    private int coolDown = 30;
    private int coolDownTime = coolDown;

    public EnemyRadioDyingState(RadioEnemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void nextState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateState() {
        coolDownTime--;
        if (coolDownTime == 25) {
            float xlocation = enemy.getX() + Utilities.randInt(-60, 60);
            float ylocation = enemy.getY() + Utilities.randInt(-60, 60);
            GroundScar groundScar = new GroundScar(xlocation, ylocation);
            groundScar.initialize();
            Explosion explosion = new Explosion(xlocation, ylocation, 0.1f, Utilities.randInt(0, 360));
            explosion.initialize();
        }
        if (coolDownTime == 15) {
            float xlocation = enemy.getX() + Utilities.randInt(-60, 60);
            float ylocation = enemy.getY() + Utilities.randInt(-60, 60);
            GroundScar groundScar = new GroundScar(xlocation, ylocation);
            groundScar.initialize();
            Explosion explosion = new Explosion(xlocation, ylocation, 0.1f, Utilities.randInt(0, 360));
            explosion.initialize();
        }
        if (coolDownTime == 0) {
            enemy.isDone = true;
            float xlocation = enemy.getX() + Utilities.randInt(-60, 60);
            float ylocation = enemy.getY() + Utilities.randInt(-60, 60);
            GroundScar groundScar = new GroundScar(xlocation, ylocation);
            groundScar.initialize();
            Explosion explosion = new Explosion(xlocation, ylocation, 0.1f, Utilities.randInt(0, 360));
            explosion.initialize();
            GroundScar groundScar2 = new GroundScar(enemy.getX(), enemy.getY());
            groundScar2.initialize();
            Explosion explosion2 = new Explosion(enemy.getX(), enemy.getY(), 0.1f, Utilities.randInt(0, 360));
            explosion2.initialize();
            Level.numberOfEnemies--;
        }
        if (enemy.getAlpha() > 0.1f) {
            enemy.setAlpha(enemy.getAlpha() - 0.1f);
        }

    }

}
