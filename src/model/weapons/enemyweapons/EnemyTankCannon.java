/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.weapons.enemyweapons;

import model.gameobject.actors.Actor;
import model.gameobject.obstacles.projectiles.Explosion;
import model.gameobject.obstacles.projectiles.GroundScar;
import model.gameobject.obstacles.projectiles.Smoke;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class EnemyTankCannon extends EnemyWeapon {

    public EnemyTankCannon(Actor actor) {
        this.coolDown = 50;
        this.coolDownTime = 0;
        this.actor = actor;
    }

    @Override
    public void shoot(float targetX, float targetY, float rotation) {
        if (coolDownTime <= 0) {
            float sourceX = actor.getX();
            float sourceY = actor.getY();

            sourceX += (200) * Math.cos(Math.toRadians(rotation));
            sourceY += (200) * Math.sin(Math.toRadians(rotation));

            GroundScar groundScar = new GroundScar(targetX, targetY);
            groundScar.initialize();
            Explosion explosion = new Explosion(targetX, targetY, 0.1f, Utilities.randInt(0, 360));
            explosion.initialize();
            Smoke smoke = new Smoke(sourceX, sourceY, 0.1f, rotation);
            smoke.initialize();
            resetCoolDown();
        }
    }

    @Override
    public void updateWeapon() {
        if (coolDownTime > 0) {
            coolDownTime--;
        }
    }
}
