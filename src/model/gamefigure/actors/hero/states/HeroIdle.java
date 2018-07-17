/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gamefigure.actors.hero.states;

import model.gamefigure.actors.Actor;
import model.gamefigure.actors.hero.Hero;

/**
 *
 * @author Greg
 */
public class HeroIdle extends PlayerState{
    
    public HeroIdle(Hero hero){
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
