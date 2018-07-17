/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobjectbuilder;

import model.gameobject.actors.enemies.Enemy;


/**
 *
 * @author Greg
 */
public abstract class EnemyBuilder{

    protected Enemy enemy;

    public Enemy getEnemy() {
        return enemy;
    }

    public abstract void buildBase(float x, float y);
    public abstract void buildWeapon();
    public abstract void buildAnimator();
    public abstract void buildImage();
}
