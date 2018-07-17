/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.weapons.enemyweapons;

import controller.Main;
import model.gameobject.actors.Actor;
import model.gameobject.obstacles.projectiles.Bullet;
import model.gameobject.obstacles.projectiles.Flames;

/**
 *
 * @author Greg
 */
public class FlameThrower extends EnemyWeapon{
    
     public FlameThrower(Actor actor) {
        this.coolDown = 3;
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

            Flames flames = new Flames(sourceX, sourceY, targetX, targetY, rotation, false);
            flames.initialize();
            Main.gameData.renderObjects.add(flames);
            Main.gameData.enemyColliders.add(flames);
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
