/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.animator;

import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Greg
 */
public class AnimationImage {
    
    private int displayTime;
    private int countDownTime;
    private BufferedImage image;
    private AnimationImage nextImage;

    public AnimationImage(BufferedImage image, int displayTime) {
        this.image = image;
        this.displayTime = displayTime;
        this.countDownTime = displayTime;
    }
    
    public BufferedImage getImage(){
        return image;
    }
    
    public int getDisplayTime(){
        return displayTime;
    }
    
    public void setDisplayTime(int time){
        this.displayTime = time;
    }
    
    public void setNextImage(AnimationImage image){
        this.nextImage = image;
    }
    
    public AnimationImage getNextImage(){
        return nextImage;
    }
    
    public void decrementCountDownTime(){
        countDownTime--;
    }
    
    public int getCountDownTime(){
        return countDownTime;
    }
    
    public void resetCountdownTime(){
        countDownTime = displayTime;
    }
}
