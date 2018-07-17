/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.player.states;

import controller.Main;
import model.gameobject.actors.player.Player;

/**
 *
 * @author Greg
 */
public class HeroHitState extends PlayerState{

    private int coolDown = 20;
    private int coolDownTime = coolDown;
    
    public HeroHitState(Player hero) {
        super(hero);
    }

    @Override
    public void updateState() {
        hero.move(-hero.getDx(), -hero.getDy());
        checkBounds();
        if(hero.getAlpha() >= 0.5f)
            hero.setAlpha(hero.getAlpha() - 0.5f);
        else if(hero.getAlpha() <= 0f)
            hero.setAlpha(1f);
        
        coolDownTime--;
        if(coolDownTime < 0){
            setState(new HeroIdleState(hero));
            hero.setAlpha(1f);
            hero.setDamageable(true);
            coolDownTime = coolDown;
        }  
    }
    
        private void checkBounds(){
        if(hero.getX() > Main.gamePanel.getWidth() - hero.getWidth()/2){
            hero.move(hero.getDx(), 0);
        }
        else if(hero.getX() - hero.getWidth()/2 < 0){
            hero.move(hero.getDx(), 0);
        }
        
        if(hero.getY() - hero.getHeight()/2 < 0){
            hero.move(0, hero.getDy());
        }
        if(hero.getY() + hero.getHeight()/2 > Main.gamePanel.getHeight()){
            hero.move(0, hero.getDy());
        }
        
    }
}
