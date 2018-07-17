/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobjectbuilder;

import controller.animator.Animator;
import controller.animator.animations.enemyanimation.mortarenemy.EnemyMortarLoadingAnimation;
import model.gameobject.actors.enemies.mortarenemy.EnemyMortarLoadingState;
import model.gameobject.actors.enemies.mortarenemy.MortarEnemy;
import model.weapons.enemyweapons.EnemyMortar;
import utility.ImageUtilities;

/**
 *
 * @author Greg
 */
public class EnemyMortarBuilder extends EnemyBuilder{

    @Override
    public void buildBase(float x, float y) {
        enemy = new MortarEnemy(x,y);
        enemy.setState(new EnemyMortarLoadingState(enemy));
    }

    @Override
    public void buildWeapon() {
        enemy.setWeapon(new EnemyMortar(enemy));
    }

    @Override
    public void buildAnimator() {
        Animator animator = new Animator(enemy);
        animator.addAnimation("Loading", new EnemyMortarLoadingAnimation());
        animator.setAnimation("Loading");
        enemy.setAnimator(animator);
    }

    @Override
    public void buildImage() {
        enemy.setImage(ImageUtilities.ENEMY_MORTAR);
        enemy.setWidth(enemy.getImage().getWidth());
        enemy.setHeight(enemy.getImage().getHeight());
    }
    
}
