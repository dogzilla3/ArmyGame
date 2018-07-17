/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.level;

import controller.Main;
import java.awt.Graphics2D;
import model.gamefigure.actors.hero.Hero;

/**
 *
 * @author Greg
 */
public class Level_1 extends Level{
    
    public Level_1(){
        System.out.println("New level 1 created");
        Hero hero = new Hero(20, 20);
        getFriendFigures().add(hero);
    }
}
