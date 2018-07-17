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
public class EnemyTankDyingAnimation extends Animation{
    private final AnimationImage start;
    private int displayTime = 40;

    public EnemyTankDyingAnimation() {
        start = new AnimationImage(ImageUtilities.ENEMY_TANK_TURRET_DYING, displayTime);
        start.setNextImage(start);
    }

    @Override
    public AnimationImage getStart() {
        return start;
    }
}
