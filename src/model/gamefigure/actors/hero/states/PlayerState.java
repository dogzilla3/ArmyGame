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
public abstract class PlayerState {
    protected Hero hero;
    
    public PlayerState(Hero hero){
        this.hero = hero;
    }
    
    public abstract void setState(PlayerState state);
    public abstract void updateState();
}
