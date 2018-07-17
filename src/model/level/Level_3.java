/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.level;

import controller.Main;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.radioenemy.RadioEnemy;
import model.gameobject.actors.enemies.sniperenemy.EnemySniperAppearState;
import model.gameobject.actors.enemies.sniperenemy.EnemySniperDisappearState;
import model.gameobject.actors.enemies.sniperenemy.EnemySniperIdleState;
import model.gameobject.actors.enemies.sniperenemy.EnemySniperShootingState;
import model.gameobject.actors.enemies.sniperenemy.SniperEnemy;
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
public class Level_3 extends Level {

    public Level_3() {
        System.out.println("New test level created");
    }

    @Override
    public void initialize() {
        Player hero = new Player(75, 55);
        getLevelObjects().add(hero);
        levelFriendCollideables.add(hero);
        Main.gameData.setPlayer(hero);

        Main.gameData.renderObjects.add(new TreeLeaves2(500, 35));
        buildDirector.setEnemyBuilder(sniperBuilder);
        buildDirector.constructEnemy(490, 90);
        SniperEnemy enemy = (SniperEnemy) buildDirector.getEnemy();
        enemy.setStartX(enemy.getX());
        enemy.setStartY(enemy.getY());
        enemy.setEndX(500);
        enemy.setEndY(550);
        Main.gameData.renderObjects.add(new TreeLeaves2(500, 610));

        Main.gameData.renderObjects.add(new TreeLeaves1(1000, 35));
        buildDirector.setEnemyBuilder(sniperBuilder);
        buildDirector.constructEnemy(995, 75);
        SniperEnemy enemy1 = (SniperEnemy) buildDirector.getEnemy();
        enemy1.setStartX(enemy1.getX());
        enemy1.setStartY(enemy1.getY());
        enemy1.setEndX(800);
        enemy1.setEndY(550);
        enemy1.setState(new EnemySniperDisappearState(enemy1));
        Main.gameData.renderObjects.add(new TreeLeaves1(800, 590));

        Main.gameData.renderObjects.add(new TreeLeaves1(750, 150));
        buildDirector.setEnemyBuilder(sniperBuilder);
        buildDirector.constructEnemy(750, 100);
        SniperEnemy enemy2 = (SniperEnemy) buildDirector.getEnemy();
        enemy2.setStartX(enemy2.getX());
        enemy2.setStartY(enemy2.getY());
        enemy2.setEndX(250);
        enemy2.setEndY(500);
        enemy2.setState(new EnemySniperShootingState(enemy2));
        Main.gameData.renderObjects.add(new TreeLeaves1(270, 575));

        Rock1 sandBag1 = new Rock1(170, 490);
        sandBag1.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag1);
        Main.gameData.obstacleColliders.add(sandBag1);

        Rock1 sandBag3 = new Rock1(200, 460);
        sandBag3.setRotation(90);
        sandBag3.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag3);
        Main.gameData.obstacleColliders.add(sandBag3);

        Rock1 sandBag8 = new Rock1(170, 590);
        sandBag8.setRotation(0);
        sandBag8.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag8);
        Main.gameData.obstacleColliders.add(sandBag8);

        Rock1 sandBag7 = new Rock1(170, 530);
        sandBag7.setRotation(0);
        sandBag7.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag7);
        Main.gameData.obstacleColliders.add(sandBag7);

        Rock1 sandBag10 = new Rock1(170, 520);
        sandBag10.setRotation(0);
        sandBag10.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag10);
        Main.gameData.obstacleColliders.add(sandBag10);

        Rock1 sandBag9 = new Rock1(170, 570);
        sandBag9.setRotation(0);
        sandBag9.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag9);
        Main.gameData.obstacleColliders.add(sandBag9);

        Rock1 sandBag2 = new Rock1(180, 470);
        sandBag2.setImage(ImageUtilities.SANDBAG);
        sandBag2.setRotation(45);
        Main.gameData.renderObjects.add(sandBag2);
        Main.gameData.obstacleColliders.add(sandBag2);

        Rock1 sandBag4 = new Rock1(360, 490);
        sandBag4.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag4);
        Main.gameData.obstacleColliders.add(sandBag4);

        Rock1 sandBag5 = new Rock1(330, 460);
        sandBag5.setRotation(90);
        sandBag5.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag5);
        Main.gameData.obstacleColliders.add(sandBag5);

        Rock1 sandBag6 = new Rock1(350, 470);
        sandBag6.setImage(ImageUtilities.SANDBAG);
        sandBag6.setRotation(135);
        Main.gameData.renderObjects.add(sandBag6);
        Main.gameData.obstacleColliders.add(sandBag6);

        Rock1 sandBag12 = new Rock1(970, 490);
        sandBag12.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag12);
        Main.gameData.obstacleColliders.add(sandBag12);

        Rock1 sandBag13 = new Rock1(1000, 460);
        sandBag13.setRotation(90);
        sandBag13.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag13);
        Main.gameData.obstacleColliders.add(sandBag13);

        Rock1 sandBag14 = new Rock1(970, 590);
        sandBag14.setRotation(0);
        sandBag14.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag14);
        Main.gameData.obstacleColliders.add(sandBag14);

        Rock1 sandBag15 = new Rock1(970, 530);
        sandBag15.setRotation(0);
        sandBag15.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag15);
        Main.gameData.obstacleColliders.add(sandBag15);

        Rock1 sandBag16 = new Rock1(970, 520);
        sandBag16.setRotation(0);
        sandBag16.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag16);
        Main.gameData.obstacleColliders.add(sandBag16);

        Rock1 sandBag17 = new Rock1(970, 570);
        sandBag17.setRotation(0);
        sandBag17.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag17);
        Main.gameData.obstacleColliders.add(sandBag17);

        Rock1 sandBag18 = new Rock1(980, 470);
        sandBag18.setImage(ImageUtilities.SANDBAG);
        sandBag18.setRotation(45);
        Main.gameData.renderObjects.add(sandBag18);
        Main.gameData.obstacleColliders.add(sandBag18);

        Rock1 sandBag19 = new Rock1(1160, 490);
        sandBag19.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag19);
        Main.gameData.obstacleColliders.add(sandBag19);

        Rock1 sandBag20 = new Rock1(1125, 460);
        sandBag20.setRotation(90);
        sandBag20.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag20);
        Main.gameData.obstacleColliders.add(sandBag20);

        Rock1 sandBag21 = new Rock1(1150, 470);
        sandBag21.setImage(ImageUtilities.SANDBAG);
        sandBag21.setRotation(135);
        Main.gameData.renderObjects.add(sandBag21);
        Main.gameData.obstacleColliders.add(sandBag21);
        
        Rock1 rock = new Rock1(820, 100);
        rock.setRotation(90);
        Main.gameData.renderObjects.add(rock);
        Main.gameData.obstacleColliders.add(rock);

        buildDirector.setEnemyBuilder(sniperBuilder);
        buildDirector.constructEnemy(925, 175);
        SniperEnemy enemy3 = (SniperEnemy) buildDirector.getEnemy();
        enemy3.setStartX(enemy3.getX());
        enemy3.setStartY(enemy3.getY());
        enemy3.setEndX(1100);
        enemy3.setEndY(425);
        enemy3.setState(new EnemySniperAppearState(enemy3));
        enemy3.setAlpha(0.02f);

        Rock1 rock1 = new Rock1(300, 150);
        rock1.setRotation(0);
        Main.gameData.renderObjects.add(rock1);
        Main.gameData.obstacleColliders.add(rock1);

        Rock1 rock2 = new Rock1(550, 250);
        rock2.setRotation(0);
        Main.gameData.renderObjects.add(rock2);
        Main.gameData.obstacleColliders.add(rock2);

        Rock1 rock3 = new Rock1(585, 275);
        rock3.setRotation(90);
        Main.gameData.renderObjects.add(rock3);
        Main.gameData.obstacleColliders.add(rock3);

        Rock1 rock4 = new Rock1(585, 375);
        rock4.setRotation(135);
        Main.gameData.renderObjects.add(rock4);
        Main.gameData.obstacleColliders.add(rock4);

        MedKitPickup medKitPickup = new MedKitPickup(535, 315);
        Main.gameData.renderObjects.add(medKitPickup);
        Main.gameData.enemyColliders.add(medKitPickup);
        
        Main.gameData.renderObjects.add(new TreeLeaves2(1100, 375));
        
        buildDirector.setEnemyBuilder(radioBuilder);
        buildDirector.constructEnemy(1065, 525);
        RadioEnemy enemy4 = (RadioEnemy) buildDirector.getEnemy();
        
        numberOfEnemies = 5;
    }

    @Override
    public String getName() {
        return "Level 3";
    }

    @Override
    public void nextLevel() {
        Level level4 = new Level_4();
        Main.gameData.setCurrentLevel(level4);
    }
}
