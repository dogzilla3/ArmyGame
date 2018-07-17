/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gamefigure.actors.hero;

import model.gamefigure.actors.hero.animations.HeroWalkAnimation;
import model.gamefigure.actors.hero.animations.HeroIdleAnimation;
import model.gamefigure.actors.hero.states.HeroIdle;
import model.gamefigure.actors.hero.states.PlayerState;
import model.gamefigure.actors.hero.states.HeroWalking;
import model.gamefigure.actors.hero.states.PlayerStateMachine;
import controller.Main;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.animator.Animated;
import model.animator.Animation;
import model.animator.AnimationImage;
import model.animator.Animator;
import model.gamefigure.GameObject;
import model.gamefigure.actors.Actor;

/**
 *
 * @author Greg
 */
public class Hero extends Actor implements Animated, PlayerStateMachine{

    private final Animator animator;
    private final Animation walk;
    private final Animation idle;

    private final PlayerState isIdle;
    private final PlayerState isWalking;
    private PlayerState currentState;

    public Hero(float x, float y) {
        super(x, y);
        try {
            image = ImageIO.read(getClass().getResource("/Assets/Hero/Hero.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open file");
            System.exit(-1);
        }
        isIdle = new HeroIdle(this);
        isWalking = new HeroWalking(this);
        animator = new Animator(this);
        walk = new HeroWalkAnimation();
        idle = new HeroIdleAnimation();
        animator.addAnimation("Walking", walk);
        animator.addAnimation("Idle", idle);
        animator.setAnimation("Idle");
        currentState = isIdle;
    }

    @Override
    public void moveFigure(float dx, float dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void update() {
        debugLog();
        currentState.updateState();
        animator.animate();
    }

    @Override
    public Rectangle2D getCollisionBox() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new Rectangle2D.Float();
    }

    @Override
    public void onCollision(GameObject collider) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void debugLog() {
        //System.out.println("Image to display - " + image.toString());
    }

    @Override
    public void idle() {
        if(currentState != isIdle){
            currentState = isIdle;
            animator.setAnimation("Idle");
        }
    }

    @Override
    public void walking() {
        if(currentState != isWalking){
            currentState = isWalking;
            animator.setAnimation("Walking");
        }         
    }
    
    @Override
    public void setState(PlayerState state){
        //currentState = state;
    }

    @Override
    public void changeAnimation(String string) {
        animator.setAnimation(string);
    }

    @Override
    public PlayerState getState() {
        return currentState;
    }
}
