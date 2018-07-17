/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import controller.Main;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Greg
 */
public class Utilities {

    public static Random rand = new Random();
    
    /**
     * This function returns the angel between two vectors
     * @param sourceX X coordinate of the source vector
     * @param sourceY Y coordinate of the source vector
     * @param targetX X coordinate of the target object 
     * @param targetY Y coordinate of the target object
     * @return the angle in degrees
     */
    public static float getAngle(float sourceX, float sourceY, float targetX, float targetY) {
        float rotation = (float) Math.toDegrees((float) Math.atan2((targetY - sourceY), (targetX - sourceX)));
        if (rotation < 0) {
            rotation += 360;
        }
        return rotation;
    }
    
    /**
     * This function checks whether an object resides within the game window
     * @param x X coordinate of the object to be checked
     * @param y Y coordinate of the object to be checked
     * @return a boolean value true if it resides in bounds false otherwise
     */
    public static boolean inBounds(float x, float y) {
        float levelWidth = Main.gameData.getCurrentLevel().getWidth();
        float levelHeight = Main.gameData.getCurrentLevel().getHeight();

        if (x > levelWidth || x < 0) {
            return false;
        } else if (y > levelHeight || y < 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public static int randInt(int min, int max){
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
