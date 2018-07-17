/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.animator.animations.enemyanimation.enemysniper;

import controller.animator.Animation;
import controller.animator.AnimationImage;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class EnemySniperIdleAnimation extends Animation{
    private final AnimationImage start;
    private int displayTime = 50;

    public EnemySniperIdleAnimation() {
        start = new AnimationImage(ImageUtilities.ENEMY_SNIPER_IDLE, displayTime);
        start.setNextImage(start);
    }

    @Override
    public AnimationImage getStart() {
        return start;
    }
}
