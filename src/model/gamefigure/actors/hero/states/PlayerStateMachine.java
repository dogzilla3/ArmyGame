/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gamefigure.actors.hero.states;

/**
 *
 * @author Greg
 */
public interface PlayerStateMachine {
    public void idle();
    public void walking();
    public void setState(PlayerState state);
    public PlayerState getState();
}
