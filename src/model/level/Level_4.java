/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.level;

import controller.Main;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.bossenemy.BossEnemy;
import model.gameobject.actors.enemies.radioenemy.RadioEnemy;
import model.gameobject.actors.enemies.sniperenemy.EnemySniperAppearState;
import model.gameobject.actors.enemies.sniperenemy.EnemySniperDisappearState;
import model.gameobject.actors.enemies.sniperenemy.EnemySniperShootingState;
import model.gameobject.actors.enemies.sniperenemy.SniperEnemy;
import model.gameobject.actors.player.Player;
import model.gameobject.obstacles.pickups.MedKitPickup;
import model.gameobject.obstacles.pickups.RocketLauncherPickup;
import model.gameobject.obstacles.rocks.Rock1;
import model.gameobject.obstacles.rocks.Rock2;
import model.gameobject.obstacles.rocks.Rock3;
import model.gameobject.obstacles.trees.TreeLeaves1;
import model.gameobject.obstacles.trees.TreeLeaves2;
import utility.ImageUtilities;
import view.MainWindow;

/**
 *
 * @author Greg
 */
public class Level_4 extends Level {

    public Level_4() {
        System.out.println("New test level created");
    }

    @Override
    public void initialize() {
        Player hero = new Player(75, 55);
        getLevelObjects().add(hero);
        levelFriendCollideables.add(hero);
        Main.gameData.setPlayer(hero);

        buildDirector.setEnemyBuilder(tankBuilder);
        buildDirector.constructEnemy(1050, 300);
        BossEnemy enemy = (BossEnemy) buildDirector.getEnemy();
        enemy.setRotation(180);

        Rock1 sandBag1 = new Rock1(970, 25);
        sandBag1.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag1);
        Main.gameData.obstacleColliders.add(sandBag1);

        Rock1 sandBag8 = new Rock1(970, 75);
        sandBag8.setRotation(0);
        sandBag8.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag8);
        Main.gameData.obstacleColliders.add(sandBag8);

        Rock1 sandBag7 = new Rock1(970, 125);
        sandBag7.setRotation(0);
        sandBag7.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag7);
        Main.gameData.obstacleColliders.add(sandBag7);

        Rock1 sandBag3 = new Rock1(1005, 150);
        sandBag3.setRotation(90);
        sandBag3.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag3);
        Main.gameData.obstacleColliders.add(sandBag3);

        Rock1 sandBag2 = new Rock1(978, 143);
        sandBag2.setImage(ImageUtilities.SANDBAG);
        sandBag2.setRotation(135);
        Main.gameData.renderObjects.add(sandBag2);
        Main.gameData.obstacleColliders.add(sandBag2);

        Rock1 sandBag10 = new Rock1(970, 50);
        sandBag10.setRotation(0);
        sandBag10.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag10);
        Main.gameData.obstacleColliders.add(sandBag10);

        Rock1 sandBag9 = new Rock1(970, 98);
        sandBag9.setRotation(0);
        sandBag9.setImage(ImageUtilities.SANDBAG);
        Main.gameData.renderObjects.add(sandBag9);
        Main.gameData.obstacleColliders.add(sandBag9);

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

        buildDirector.setEnemyBuilder(mortarBuilder);
        buildDirector.constructEnemy(1075, 550);
        Enemy enemy4 = buildDirector.getEnemy();
        enemy4.setTargetX(800);
        enemy4.setTargetX(500);

        buildDirector.setEnemyBuilder(radioBuilder);
        buildDirector.constructEnemy(1075, 50);
        RadioEnemy enemy1 = (RadioEnemy) buildDirector.getEnemy();

        Rock1 rock3 = new Rock1(585, 275);
        rock3.setRotation(90);
        Main.gameData.renderObjects.add(rock3);
        Main.gameData.obstacleColliders.add(rock3);

        Rock1 rock4 = new Rock1(585, 375);
        rock4.setRotation(135);
        Main.gameData.renderObjects.add(rock4);
        Main.gameData.obstacleColliders.add(rock4);

        Rock1 rock1 = new Rock1(800, 470);
        rock1.setRotation(90);
        Main.gameData.renderObjects.add(rock1);
        Main.gameData.obstacleColliders.add(rock1);

        Rock1 rock2 = new Rock1(830, 480);
        rock2.setRotation(0);
        Main.gameData.renderObjects.add(rock2);
        Main.gameData.obstacleColliders.add(rock2);

        Rock2 rock5 = new Rock2(930, 280);
        rock3.setRotation(0);
        Main.gameData.renderObjects.add(rock5);
        Main.gameData.obstacleColliders.add(rock5);

        Rock3 rock6 = new Rock3(200, 70);
        rock3.setRotation(0);
        Main.gameData.renderObjects.add(rock6);
        Main.gameData.obstacleColliders.add(rock6);

        Rock1 rock7 = new Rock1(400, 530);
        rock1.setRotation(90);
        Main.gameData.renderObjects.add(rock7);
        Main.gameData.obstacleColliders.add(rock7);

        Rock1 rock8 = new Rock1(430, 540);
        rock2.setRotation(0);
        Main.gameData.renderObjects.add(rock8);
        Main.gameData.obstacleColliders.add(rock8);

        Main.gameData.renderObjects.add(new TreeLeaves1(270, 475));
        Main.gameData.renderObjects.add(new TreeLeaves2(100, 200));

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(900, 100);
        Enemy enemy3 = buildDirector.getEnemy();
        enemy3.setTargetX(200);
        enemy3.setTargetY(100);

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(900, 200);
        Enemy enemy5 = buildDirector.getEnemy();
        enemy5.setTargetX(200);
        enemy5.setTargetY(200);

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(900, 400);
        Enemy enemy6 = buildDirector.getEnemy();
        enemy6.setTargetX(200);
        enemy6.setTargetY(400);

        buildDirector.setEnemyBuilder(rifleBuilder);
        buildDirector.constructEnemy(900, 475);
        Enemy enemy7 = buildDirector.getEnemy();
        enemy7.setTargetX(200);
        enemy7.setTargetY(475);

        MedKitPickup medKitPickup = new MedKitPickup(400, 200);
        Main.gameData.renderObjects.add(medKitPickup);
        Main.gameData.enemyColliders.add(medKitPickup);

        MedKitPickup medKitPickup1 = new MedKitPickup(600, 550);
        Main.gameData.renderObjects.add(medKitPickup1);
        Main.gameData.enemyColliders.add(medKitPickup1);

        RocketLauncherPickup rocketLauncherPickup = new RocketLauncherPickup(270, 475);
        Main.gameData.renderObjects.add(rocketLauncherPickup);
        Main.gameData.enemyColliders.add(rocketLauncherPickup);
        
        RocketLauncherPickup rocketLauncherPickup1 = new RocketLauncherPickup(680, 150);
        Main.gameData.renderObjects.add(rocketLauncherPickup1);
        Main.gameData.enemyColliders.add(rocketLauncherPickup1);

        numberOfEnemies = 7;
    }

    @Override
    public String getName() {
        return "Level 4";
    }

    @Override
    public void nextLevel() {
        Main.gameEngine.gameWon();
        
    }
}
