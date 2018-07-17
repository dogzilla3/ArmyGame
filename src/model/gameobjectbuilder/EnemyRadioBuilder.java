/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobjectbuilder;

import controller.animator.Animator;
import controller.animator.animations.enemyanimation.enemysniper.EnemySniperIdleAnimation;
import controller.animator.animations.enemyanimation.enemysniper.EnemySniperShootingAnimation;
import controller.animator.animations.enemyanimation.radioenemy.EnemyRadioIdleAnimation;
import controller.animator.animations.enemyanimation.radioenemy.EnemyRadioShootingAnimation;
import model.gameobject.actors.enemies.radioenemy.EnemyRadioIdleState;
import model.gameobject.actors.enemies.radioenemy.RadioEnemy;
import model.gameobject.actors.enemies.sniperenemy.EnemySniperIdleState;
import model.gameobject.actors.enemies.sniperenemy.SniperEnemy;
import model.weapons.enemyweapons.EnemySniperRifle;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class EnemyRadioBuilder extends EnemyBuilder{

    @Override
    public void buildBase(float x, float y) {
        enemy = new RadioEnemy(x,y);
        enemy.setState(new EnemyRadioIdleState((RadioEnemy)enemy));
    }

    @Override
    public void buildWeapon() {
        enemy.setWeapon(null);
    }

    @Override
    public void buildAnimator() {
        Animator animator = new Animator(enemy);
        animator.addAnimation("Idle", new EnemyRadioIdleAnimation());
        animator.addAnimation("Shooting", new EnemyRadioShootingAnimation());
        animator.setAnimation("Idle");
        enemy.setAnimator(animator);
    }

    @Override
    public void buildImage() {
        enemy.setImage(ImageUtilities.ENEMY_RADIO_IDLE);
        enemy.setWidth(enemy.getImage().getWidth());
        enemy.setHeight(enemy.getImage().getHeight());
    }
    
}
