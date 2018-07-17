/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.weapons;

import controller.Main;
import model.gameobject.actors.Actor;

/**
 *
 * @author Greg
 */
public abstract class Weapon {
    //Who will be shooting this weapon
    protected Actor actor;
    
    //How many bullets does this weapon have
    protected int ammo;
    
    //How long before the actor can shoot the weapon again
    protected int coolDown;
    
    //Keeps track of the time between shots
    protected int coolDownTime;
    
    //The name of the weapon
    protected String name;
    
    //Resets the cooldowntime of the weapon
    protected void resetCoolDown(){
        coolDownTime = coolDown;
    }
    
    //Shoots the weapon
    public abstract void shoot(float targetX, float targetY, float angle);
    
    //Updates the state of the weapon
    public abstract void updateWeapon();
    
    //What is the name of the weapon
    public abstract String getName();
    public abstract void setAmmo(int ammo);
    public abstract int getAmmo();
}
