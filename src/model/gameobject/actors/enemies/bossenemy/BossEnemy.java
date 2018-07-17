/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gameobject.actors.enemies.bossenemy;

import controller.Main;
import controller.animator.Animator;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.gameobject.CollisionBox;
import model.gameobject.actors.enemies.Enemy;
import model.gameobject.actors.enemies.EnemyState;
import model.gameobject.actors.player.Player;
import model.weapons.Weapon;
import model.Collideable;
import model.level.Level;
import utility.Utilities;

/**
 *
 * @author Greg
 */
public class BossEnemy extends Enemy {

    private Weapon tankCannon;
    private BufferedImage tankBottom;
    private _EnemyBossState currentState;

    public BossEnemy(float x, float y) {
        super(x, y);
        this.targetX = x;
        this.targetY = y;
        this.speed = 3;
        this.damageable = true;
        this.isFriend = false;
        this.health = 500;
    }

    @Override
    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void update() {
        checkDone();
        debugLog();
        hero = Main.gameData.getPlayer();
        targetX = hero.getX();
        targetY = hero.getY();
        currentState.updateState();
        animator.animate();
        tankCannon.updateWeapon();
    }

    @Override
    public CollisionBox getCollisionBox() {
        return new CollisionBox((int) (x) - 120, (int) (y) - 73, (int) tankBottom.getWidth() - 50, tankBottom.getHeight(), this);
    }

    @Override
    public void onCollision(Collideable collider) {
        if (collider.getCollisionBox().getOwner() instanceof Player) {
            Player player = (Player) collider.getCollisionBox().getOwner();
            float angle = Utilities.getAngle(x, y, player.getX(), player.getY());
            float dx = player.getSpeed() * ((float) Math.cos(Math.toRadians(angle)));
            float dy = player.getSpeed() * ((float) Math.sin(Math.toRadians(angle)));
            player.move(dx, dy);
            //player.move(-player.getDx(), -player.getDy());
        }
        if (collider.getCollisionBox().getOwner().getDamage() > 0 && isDamageable() == true) {
            health -= collider.getCollisionBox().getOwner().getDamage();
            System.out.println("Health: " + health);
            setState(new EnemyBossHitState(this));
            if (health <= 0 && isDamageable() == true) {
                setDamageable(false);
                setState(new EnemyBossDyingState(this));
                Level.numberOfEnemies--;
            }
        }
    }

    public void setBottomImage(BufferedImage image) {
        this.tankBottom = image;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.tankCannon = weapon;
    }

    @Override
    public Weapon getWeapon() {
        return tankCannon;
    }

    @Override
    public void setAnimator(Animator animator) {
        this.animator = animator;
    }

    @Override
    public void setState(EnemyState state) {
        currentState = (_EnemyBossState) state;
    }

    public Player getPlayer() {
        return hero;
    }

    @Override
    public Animator getAnimator() {
        return animator;
    }

    @Override
    public void render(Graphics2D g) {
        if (image != null) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.drawImage(tankBottom, (int) (x) - 150, (int) (y) - 73, null);
            //g2.drawRect((int) (x - ((width - 10) / 2)), (int) (y - (height / 2)), (int) width - 10, (int) height - 2);
            g2.rotate(Math.toRadians(rotation), (x), (y));
            g2.translate(x, y);
            g2.scale(size, size);
            g2.translate(-x, -y);
            AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2.setComposite(alphaComposite);
            g2.drawImage(image, (int) (x - (width / 2)), (int) (y - (height / 2)), null);
            //g2.drawRect((int) (x) - 120, (int) (y) - 73, (int) tankBottom.getWidth(), tankBottom.getHeight());
            g2.dispose();
        }
    }
}
