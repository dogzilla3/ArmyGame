/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.level;

import controller.Main;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.player.Player;
import model.gameobject.obstacles.pickups.MachineGunPickup;
import model.gameobject.obstacles.pickups.MedKitPickup;
import model.gameobject.obstacles.rocks.Rock1;
import model.gameobject.obstacles.trees.TreeLeaves1;
import model.gameobject.obstacles.trees.TreeLeaves2;
import model.gameobject.obstacles.trees.TreeTrunk;
import utility.ImageUtilities;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class Level_1 extends Level {

    public Level_1() {
        System.out.println("New test level created");
    }

    @Override
    public void initialize() {
        Player hero = new Player(60, 50);
        getLevelObjects().add(hero);
        levelFriendCollideables.add(hero);
        Main.gameData.setPlayer(hero);

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(500, 100);
        Enemy enemy = buildDirector.getEnemy();
        enemy.setTargetX(500);
        enemy.setTargetY(500);

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(550, 500);
        Enemy enemy1 = buildDirector.getEnemy();
        enemy1.setTargetX(550);
        enemy1.setTargetY(100);

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(970, 120);
        Enemy enemy2 = buildDirector.getEnemy();
        enemy2.setRotation(180);
        enemy2.setTargetX(970);
        enemy2.setTargetY(120);

        TreeTrunk treeTrunk11 = new TreeTrunk(1150, 120);
        Main.gameData.renderObjects.add(new TreeLeaves1(1150, 120));
        Main.gameData.renderObjects.add(treeTrunk11);
        Main.gameData.obstacleColliders.add(treeTrunk11);

        TreeTrunk treeTrunk12 = new TreeTrunk(1100, 180);
        Main.gameData.renderObjects.add(new TreeLeaves1(1100, 180));
        Main.gameData.renderObjects.add(treeTrunk12);
        Main.gameData.obstacleColliders.add(treeTrunk12);

        Rock1 sandBag1 = new Rock1(900, 70);
        sandBag1.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag1);
        Main.gameData.obstacleColliders.add(sandBag1);

        Rock1 sandBag3 = new Rock1(930, 40);
        sandBag3.setRotation(90);
        sandBag3.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag3);
        Main.gameData.obstacleColliders.add(sandBag3);

        Rock1 sandBag2 = new Rock1(910, 50);
        sandBag2.setImage(ImageUtilities.SANDBAG);
        sandBag2.setRotation(45);
        Main.gameData.renderObjects.add(sandBag2);
        Main.gameData.obstacleColliders.add(sandBag2);

        Rock1 sandBag4 = new Rock1(900, 160);
        sandBag4.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag4);
        Main.gameData.obstacleColliders.add(sandBag4);

        Rock1 sandBag5 = new Rock1(930, 190);
        sandBag5.setRotation(90);
        sandBag5.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag5);
        Main.gameData.obstacleColliders.add(sandBag5);

        Rock1 sandBag6 = new Rock1(910, 180);
        sandBag6.setImage(ImageUtilities.SANDBAG);
        sandBag6.setRotation(135);
        Main.gameData.renderObjects.add(sandBag6);
        Main.gameData.obstacleColliders.add(sandBag6);

        Main.gameData.renderObjects.add(new TreeLeaves1(100, 150));
        Main.gameData.renderObjects.add(new TreeLeaves2(30, 150));

        TreeTrunk treeTrunk1 = new TreeTrunk(200, 150);
        Main.gameData.renderObjects.add(new TreeLeaves1(200, 150));
        Main.gameData.renderObjects.add(treeTrunk1);
        Main.gameData.obstacleColliders.add(treeTrunk1);

        TreeTrunk treeTrunk2 = new TreeTrunk(270, 200);
        Main.gameData.renderObjects.add(new TreeLeaves2(270, 200));
        Main.gameData.renderObjects.add(treeTrunk2);
        Main.gameData.obstacleColliders.add(treeTrunk2);

        TreeTrunk treeTrunk3 = new TreeTrunk(310, 250);
        Main.gameData.renderObjects.add(new TreeLeaves2(310, 250));
        Main.gameData.renderObjects.add(treeTrunk3);
        Main.gameData.obstacleColliders.add(treeTrunk3);

        TreeTrunk treeTrunk4 = new TreeTrunk(270, 300);
        Main.gameData.renderObjects.add(new TreeLeaves2(270, 300));
        Main.gameData.renderObjects.add(treeTrunk4);
        Main.gameData.obstacleColliders.add(treeTrunk4);

        TreeTrunk treeTrunk5 = new TreeTrunk(200, 350);
        Main.gameData.renderObjects.add(new TreeLeaves1(200, 350));
        Main.gameData.renderObjects.add(treeTrunk5);
        Main.gameData.obstacleColliders.add(treeTrunk5);

        Rock1 rock1 = new Rock1(400, 530);
        rock1.setRotation(90);
        Main.gameData.renderObjects.add(rock1);
        Main.gameData.obstacleColliders.add(rock1);
        Rock1 rock2 = new Rock1(430, 540);
        rock2.setRotation(0);
        Main.gameData.renderObjects.add(rock2);
        Main.gameData.obstacleColliders.add(rock2);

        TreeTrunk treeTrunk6 = new TreeTrunk(740, 250);
        Main.gameData.renderObjects.add(new TreeLeaves1(740, 250));
        Main.gameData.renderObjects.add(treeTrunk6);
        Main.gameData.obstacleColliders.add(treeTrunk6);

        TreeTrunk treeTrunk7 = new TreeTrunk(700, 300);
        Main.gameData.renderObjects.add(new TreeLeaves2(700, 300));
        Main.gameData.renderObjects.add(treeTrunk7);
        Main.gameData.obstacleColliders.add(treeTrunk7);

        TreeTrunk treeTrunk8 = new TreeTrunk(630, 350);
        Main.gameData.renderObjects.add(new TreeLeaves1(630, 350));
        Main.gameData.renderObjects.add(treeTrunk8);
        Main.gameData.obstacleColliders.add(treeTrunk8);

        TreeTrunk treeTrunk9 = new TreeTrunk(700, 400);
        Main.gameData.renderObjects.add(new TreeLeaves2(700, 400));
        Main.gameData.renderObjects.add(treeTrunk9);
        Main.gameData.obstacleColliders.add(treeTrunk9);

        TreeTrunk treeTrunk10 = new TreeTrunk(740, 450);
        Main.gameData.renderObjects.add(new TreeLeaves1(740, 450));
        Main.gameData.renderObjects.add(treeTrunk10);
        Main.gameData.obstacleColliders.add(treeTrunk10);

        MedKitPickup medKitPickup = new MedKitPickup(800, 350);
        Main.gameData.renderObjects.add(medKitPickup);
        Main.gameData.enemyColliders.add(medKitPickup);

        MachineGunPickup machineGunPickup = new MachineGunPickup(170, 250);
        Main.gameData.renderObjects.add(machineGunPickup);
        Main.gameData.enemyColliders.add(machineGunPickup);

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(1100, 520);
        Enemy enemy3 = buildDirector.getEnemy();
        enemy3.setTargetX(600);
        enemy3.setTargetY(520);

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(1100, 580);
        Enemy enemy4 = buildDirector.getEnemy();
        enemy4.setTargetX(600);
        enemy4.setTargetY(580);

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(1160, 520);
        Enemy enemy5 = buildDirector.getEnemy();
        enemy5.setTargetX(660);
        enemy5.setTargetY(520);

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(1160, 580);
        Enemy enemy6 = buildDirector.getEnemy();
        enemy6.setTargetX(660);
        enemy6.setTargetY(580);
        
        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(1040, 550);
        Enemy enemy7 = buildDirector.getEnemy();
        enemy7.setTargetX(540);
        enemy7.setTargetY(550);
        
        numberOfEnemies = 8;
    }

    @Override
    public String getName() {
        return "Level 1";
    }

    @Override
    public void nextLevel() {
        Level level2 = new Level_2();
        Main.gameData.setCurrentLevel(level2);
    }
}
