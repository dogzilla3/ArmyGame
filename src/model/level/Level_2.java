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
import model.gameobject.obstacles.rocks.Rock2;
import model.gameobject.obstacles.rocks.Rock3;
import model.gameobject.obstacles.trees.TreeLeaves1;
import model.gameobject.obstacles.trees.TreeLeaves2;
import model.gameobject.obstacles.trees.TreeTrunk;
import utility.ImageUtilities;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class Level_2 extends Level {

    public Level_2() {
        System.out.println("New test level created");
    }

    @Override
    public void initialize() {
        Player hero = new Player(150, 500);
        getLevelObjects().add(hero);
        levelFriendCollideables.add(hero);
        Main.gameData.setPlayer(hero);

        for (int i = 30; i < 550; i += 70) {
            TreeTrunk treeTrunk2 = new TreeTrunk(30, i);
            Main.gameData.renderObjects.add(treeTrunk2);
            Main.gameData.obstacleColliders.add(treeTrunk2);
            int leaves = Utilities.randInt(1, 2);
            if (leaves == 1) {
                Main.gameData.renderObjects.add(new TreeLeaves1(30, i));
            } else {
                Main.gameData.renderObjects.add(new TreeLeaves2(30, i));
            }
        }

        Main.gameData.renderObjects.add(new TreeLeaves2(100, 100));
        buildDirector.setEnemyBuilder(flamerBuilder);
        buildDirector.constructEnemy(100, 100);
        Enemy enemy3 = buildDirector.getEnemy();
        enemy3.setTargetX(0);
        enemy3.setTargetX(0);

        for (int i = 30; i < 430; i += 70) {
            TreeTrunk treeTrunk2 = new TreeTrunk(550, i);
            Main.gameData.renderObjects.add(treeTrunk2);
            Main.gameData.obstacleColliders.add(treeTrunk2);
            int leaves = Utilities.randInt(1, 2);
            if (leaves == 1) {
                Main.gameData.renderObjects.add(new TreeLeaves1(550, i));
            } else {
                Main.gameData.renderObjects.add(new TreeLeaves2(550, i));
            }
        }

        Main.gameData.renderObjects.add(new TreeLeaves1(480, 100));
        buildDirector.setEnemyBuilder(flamerBuilder);
        buildDirector.constructEnemy(480, 100);
        Enemy enemy4 = buildDirector.getEnemy();
        enemy4.setTargetX(0);
        enemy4.setTargetX(0);

        for (int i = 240; i < 650; i += 70) {
            TreeTrunk treeTrunk2 = new TreeTrunk(300, i);
            Main.gameData.renderObjects.add(treeTrunk2);
            Main.gameData.obstacleColliders.add(treeTrunk2);
            int leaves = Utilities.randInt(1, 2);
            if (leaves == 1) {
                Main.gameData.renderObjects.add(new TreeLeaves1(300, i));
            } else {
                Main.gameData.renderObjects.add(new TreeLeaves2(300, i));
            }
        }

        for (int i = 30; i < 1150; i += 70) {
            TreeTrunk treeTrunk2 = new TreeTrunk(i, 30);
            Main.gameData.renderObjects.add(treeTrunk2);
            Main.gameData.obstacleColliders.add(treeTrunk2);
            int leaves = Utilities.randInt(1, 2);
            if (leaves == 1) {
                Main.gameData.renderObjects.add(new TreeLeaves1(i, 30));
            } else {
                Main.gameData.renderObjects.add(new TreeLeaves2(i, 30));
            }
        }

        Main.gameData.renderObjects.add(new TreeLeaves1(400, 500));

        for (int i = 300; i < 1100; i += 70) {
            TreeTrunk treeTrunk2 = new TreeTrunk(i, 580);
            Main.gameData.renderObjects.add(treeTrunk2);
            Main.gameData.obstacleColliders.add(treeTrunk2);
            int leaves = Utilities.randInt(1, 2);
            if (leaves == 1) {
                Main.gameData.renderObjects.add(new TreeLeaves1(i, 580));
            } else {
                Main.gameData.renderObjects.add(new TreeLeaves2(i, 580));
            }
        }

        TreeTrunk treeTrunk3 = new TreeTrunk(850, 150);
        Main.gameData.renderObjects.add(treeTrunk3);
        Main.gameData.obstacleColliders.add(treeTrunk3);
        Main.gameData.renderObjects.add(new TreeLeaves2(850, 150));

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(675, 100);
        Enemy enemy = buildDirector.getEnemy();
        enemy.setTargetX(675);
        enemy.setTargetY(480);

        buildDirector.setEnemyBuilder(mortarBuilder);
        buildDirector.constructEnemy(1100, 320);
        Enemy enemy5 = buildDirector.getEnemy();
        enemy5.setTargetX(0);
        enemy5.setTargetX(0);

        Rock1 sandBag1 = new Rock1(1050, 270);
        sandBag1.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag1);
        Main.gameData.obstacleColliders.add(sandBag1);

        Rock1 sandBag3 = new Rock1(1080, 240);
        sandBag3.setRotation(90);
        sandBag3.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag3);
        Main.gameData.obstacleColliders.add(sandBag3);

        Rock1 sandBag2 = new Rock1(1060, 250);
        sandBag2.setImage(ImageUtilities.SANDBAG);
        sandBag2.setRotation(45);
        Main.gameData.renderObjects.add(sandBag2);
        Main.gameData.obstacleColliders.add(sandBag2);

        Rock1 sandBag4 = new Rock1(1050, 360);
        sandBag4.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag4);
        Main.gameData.obstacleColliders.add(sandBag4);

        Rock1 sandBag5 = new Rock1(1080, 390);
        sandBag5.setRotation(90);
        sandBag5.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag5);
        Main.gameData.obstacleColliders.add(sandBag5);

        Rock1 sandBag6 = new Rock1(1060, 380);
        sandBag6.setImage(ImageUtilities.SANDBAG);
        sandBag6.setRotation(135);
        Main.gameData.renderObjects.add(sandBag6);
        Main.gameData.obstacleColliders.add(sandBag6);

        Rock1 rock1 = new Rock1(800, 470);
        rock1.setRotation(90);
        Main.gameData.renderObjects.add(rock1);
        Main.gameData.obstacleColliders.add(rock1);
        Rock1 rock2 = new Rock1(830, 480);
        rock2.setRotation(0);
        Main.gameData.renderObjects.add(rock2);
        Main.gameData.obstacleColliders.add(rock2);
        Rock2 rock3 = new Rock2(930, 280);
        rock3.setRotation(0);
        Main.gameData.renderObjects.add(rock3);
        Main.gameData.obstacleColliders.add(rock3);
        Rock3 rock4 = new Rock3(900, 250);
        rock3.setRotation(0);
        Main.gameData.renderObjects.add(rock4);
        Main.gameData.obstacleColliders.add(rock4);

        buildDirector.setEnemyBuilder(flamerBuilder);
        buildDirector.constructEnemy(620, 475);
        Enemy enemy6 = buildDirector.getEnemy();
        enemy6.setTargetX(0);
        enemy6.setTargetX(0);

        buildDirector.setEnemyBuilder(flamerBuilder);
        buildDirector.constructEnemy(550, 475);
        Enemy enemy7 = buildDirector.getEnemy();
        enemy7.setTargetX(0);
        enemy7.setTargetX(0);

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(1100, 175);
        Enemy enemy8 = buildDirector.getEnemy();
        enemy8.setTargetX(950);
        enemy8.setTargetY(150);

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(1100, 450);
        Enemy enemy9 = buildDirector.getEnemy();
        enemy9.setTargetX(950);
        enemy9.setTargetY(475);

        MedKitPickup medKitPickup = new MedKitPickup(475, 450);
        Main.gameData.renderObjects.add(medKitPickup);
        Main.gameData.enemyColliders.add(medKitPickup);

        MachineGunPickup machineGunPickup = new MachineGunPickup(400, 500);
        Main.gameData.renderObjects.add(machineGunPickup);
        Main.gameData.enemyColliders.add(machineGunPickup);

        numberOfEnemies = 8;
    }

    @Override
    public String getName() {
        return "Level 2";
    }

    @Override
    public void nextLevel() {
        Level level3 = new Level_3();
        Main.gameData.setCurrentLevel(level3);
    }
}
