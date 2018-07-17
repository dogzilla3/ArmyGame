/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.animator.animations.enemyanimation.radioenemy;

import controller.animator.Animation;
import controller.animator.AnimationImage;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class EnemyRadioIdleAnimation extends Animation{
    private final AnimationImage start;
    private final AnimationImage idle1;
    private final AnimationImage idle2;
    private int displayTime = 25;

    public EnemyRadioIdleAnimation() {
        start = new AnimationImage(ImageUtilities.ENEMY_RADIO_IDLE, displayTime);
        idle1 = new AnimationImage(ImageUtilities.ENEMY_RADIO_IDLE_1, displayTime);
        idle2 = new AnimationImage(ImageUtilities.ENEMY_RADIO_IDLE_2, displayTime);
        start.setNextImage(idle1);
        idle1.setNextImage(idle2);
        idle2.setNextImage(start);
    }

    @Override
    public AnimationImage getStart() {
        return start;
    }
}
