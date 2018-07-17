/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobjectbuilder;

import controller.Main;
import controller.animator.Animator;
import controller.animator.animations.enemyanimation.enemysniper.EnemySniperIdleAnimation;
import controller.animator.animations.enemyanimation.enemysniper.EnemySniperShootingAnimation;
import controller.animator.animations.enemyanimation.tankenemy.EnemyTankDyingAnimation;
import controller.animator.animations.enemyanimation.tankenemy.EnemyTankIdleAnimation;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.bossenemy.BossEnemy;
import model.gameobject.actors.enemies.bossenemy.EnemyBossIdleState;
import model.weapons.enemyweapons.EnemyTankCannon;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class EnemyTankBuilder extends EnemyBuilder{

    @Override
    public void buildBase(float x, float y) {
        enemy = new BossEnemy(x,y);
        enemy.setState(new EnemyBossIdleState((BossEnemy)enemy));
    }

    @Override
    public void buildWeapon() {
        enemy.setWeapon(new EnemyTankCannon(enemy));
    }

    @Override
    public void buildAnimator() {
        Animator animator = new Animator(enemy);
        animator.addAnimation("Idle", new EnemyTankIdleAnimation());
        animator.addAnimation("Dying", new EnemyTankDyingAnimation());
        animator.setAnimation("Idle");
        enemy.setAnimator(animator);
    }

    @Override
    public void buildImage() {
        enemy.setImage(ImageUtilities.ENEMY_TANK_TURRET_1);
        enemy.setWidth(enemy.getImage().getWidth());
        enemy.setHeight(enemy.getImage().getHeight());
        BossEnemy enemyBottom = (BossEnemy) enemy;
        enemyBottom.setBottomImage(ImageUtilities.ENEMY_TANK_BOTTOM);
    }
}
