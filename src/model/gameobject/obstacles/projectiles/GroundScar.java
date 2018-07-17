/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.obstacles.projectiles;

import controller.Main;
import model.gameobject.GameObject;
import utility.ImageUtilities;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class GroundScar extends GameObject{
    
    public GroundScar(float x, float y) {
        super(x, y);
        this.rotation = Utilities.randInt(0, 360);
        this.image = ImageUtilities.GROUND_SCAR;
    }
    
    public void initialize() {
        size = 1f;
        drawLayer = 1;
        setImage(ImageUtilities.GROUND_SCAR);
        this.width = image.getWidth();
        this.height = image.getHeight();
        Main.gameData.renderObjects.add(this);
    }
}
