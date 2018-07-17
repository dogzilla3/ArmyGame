/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.weapons.playerweapons;

import controller.Main;
import model.gameobject.GameObject;
import model.gameobject.actors.Actor;
import model.gameobject.actors.player.Player;
import model.gameobject.obstacles.projectiles.Bullet;
import model.weapons.Weapon;

/**
 *
 * @author Greg
 */
public class HeroMachineGun extends Weapon {

    private String name = "Machine Gun";
    
    public HeroMachineGun(Actor actor) {
        this.coolDown = 3;
        this.coolDownTime = 0;
        this.actor = actor;
        this.ammo = 75;
    }

    @Override
    protected void resetCoolDown() {
        coolDownTime = coolDown;
    }

    @Override
    public void shoot(float targetX, float targetY, float rotation) {
        if (coolDownTime == 0) {
            ammo--;
            float sourceX = actor.getX();
            float sourceY = actor.getY();

            sourceX += (15 + (actor.getImage().getWidth() / 2)) * Math.cos(Math.toRadians(rotation));
            sourceY += (15 + (actor.getImage().getHeight() / 2)) * Math.sin(Math.toRadians(rotation));

            Bullet bullet = new Bullet(sourceX, sourceY, targetX, targetY, rotation, (Player)actor, true);
            bullet.initialize();
            Main.gameData.renderObjects.add(bullet);
            Main.gameData.friendColliders.add(bullet);
            resetCoolDown();
        }
    }

    @Override
    public void updateWeapon() {
        if (coolDownTime > 0) {
            coolDownTime--;
        }
        if (ammo == 0) {
            actor.setWeapon(new HeroRifle(actor));
        }
    }

    @Override
    public void setAmmo(int ammo) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAmmo() {
        return ammo;
    }

    @Override
    public String getName() {
        return name;
    }
}
