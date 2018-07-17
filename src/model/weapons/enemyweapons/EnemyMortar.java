/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.weapons.enemyweapons;

import controller.Main;
import model.gameobject.actors.Actor;
import model.gameobject.obstacles.projectiles.MortarRound;
import model.gameobject.obstacles.projectiles.Smoke;

/**
 *
 * @author Greg
 */
public class EnemyMortar extends EnemyWeapon {

    public EnemyMortar(Actor actor) {
        this.coolDown = 50;
        this.coolDownTime = 0;
        this.actor = actor;
    }

    @Override
    public void shoot(float targetX, float targetY, float rotation) {
        if (coolDownTime <= 0) {
            float sourceX = actor.getX();
            float sourceY = actor.getY();

            sourceX += (15 + actor.getImage().getWidth() / 2) * Math.cos(Math.toRadians(rotation));
            sourceY += (15 + actor.getImage().getHeight() / 2) * Math.sin(Math.toRadians(rotation));

            MortarRound round = new MortarRound(sourceX, sourceY, targetX, targetY, rotation, actor, false);
            round.initialize();
            Smoke smoke = new Smoke(sourceX+40, sourceY+40, 0.1f, rotation);
            smoke.initialize();
            Main.gameData.renderObjects.add(round);
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
