/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gamefigure.actors.hero.states;

import controller.Main;
import model.gamefigure.actors.hero.Hero;

/**
 *
 * @author Greg
 */
public class HeroWalking extends PlayerState {

    private final float dx = 5;
    private final float dy = 5;

    public HeroWalking(Hero hero) {
        super(hero);
    }

    @Override
    public void setState(PlayerState state) {
        hero.setState(state);
    }

    @Override
    public void updateState() {
        if (hero.getRotation() == 0) {
            hero.moveFigure(dx, 0);
        }
        else if (hero.getRotation() == 90) {
            hero.moveFigure(0, dy);
        }
        else if (hero.getRotation() == 180) {
            hero.moveFigure(-dx, 0);
        }
        else if (hero.getRotation() == 270) {
            hero.moveFigure(0, -dy);
        }
        checkBounds();
    }

    private void checkBounds(){
        if(hero.getX() > Main.gamePanel.getWidth() - hero.getWidth()){
            hero.moveFigure(-dx, 0);
        }
        else if(hero.getX() < 0){
            hero.moveFigure(dx, 0);
        }
        
        if(hero.getY() < 0){
            hero.moveFigure(0, dy);
        }
        if(hero.getY() > Main.gamePanel.getHeight()-hero.getHeight()){
            hero.moveFigure(0, -dy);
        }
        
    }
}
