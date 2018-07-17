package model;

import model.gameobject.GameObject;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import model.gameobject.actors.player.Player;
import model.level.Level;

public class GameData {

    public final List<GameObject> renderObjects = new CopyOnWriteArrayList<>();
    public final List<Collideable> friendColliders = new CopyOnWriteArrayList<>();
    public final List<Collideable> enemyColliders = new CopyOnWriteArrayList<>();
    public final List<Collideable> obstacleColliders = new CopyOnWriteArrayList<>();
    public BufferedImage backgroundImage;
    private Level currentLevel;
    private Player player;

    public GameData() {
        
    }

    public void update() {
        System.out.println("Number Of Enemies: " + Level.numberOfEnemies);
        for (GameObject actor : renderObjects) {
            actor.update();
        }
        
        if (Level.numberOfEnemies == 0){
            currentLevel.nextLevel();
        }
    }        

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void clearGameFigures() {
        renderObjects.remove(player);
        currentLevel.clearLevelFigures();
        renderObjects.clear();
        friendColliders.clear();
        enemyColliders.clear();
        obstacleColliders.clear();
    }

    public void clearBackground() {
        backgroundImage = null;
    }

    public void setCurrentLevel(Level level) {
        if(currentLevel != null){
            clearGameFigures();
            System.out.println("clearing game figs");
        }
        this.currentLevel = level;
        level.initialize();
        backgroundImage = level.getImage();
        //gameObjects.add(player);
        for (GameObject gameFigure : level.getLevelObjects()) {
            renderObjects.add(gameFigure);
            if(gameFigure instanceof Player){
                System.out.println("Adding player");
            }
        }
        for (Collideable gameFigure : level.getFriendCollideables()) {
            friendColliders.add((Collideable) gameFigure);
        }
        for (Collideable gameFigure : level.getEnemyCollideables()) {
            enemyColliders.add((Collideable) gameFigure);
        }
        for (Collideable gameFigure : level.getObstacleCollideables()) {
            obstacleColliders.add((Collideable) gameFigure);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
