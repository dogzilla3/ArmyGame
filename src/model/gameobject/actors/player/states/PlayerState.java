/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.player.states;

import model.gameobject.actors.Actor;
import model.gameobject.actors.player.Player;

/**
 *
 * @author Greg
 */
public abstract class PlayerState {
    protected Player hero;
    
    public PlayerState(Player hero){
        this.hero = hero;
    }
    
    public void setState(PlayerState state){
        hero.setState(state);
    }
    public abstract void updateState();
}
