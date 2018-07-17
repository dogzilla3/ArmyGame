/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.player.states;

import controller.Main;
import model.gameobject.actors.Actor;
import model.gameobject.actors.player.Player;

/**
 *
 * @author Greg
 */
public class HeroIdleState extends PlayerState{
    
    
    public HeroIdleState(Player hero){
        super(hero);
    }
    
    @Override
    public void setState(PlayerState state){
        hero.setState(state);
    }
    
    @Override
    public void updateState(){
        //Do nothing thats what idle means
    }
}
