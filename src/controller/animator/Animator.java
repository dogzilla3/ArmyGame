/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.animator;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import model.gameobject.actors.Actor;

/**
 *
 * @author Greg
 */
public class Animator {

    private final Actor actor;
    private final HashMap<String, Animation> animations = new HashMap<>();
    private Animation activeAnimation;
    private AnimationImage displayImage;
    
    public Animator(Actor actor){
        this.actor = actor;
    }
    
    public final BufferedImage getDisplayImage(String string){
        return displayImage.getImage();
    }
    
    public final void setAnimation(String string){
        activeAnimation = animations.get(string);
        displayImage = activeAnimation.getStart();
        actor.changeImage(displayImage.getImage());
    }
    
    public final void addAnimation(String name, Animation image){
        animations.put(name, image);
    }
    
    public void animate(){  
        if(displayImage.getCountDownTime() > 0){
            displayImage.decrementCountDownTime();
        }
        else{
            displayImage.resetCountdownTime();
            displayImage = displayImage.getNextImage();
            actor.setImage(displayImage.getImage());
        }
    }
}
