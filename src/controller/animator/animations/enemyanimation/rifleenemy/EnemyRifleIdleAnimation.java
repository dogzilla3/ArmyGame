/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.animator.animations.enemyanimation.rifleenemy;

import controller.animator.Animation;
import controller.animator.AnimationImage;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class EnemyRifleIdleAnimation extends Animation{
    private final AnimationImage start;
    private final AnimationImage lookLeft;
    private final AnimationImage lookRight;
    private final AnimationImage lookCenter;
    private int displayTime = 40;

    public EnemyRifleIdleAnimation() {
        start = new AnimationImage(ImageUtilities.ENEMY_RIFLE, displayTime);
        lookLeft = new AnimationImage(ImageUtilities.ENEMY_RIFLE_IDLE_1, displayTime);
        lookCenter = new AnimationImage(ImageUtilities.ENEMY_RIFLE, displayTime);
        lookRight = new AnimationImage(ImageUtilities.ENEMY_RIFLE_IDLE_2, displayTime);
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
