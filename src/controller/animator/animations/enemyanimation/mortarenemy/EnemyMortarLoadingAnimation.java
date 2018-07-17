/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.animator.animations.enemyanimation.mortarenemy;

import controller.animator.animations.enemyanimation.flamerenemy.*;
import controller.animator.Animation;
import controller.animator.AnimationImage;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class EnemyMortarLoadingAnimation extends Animation {

    private final AnimationImage start;
    private final AnimationImage loading1;
    private final AnimationImage loading2;
    private final AnimationImage loading3;
    private final AnimationImage loading4;
    private final AnimationImage loading5;
    private final AnimationImage loading6;
    private final AnimationImage loading7;
    private final AnimationImage loading8;
    private int displayTime = 20;

    public EnemyMortarLoadingAnimation() {
        start = new AnimationImage(ImageUtilities.ENEMY_MORTAR, 30);
        loading1 = new AnimationImage(ImageUtilities.ENEMY_MORTAR_1, displayTime);
        loading2 = new AnimationImage(ImageUtilities.ENEMY_MORTAR_2, displayTime);
        loading3 = new AnimationImage(ImageUtilities.ENEMY_MORTAR_3, displayTime);
        loading4 = new AnimationImage(ImageUtilities.ENEMY_MORTAR_4, displayTime);
        loading5 = new AnimationImage(ImageUtilities.ENEMY_MORTAR_5, displayTime);
        loading6 = new AnimationImage(ImageUtilities.ENEMY_MORTAR_6, displayTime);
        loading7 = new AnimationImage(ImageUtilities.ENEMY_MORTAR_7, displayTime);
        loading8 = new AnimationImage(ImageUtilities.ENEMY_MORTAR_8, 30);
        start.setNextImage(loading1);
        loading1.setNextImage(loading2);
        loading2.setNextImage(loading3);
        loading3.setNextImage(loading4);
        loading4.setNextImage(loading5);
        loading5.setNextImage(loading6);
        loading6.setNextImage(loading7);
        loading7.setNextImage(loading8);
        loading8.setNextImage(start);
    }

    @Override
    public AnimationImage getStart() {
        return start;
    }

}
