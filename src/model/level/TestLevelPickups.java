/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.level;

import controller.Main;
import model.gameobject.actors.player.Player;
import model.gameobject.obstacles.pickups.MachineGunPickup;
import model.gameobject.obstacles.pickups.MedKitPickup;
import model.gameobject.obstacles.pickups.RocketLauncherPickup;

/**
 *
 * @author Greg
 */
public class TestLevelPickups extends Level {

    @Override
    public void initialize() {
        Player hero = new Player(50, 50);
        getLevelObjects().add(hero);
        levelFriendCollideables.add(hero);
        Main.gameData.setPlayer(hero);

        MachineGunPickup machineGunPickup = new MachineGunPickup(300, 300);
        Main.gameData.renderObjects.add(machineGunPickup);
        Main.gameData.enemyColliders.add(machineGunPickup);

        RocketLauncherPickup rocketLauncherPickup = new RocketLauncherPickup(200, 100);
        Main.gameData.renderObjects.add(rocketLauncherPickup);
        Main.gameData.enemyColliders.add(rocketLauncherPickup);

        MedKitPickup medKitPickup = new MedKitPickup(400, 200);
        Main.gameData.renderObjects.add(medKitPickup);
        Main.gameData.enemyColliders.add(medKitPickup);

        numberOfEnemies = 10;
    }

    @Override
    public String getName() {
        return "Test Level Pickups";
    }

    @Override
    public void nextLevel() {
        //test level no next level
    }
}
