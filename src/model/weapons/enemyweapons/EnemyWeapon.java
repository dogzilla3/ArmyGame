/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.weapons.enemyweapons;

import controller.Main;
import model.gameobject.actors.Actor;
import model.weapons.Shootable;
import model.weapons.Weapon;

/**
 *
 * @author Greg
 */
public abstract class EnemyWeapon  extends Weapon implements Shootable{

    //Resets the cooldowntime of the weapon
    @Override
    protected void resetCoolDown(){
        coolDownTime = coolDown;
    }
    
    //Shoots the weapon
    @Override
    public abstract void shoot(float targetX, float targetY, float angle);
    
    //Updates the state of the weapon
    @Override
    public abstract void updateWeapon();
    
    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAmmo(int ammo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAmmo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
