/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.weapons.enemyweapons;

import controller.Main;
import model.gameobject.actors.Actor;
import model.gameobject.obstacles.projectiles.SniperBullet;

/**
 *
 * @author Greg
 */
public class EnemySniperRifle extends EnemyWeapon{

    public EnemySniperRifle(Actor actor) {
        this.coolDown = 30;
        this.coolDownTime = 0;
        this.actor = actor;
    }

    @Override
    public void shoot(float targetX, float targetY, float rotation) {
        if (coolDownTime == 0) {
            float sourceX = actor.getX();
            float sourceY = actor.getY();

            sourceX += (15 + actor.getImage().getWidth() / 2) * Math.cos(Math.toRadians(rotation));
            sourceY += (15 + actor.getImage().getHeight() / 2) * Math.sin(Math.toRadians(rotation));

            SniperBullet sniperBullet = new SniperBullet(sourceX, sourceY, targetX, targetY, rotation, actor, false);
            sniperBullet.initialize();
            Main.gameData.renderObjects.add(sniperBullet);
            Main.gameData.enemyColliders.add(sniperBullet);
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
