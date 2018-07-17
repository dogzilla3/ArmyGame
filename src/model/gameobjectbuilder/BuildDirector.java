/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobjectbuilder;

import controller.Main;
import model.gameobject.actors.enemies.Enemy;

/**
 *
 * @author Greg
 */
public class BuildDirector {
    
    private EnemyBuilder enemyBuilder;
    
    public void setEnemyBuilder(EnemyBuilder enemyBuilder) {
        this.enemyBuilder = enemyBuilder;
    }
    
    public Enemy getEnemy() {
        Main.gameData.getCurrentLevel().getLevelObjects().add(enemyBuilder.getEnemy());
        Main.gameData.getCurrentLevel().getEnemyCollideables().add(enemyBuilder.getEnemy());
        return enemyBuilder.getEnemy();
    }
    
    public void constructEnemy(float x, float y) {
        enemyBuilder.buildBase(x, y);
        enemyBuilder.buildImage();
        enemyBuilder.buildAnimator();
        enemyBuilder.buildWeapon();
    }
}
