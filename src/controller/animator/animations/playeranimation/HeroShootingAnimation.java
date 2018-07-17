/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.animator.animations.playeranimation;


import controller.animator.Animation;
import controller.animator.AnimationImage;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class HeroShootingAnimation extends Animation {

    private final AnimationImage start;
    private int displayTime = 10;
    
    public HeroShootingAnimation(){  
        start = new AnimationImage(ImageUtilities.HERO_SHOOTING, displayTime);
        start.setNextImage(start);
    }

    @Override
    public AnimationImage getStart() { 
        return start;
    }

}
