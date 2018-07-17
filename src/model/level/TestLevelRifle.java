/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.level;

import controller.Main;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.radioenemy.RadioEnemy;
import model.gameobject.actors.enemies.sniperenemy.SniperEnemy;
import model.gameobject.actors.player.Player;
import model.gameobject.obstacles.rocks.Rock1;
import model.gameobject.obstacles.trees.TreeLeaves1;
import model.gameobject.obstacles.trees.TreeLeaves2;
import model.gameobject.obstacles.trees.TreeTrunk;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class TestLevelRifle extends Level {

    public TestLevelRifle() {
        System.out.println("New test level created");
    }

    @Override
    public void initialize() {
        Player hero = new Player(50, 50);
        getLevelObjects().add(hero);
        levelFriendCollideables.add(hero);
        Main.gameData.setPlayer(hero);

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(1000, 100);
        Enemy enemy = buildDirector.getEnemy();
        enemy.setTargetX(1000);
        enemy.setTargetY(500);

        Rock1 rock1 = new Rock1(100, 200);
        rock1.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(rock1);
        Main.gameData.obstacleColliders.add(rock1);
        Rock1 rock2 = new Rock1(150, 180);
        rock2.setRotation(90);
        Main.gameData.renderObjects.add(rock2);
        Main.gameData.obstacleColliders.add(rock2);

        TreeTrunk treeTrunk1 = new TreeTrunk(200, 180);
        Main.gameData.renderObjects.add(treeTrunk1);
        Main.gameData.obstacleColliders.add(treeTrunk1);

        TreeTrunk treeTrunk2 = new TreeTrunk(400, 180);
        Main.gameData.renderObjects.add(treeTrunk2);
        Main.gameData.obstacleColliders.add(treeTrunk2);
        TreeLeaves1 treeLeaves2 = new TreeLeaves1(400, 180);
        Main.gameData.renderObjects.add(treeLeaves2);
        TreeLeaves2 treeLeaves3 = new TreeLeaves2(20, 550);
        Main.gameData.renderObjects.add(treeLeaves3);

        numberOfEnemies = 10;
    }

    @Override
    public String getName() {
        return "Test Level Rifle";
    }

    @Override
    public void nextLevel() {
        //test level no next level
    }
}
