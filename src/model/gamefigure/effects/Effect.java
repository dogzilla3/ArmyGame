/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gamefigure.effects;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import model.gamefigure.GameObject;
import model.gamefigure.actors.Actor;

/**
 *
 * @author Greg
 */
public class Effect extends Actor{

    public Effect(float x, float y) {
        super(x, y);
    }

    @Override
    public void moveFigure(float dx, float dy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rectangle2D getCollisionBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onCollision(GameObject collider) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void debugLog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
