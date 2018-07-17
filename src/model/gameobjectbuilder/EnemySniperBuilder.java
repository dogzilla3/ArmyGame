/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobjectbuilder;

import controller.animator.Animator;
import controller.animator.animations.enemyanimation.enemysniper.EnemySniperIdleAnimation;
import controller.animator.animations.enemyanimation.enemysniper.EnemySniperShootingAnimation;
import model.gameobject.actors.enemies.sniperenemy.EnemySniperIdleState;
import model.gameobject.actors.enemies.sniperenemy.SniperEnemy;
import model.weapons.enemyweapons.EnemySniperRifle;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class EnemySniperBuilder extends EnemyBuilder{

    @Override
    public void buildBase(float x, float y) {
        enemy = new SniperEnemy(x,y);
        enemy.setState(new EnemySniperIdleState((SniperEnemy)enemy));
    }

    @Override
    public void buildWeapon() {
        enemy.setWeapon(new EnemySniperRifle(enemy));
    }

    @Override
    public void buildAnimator() {
        Animator animator = new Animator(enemy);
        animator.addAnimation("Idle", new EnemySniperIdleAnimation());
        animator.addAnimation("Shooting", new EnemySniperShootingAnimation());
        animator.setAnimation("Idle");
        enemy.setAnimator(animator);
    }

    @Override
    public void buildImage() {
        enemy.setImage(ImageUtilities.ENEMY_SNIPER_IDLE);
        enemy.setWidth(enemy.getImage().getWidth());
        enemy.setHeight(enemy.getImage().getHeight());
    }
    
}
