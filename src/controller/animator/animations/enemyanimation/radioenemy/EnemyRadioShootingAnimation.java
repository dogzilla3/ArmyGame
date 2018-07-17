/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.animator.animations.enemyanimation.radioenemy;

import controller.animator.animations.enemyanimation.mortarenemy.*;
import controller.animator.animations.enemyanimation.flamerenemy.*;
import controller.animator.Animation;
import controller.animator.AnimationImage;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class EnemyRadioShootingAnimation extends Animation {

    private final AnimationImage start;
    private final AnimationImage shooting1;
    private final AnimationImage shooting2;
    private final AnimationImage shooting3;
    private int displayTime = 5;

    public EnemyRadioShootingAnimation() {
        start = new AnimationImage(ImageUtilities.ENEMY_RADIO_SHOOTING_1, 1);
        shooting1 = new AnimationImage(ImageUtilities.ENEMY_RADIO_SHOOTING_2, 1);
        shooting2 = new AnimationImage(ImageUtilities.ENEMY_RADIO_SHOOTING_3, 1);
        shooting3 = new AnimationImage(ImageUtilities.ENEMY_RADIO_SHOOTING_4, 1);
        start.setNextImage(shooting1);
        shooting1.setNextImage(shooting2);
        shooting2.setNextImage(shooting3);
        shooting3.setNextImage(start);
    }

    @Override
    public AnimationImage getStart() {
        return start;
    }

}
