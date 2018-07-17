/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.player.states;

import controller.Main;
import model.gameobject.actors.player.Player;
import view.GamePanel;

/**
 *
 * @author Greg
 */
public class HeroShootingState extends PlayerState{

    private int coolDown = 15;
    private int coolDownTime = coolDown;
    
    
    
    public HeroShootingState(Player hero) {
        super(hero);
    }
    
    @Override
    public void setState(PlayerState state) {
        hero.setState(state);
    }

    @Override
    public void updateState() {
        coolDownTime--;
        if(coolDownTime <= 0){
            coolDownTime = coolDown;
        }
        else{
            hero.getWeapon().shoot(hero.getX(), hero.getY(), hero.getRotation());
            if(hero.getWeapon().getAmmo() == -1){
                GamePanel.ammo = hero.getWeapon().getAmmo();
            }
            else{
                GamePanel.ammo = hero.getWeapon().getAmmo();
            }
        }
    }
    public void resetCoolDown(){
        coolDownTime = coolDown;
    }
}
