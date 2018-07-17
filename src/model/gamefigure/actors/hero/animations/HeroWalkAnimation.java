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
public class HeroWalkAnimation extends Animation{
    
    private AnimationImage start; 
    private AnimationImage walking1; 
    private AnimationImage walking2;
    private AnimationImage walking3;
    private int displayTime = 5;
    
    public HeroWalkAnimation(){
        try {
            
            
            start = new AnimationImage(ImageIO.read(getClass().getResource("/Assets/Hero/Hero.png")), displayTime);
            walking1 = new AnimationImage(ImageIO.read(getClass().getResource("/Assets/Hero/HeroWalk1.png")), displayTime);
            walking2 = new AnimationImage(ImageIO.read(getClass().getResource("/Assets/Hero/Hero.png")), displayTime);
            walking3 = new AnimationImage(ImageIO.read(getClass().getResource("/Assets/Hero/HeroWalk2.png")), displayTime);
            start.setNextImage(walking1);
            walking1.setNextImage(walking2);
            walking2.setNextImage(walking3);
            walking3.setNextImage(start);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open file");
            System.exit(-1);
        }
    }
    
    @Override
    public AnimationImage getStart(){
        return start;
    }
}
