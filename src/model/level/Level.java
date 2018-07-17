/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.level;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import model.gameobject.actors.Actor;
import model.gameobjectbuilder.*;
import utility.ImageUtilities;
import model.Collideable;

/**
 *
 * @author Greg
 */
public abstract class Level {

    //public static int numberOfEnemies;
    private final BufferedImage backGroundImage;
    private final float width;
    private final float height;
    public static int numberOfEnemies;
    protected List<Actor> levelObjects = new CopyOnWriteArrayList<>();
    protected List<Collideable> levelFriendCollideables = new CopyOnWriteArrayList<>();
    protected List<Collideable> levelEnemyCollideables = new CopyOnWriteArrayList<>();
    protected List<Collideable> levelObstacleCollideables = new CopyOnWriteArrayList<>();
    protected BuildDirector buildDirector = new BuildDirector();
    protected EnemyRifleBuilder rifleBuilder = new EnemyRifleBuilder();
    protected EnemyFlamerBuilder flamerBuilder = new EnemyFlamerBuilder();
    protected EnemyMortarBuilder mortarBuilder = new EnemyMortarBuilder();
    protected EnemySniperBuilder sniperBuilder = new EnemySniperBuilder();
    protected EnemyRadioBuilder radioBuilder = new EnemyRadioBuilder();
    protected EnemyTankBuilder tankBuilder = new EnemyTankBuilder();

    public Level() {
        backGroundImage = ImageUtilities.LEVEL_BACKGROUND;
        width = backGroundImage.getWidth();
        height = backGroundImage.getHeight();
    }
    
    public void clearLevelFigures(){
        levelObjects.clear();
        levelFriendCollideables.clear();
        levelEnemyCollideables.clear();
        levelObstacleCollideables.clear();
    }

    public List<Actor> getLevelObjects() {
        return levelObjects;
    }

    public List<Collideable> getFriendCollideables() {
        return levelFriendCollideables;
    }

    public List<Collideable> getEnemyCollideables() {
        return levelEnemyCollideables;
    }

    public List<Collideable> getObstacleCollideables() {
        return levelObstacleCollideables;
    }

    public BufferedImage getImage() {
        return backGroundImage;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public abstract void nextLevel();
    public abstract void initialize();
    public abstract String getName();
}
