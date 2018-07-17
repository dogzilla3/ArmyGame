/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.weapons.enemyweapons;

import controller.Main;
import model.gameobject.actors.Actor;
import model.gameobject.obstacles.projectiles.Bullet;

/**
 *
 * @author Greg
 */
public class EnemyRifle extends EnemyWeapon{
    
     public EnemyRifle(Actor actor) {
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

            Bullet bullet = new Bullet(sourceX, sourceY, targetX, targetY, rotation, actor, false);
            bullet.initialize();
            Main.gameData.renderObjects.add(bullet);
            Main.gameData.enemyColliders.add(bullet);
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
