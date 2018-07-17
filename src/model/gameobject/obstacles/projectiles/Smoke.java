/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.obstacles.projectiles;

import controller.Main;
import model.gameobject.GameObject;
import model.gameobject.actors.Actor;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class Smoke extends GameObject {

    private int damage = 20;

    public Smoke(float x, float y, float initialSize, float rotation) {
        super(x, y);
        this.size = initialSize;
        this.rotation = rotation;
        this.image = ImageUtilities.SMOKE;
        this.isFriend = false;
    }

    @Override
    public void update() {
        checkDone();
        rotation += 5;
        x += 2;
        if (alpha > 0.01) {
            setAlpha(getAlpha() - 0.01f);
        }
        if (size < 1.5) {
            size += 0.05;
        } else {
            isDone = true;
        }
    }

    public void initialize() {
        size = 0.1f;
        drawLayer = 3;
        setAlpha(1f);
        setImage(ImageUtilities.SMOKE);
        this.width = image.getWidth();
        this.height = image.getHeight();
        Main.gameData.renderObjects.add(this);
    }
}
