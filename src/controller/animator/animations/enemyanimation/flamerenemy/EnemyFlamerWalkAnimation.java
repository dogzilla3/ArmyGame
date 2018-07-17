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
public class EnemyFlamerWalkAnimation extends Animation{
    private final AnimationImage start;
    private final AnimationImage walking1;
    private final AnimationImage walking2;
    private final AnimationImage walking3;
    private final int displayTime = 5;

    public EnemyFlamerWalkAnimation() {
        start = new AnimationImage(ImageUtilities.ENEMY_FLAMER, displayTime);
        walking1 = new AnimationImage(ImageUtilities.ENEMY_FLAMER_WALK_1, displayTime);
        walking2 = new AnimationImage(ImageUtilities.ENEMY_FLAMER, displayTime);
        walking3 = new AnimationImage(ImageUtilities.ENEMY_FLAMER_WALK_2, displayTime);
        start.setNextImage(walking1);
        walking1.setNextImage(walking2);
        walking2.setNextImage(walking3);
        walking3.setNextImage(start);
    }

    @Override
    public AnimationImage getStart() {
        return start;
    }
}
