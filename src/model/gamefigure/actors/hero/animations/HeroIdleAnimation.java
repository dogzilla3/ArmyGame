/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.gamefigure.actors.hero.animations;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.animator.Animation;
import model.animator.AnimationImage;

/**
 *
 * @author Greg
 */
public class HeroIdleAnimation extends Animation{
    private AnimationImage start; 
    private AnimationImage lookLeft; 
    private AnimationImage lookRight;
    private AnimationImage lookCenter;
    private int displayTime = 40;
    
    public HeroIdleAnimation(){
        try {
            start = new AnimationImage(ImageIO.read(getClass().getResource("/Assets/Hero/Hero.png")), displayTime);
            lookLeft = new AnimationImage(ImageIO.read(getClass().getResource("/Assets/Hero/HeroIdle1.png")), displayTime);
            lookCenter = new AnimationImage(ImageIO.read(getClass().getResource("/Assets/Hero/Hero.png")), displayTime);
            lookRight = new AnimationImage(ImageIO.read(getClass().getResource("/Assets/Hero/HeroIdle2.png")), displayTime);
            start.setNextImage(lookLeft);
            lookLeft.setNextImage(lookCenter);
            lookCenter.setNextImage(lookRight);
            lookRight.setNextImage(start);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open file");
            System.exit(-1);
        }  
    }

    @Override
    public AnimationImage getStart() {
        return start;
    }
}
