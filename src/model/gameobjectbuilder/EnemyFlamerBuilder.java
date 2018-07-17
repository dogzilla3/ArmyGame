/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobjectbuilder;

import controller.animator.animations.enemyanimation.flamerenemy.EnemyFlamerDyingAnimation;
import controller.animator.animations.enemyanimation.flamerenemy.EnemyFlamerWalkAnimation;
import controller.animator.animations.enemyanimation.flamerenemy.EnemyFlamerShootingAnimation;
import controller.animator.animations.enemyanimation.flamerenemy.EnemyFlamerIdleAnimation;
import controller.animator.Animator;
import model.gameobject.actors.enemies.flamerenemy.*;
import model.weapons.enemyweapons.FlameThrower;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class EnemyFlamerBuilder extends EnemyBuilder{
    
    @Override
    public void buildBase(float x, float y) {
        enemy = new FlamerEnemy(x,y);
        enemy.setState(new EnemyFlamerIdleState(enemy));
    }

    @Override
    public void buildWeapon() {
        enemy.setWeapon(new FlameThrower(enemy));
    }

    @Override
    public void buildAnimator() {
        Animator animator = new Animator(enemy);
        animator.addAnimation("Walking", new EnemyFlamerWalkAnimation());
        animator.addAnimation("Idle", new EnemyFlamerIdleAnimation());
        animator.addAnimation("Shooting", new EnemyFlamerShootingAnimation());
        animator.addAnimation("Dying", new EnemyFlamerDyingAnimation());
        animator.setAnimation("Idle");
        enemy.setAnimator(animator);
    }

    @Override
    public void buildImage() {
        enemy.setImage(ImageUtilities.ENEMY_FLAMER);
        enemy.setWidth(enemy.getImage().getWidth());
        enemy.setHeight(enemy.getImage().getHeight());
    }
}
