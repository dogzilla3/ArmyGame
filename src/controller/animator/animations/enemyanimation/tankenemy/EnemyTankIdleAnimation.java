/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.animator.animations.enemyanimation.tankenemy;

import controller.animator.animations.enemyanimation.rifleenemy.*;
import controller.animator.Animation;
import controller.animator.AnimationImage;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class EnemyTankIdleAnimation extends Animation{
    private final AnimationImage start;
    private final AnimationImage lookLeft;
    private final AnimationImage lookRight;
    private final AnimationImage lookCenter;
    private int displayTime = 40;

    public EnemyTankIdleAnimation() {
        start = new AnimationImage(ImageUtilities.ENEMY_TANK_TURRET_1, displayTime);
        lookLeft = new AnimationImage(ImageUtilities.ENEMY_TANK_TURRET_3, 70);
        lookCenter = new AnimationImage(ImageUtilities.ENEMY_TANK_TURRET_2, displayTime);
        lookRight = new AnimationImage(ImageUtilities.ENEMY_TANK_TURRET_1, displayTime);
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
