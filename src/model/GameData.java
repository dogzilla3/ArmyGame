package model;

import model.gamefigure.GameObject;
import controller.Main;
import view.GamePanel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import model.gamefigure.actors.Actor;
import model.gamefigure.actors.obstacles.Obstacle;
import model.level.Level;

public class GameData {

    public final List<Actor> enemyFigures;
    public final List<Actor> friendFigures;
    public final List<Obstacle> obstacles;
    public BufferedImage backgroundImage;
    private Level currentLevel;
    private GameObject player;

    public GameData() {
        enemyFigures = new CopyOnWriteArrayList<>();
        friendFigures = new CopyOnWriteArrayList<>();
        obstacles = new CopyOnWriteArrayList<>();

        // GamePanel.width, height are known when rendered. 
        // Thus, at this moment,
        // we cannot use GamePanel.width and height.
        //shooter = new Shooter(Main.WIN_WIDTH / 2, Main.WIN_HEIGHT - 80);
    }

    public void update() {
        for(Actor actor : friendFigures){
            actor.update();
        }
        
        /*for(Actor actor : obstacles){
            actor.update();
        }*/
        
        for(Actor actor : enemyFigures){
            actor.update();
        }
    }
    
    public Level getCurrentLevel(){
        return currentLevel;
    }
    
    public void clearGameFigures(){
        enemyFigures.clear();
        friendFigures.clear();
        obstacles.clear();
    }
    
    public void clearBackground(){
        backgroundImage = null;
    }
    
    public void setCurrentLevel(Level level){
        this.currentLevel = level;
        clearGameFigures();
        clearBackground();
        
        player = level.getFriendFigures().get(0);
        backgroundImage = level.getImage();
        for(GameObject gameFigure : level.getFriendFigures()){
            friendFigures.add((Actor)gameFigure);
        }
        for(GameObject gameFigure : level.getEnemyFigures()){
            enemyFigures.add((Actor)gameFigure);
        }
        for(GameObject gameFigure : level.getEnemyFigures()){
            enemyFigures.add((Obstacle)gameFigure);
        }
    }
    
    public GameObject getPlayer(){
        return player;
    }
}
