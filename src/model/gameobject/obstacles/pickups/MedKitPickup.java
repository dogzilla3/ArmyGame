/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.obstacles.pickups;

import controller.Main;
import model.gameobject.obstacles.rocks.*;
import model.gameobject.actors.Actor;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import model.gameobject.GameObject;
import model.gameobject.actors.Actor;
import model.gameobject.CollisionBox;
import model.Collideable;
import model.gameobject.actors.player.Player;
import model.weapons.playerweapons.HeroMachineGun;
import utility.ImageUtilities;
import utility.Utilities;
import view.GamePanel;

/**
 *
 * @author Greg
 */
public class MedKitPickup extends GameObject implements Collideable {

    public MedKitPickup(float x, float y) {
        super(x, y);
        setImage(ImageUtilities.PICK_UP_MED_KIT);
        this.isFriend = false;
    }

    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox((int) (x - (width / 2)), (int) (y - (height / 2)), (int) width - 2, (int) height - 2, this);
    }

    @Override
    public void onCollision(Collideable collider) {
        if (collider.getCollisionBox().getOwner() instanceof Player) {
            System.out.println("Pickup!!! MediKit!");
            Player owner = (Player) collider.getCollisionBox().getOwner();
            owner.setHealth(100);
            GamePanel.health = 100;
            Main.gameData.renderObjects.remove(this);
            Main.gameData.enemyColliders.remove(this);
            isDone = true;
        }

    }

    @Override
    public void debugLog() {

    }
}
