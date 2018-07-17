package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.gameobject.actors.Actor;
import model.gameobject.actors.player.Player;
import model.gameobject.actors.player.states.HeroHitState;
import model.gameobject.actors.player.states.HeroIdleState;
import model.gameobject.actors.player.states.HeroShootingState;
import utility.Utilities;
import model.weapons.Shootable;

public class MouseController extends MouseAdapter {
    
    Player hero = null;
    public int targetLocationX;
    public int targetLocationY;

    @Override
    public void mousePressed(MouseEvent me) {
        targetLocationX = me.getX();
        targetLocationY = me.getY();
        hero = Main.gameData.getPlayer();
        if(!(hero.getCurrentState() instanceof HeroHitState)){
            hero.setRotation(Utilities.getAngle(hero.getX(), hero.getY(), targetLocationX, targetLocationY));
            hero.shoot(targetLocationX, targetLocationY);
        }
    }
    
    public void mouseReleased(MouseEvent me){
        if(!(hero.getCurrentState() instanceof HeroHitState))
            hero.setState(new HeroIdleState(hero));
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        targetLocationX = me.getX();
        targetLocationY = me.getY();
        if(hero.getCurrentState() instanceof HeroShootingState)
            hero.setRotation(Utilities.getAngle(hero.getX(), hero.getY(), targetLocationX, targetLocationY));

    }

}
