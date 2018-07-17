/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobjectbuilder;

import controller.animator.Animator;
import controller.animator.animations.enemyanimation.rifleenemy.EnemyRifleIdleAnimation;
import controller.animator.animations.enemyanimation.rifleenemy.EnemyRifleShootingAnimation;
import controller.animator.animations.enemyanimation.rifleenemy.EnemyRifleWalkAnimation;
import model.gameobject.actors.enemies.rifleenemy.EnemyRifleIdleState;
import model.gameobject.actors.enemies.rifleenemy.RifleEnemy;
import model.weapons.enemyweapons.EnemyRifle;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class EnemyRifleBuilder extends EnemyBuilder{

    @Override
    public void buildBase(float x, float y) {
        enemy = new RifleEnemy(x,y);
        enemy.setState(new EnemyRifleIdleState(enemy));
    }

    @Override
    public void buildWeapon() {
        enemy.setWeapon(new EnemyRifle(enemy));
    }

    @Override
    public void buildAnimator() {
        Animator animator = new Animator(enemy);
        animator.addAnimation("Walking", new EnemyRifleWalkAnimation());
        animator.addAnimation("Idle", new EnemyRifleIdleAnimation());
        animator.addAnimation("Shooting", new EnemyRifleShootingAnimation());
        animator.setAnimation("Idle");
        enemy.setAnimator(animator);
    }

    @Override
    public void buildImage() {
        enemy.setImage(ImageUtilities.ENEMY_RIFLE);
        enemy.setWidth(enemy.getImage().getWidth());
        enemy.setHeight(enemy.getImage().getHeight());
    }
    
}
