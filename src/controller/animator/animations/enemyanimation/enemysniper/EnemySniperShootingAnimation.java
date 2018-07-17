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
public class EnemySniperShootingAnimation extends Animation{
    private final AnimationImage start;
    private final AnimationImage shooting1;
    private final AnimationImage shooting2;
    private final AnimationImage shooting3;
    private final AnimationImage idle;
    private int displayTime = 20;

    public EnemySniperShootingAnimation() {
        start = new AnimationImage(ImageUtilities.ENEMY_SNIPER_SHOOTING, 10);
        shooting1 = new AnimationImage(ImageUtilities.ENEMY_SNIPER_SHOOTING_1, displayTime);
        shooting2 = new AnimationImage(ImageUtilities.ENEMY_SNIPER_SHOOTING_2, displayTime);
        shooting3 = new AnimationImage(ImageUtilities.ENEMY_SNIPER_SHOOTING_3, displayTime);
        idle = new AnimationImage(ImageUtilities.ENEMY_SNIPER_IDLE, displayTime);
        start.setNextImage(shooting1);
        shooting1.setNextImage(shooting2);
        shooting2.setNextImage(shooting3);
        shooting3.setNextImage(idle);
        idle.setNextImage(idle);
    }

    @Override
    public AnimationImage getStart() {
        return start;
    }
}
