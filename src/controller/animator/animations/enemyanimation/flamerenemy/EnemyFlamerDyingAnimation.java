/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.animator.animations.enemyanimation.flamerenemy;

import controller.animator.Animation;
import controller.animator.AnimationImage;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class EnemyFlamerDyingAnimation extends Animation{
    
    private final AnimationImage start;
    private final AnimationImage lookLeft;
    private int displayTime = 8;

    public EnemyFlamerDyingAnimation() {
        start = new AnimationImage(ImageUtilities.ENEMY_FLAMER_DYING_1, displayTime);
        lookLeft = new AnimationImage(ImageUtilities.ENEMY_FLAMER_DYING_2, displayTime);
        start.setNextImage(lookLeft);
        lookLeft.setNextImage(start);
    }

    @Override
    public AnimationImage getStart() {
        return start;
    }
}
