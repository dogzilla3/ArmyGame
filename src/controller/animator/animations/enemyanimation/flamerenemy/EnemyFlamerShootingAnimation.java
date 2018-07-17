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
public class EnemyFlamerShootingAnimation extends Animation {

    private final AnimationImage start;
    //private final AnimationImage shooting1;
    //private final AnimationImage shooting2;
    private final AnimationImage shooting3;
    private int displayTime = 1;

    public EnemyFlamerShootingAnimation() {
        start = new AnimationImage(ImageUtilities.ENEMY_FLAMER_SHOOTING_1, displayTime);
        //shooting1 = new AnimationImage(ImageUtilities.ENEMY_FLAMER_SHOOTING_2, displayTime);
        //shooting2 = new AnimationImage(ImageUtilities.ENEMY_FLAMER_SHOOTING_3, displayTime);
        shooting3 = new AnimationImage(ImageUtilities.ENEMY_FLAMER_SHOOTING_2, displayTime);
        start.setNextImage(shooting3);
        shooting3.setNextImage(start);
        /*shooting2.setNextImage(shooting3);
        shooting3.setNextImage(start);*/
    }

    @Override
    public AnimationImage getStart() {
        return start;
    }

}
