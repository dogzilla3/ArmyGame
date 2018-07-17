/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.animator;

import java.util.ArrayList;

/**
 *
 * @author Greg
 */
public abstract class Animation {
    
    protected ArrayList<AnimationImage> animationImages = new ArrayList<>();
    
    public void addAnimationImages(AnimationImage image){
        animationImages.add(image);
    }
    
    public abstract AnimationImage getStart();
}
