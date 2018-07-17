/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.player.states;

import controller.Main;
import model.gameobject.actors.player.Player;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class HeroWalkingState extends PlayerState {

    private final float dx = hero.getDx();
    private final float dy = hero.getDy();
    

    public HeroWalkingState(Player hero) {
        super(hero);
    }
    
    @Override
    public void setState(PlayerState state) {
        hero.setState(state);
    }

    @Override
    public void updateState() {
        hero.move(hero.getDx(), hero.getDy());
        checkBounds();
    }

    private void checkBounds(){
        if(hero.getX() > Main.gamePanel.getWidth() - hero.getWidth()/2){
            hero.move(-hero.getDx(), 0);
        }
        else if(hero.getX() - hero.getWidth()/2 < 0){
            hero.move(-hero.getDx(), 0);
        }
        
        if(hero.getY() - hero.getHeight()/2 < 0){
            hero.move(0, -hero.getDy());
        }
        if(hero.getY() + hero.getHeight()/2 > Main.gamePanel.getHeight()){
            hero.move(0, -hero.getDy());
        }
        
    }
}
