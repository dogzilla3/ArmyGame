/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.gamefigure.actors.Actor;
import model.gamefigure.actors.obstacles.Obstacle;

/**
 *
 * @author Greg
 */
public abstract class Level {
    
    //public static int numberOfEnemies;
    private BufferedImage backGroundImage;
    private float width;
    private float height;
    private List<Actor> enemyFigures;
    private List<Actor> friendFigures;
    private List<Obstacle> obstacles;
    
    
    public Level(){
        try {
            backGroundImage = ImageIO.read(getClass().getResource("/Assets/Background/GrassBackground.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open shooter.png");
            System.exit(-1);
        }
        enemyFigures = new CopyOnWriteArrayList<>();
        friendFigures = new CopyOnWriteArrayList<>();
        obstacles = new CopyOnWriteArrayList<>();
    }
    
    public List<Actor> getFriendFigures(){
        return friendFigures;
    }
    
    public List<Actor> getEnemyFigures(){
        return enemyFigures;
    }
    
    public List<Obstacle> getObstacles(){
        return obstacles;
    }
    
    public BufferedImage getImage(){
        return backGroundImage;
    }
}
