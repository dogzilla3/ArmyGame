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
public class HeroIdleAnimation extends Animation {

    private AnimationImage start;
    private AnimationImage lookLeft;
    private AnimationImage lookRight;
    private AnimationImage lookCenter;
    private int displayTime = 40;

    public HeroIdleAnimation() {
        start = new AnimationImage(ImageUtilities.HERO, displayTime);
        lookLeft = new AnimationImage(ImageUtilities.HERO_IDLE_1, displayTime);
        lookCenter = new AnimationImage(ImageUtilities.HERO, displayTime);
        lookRight = new AnimationImage(ImageUtilities.HERO_IDLE_2, displayTime);
        start.setNextImage(lookLeft);
        lookLeft.setNextImage(lookCenter);
        lookCenter.setNextImage(lookRight);
        lookRight.setNextImage(start);
    }

    @Override
    public AnimationImage getStart() {
        return start;
    }
}
