package model.gamefigure;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    protected float x;
    protected float y;
    protected float rotation = 0;
    protected float alpha = 1f;
    protected float size;
    protected float width = 0;
    protected float height = 0;

    protected BufferedImage image = null;


    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // changes per frame
    public void render(Graphics2D g){
        Graphics2D g2 = (Graphics2D) g.create();
        g2.rotate(Math.toRadians(rotation), x +(getWidth()/2), y + (getHeight()/2));
        g2.drawImage(image, (int)x, (int)y, null);
        g2.dispose();
    }
    
    //Debug purposes
    public void debugLog(){
        
    }
    
    public float getWidth(){
        return width;
    }
    
    public float getHeight(){
        return height;
    }
    
    public float getAlpha(){
        return alpha;
    }
    
    public void setAlpha(float alpha){
        this.alpha = alpha;
    }
    
    public void rotate(float degrees){
        this.rotation += degrees;
    }
    
    public void setRotation(float rotation){
        this.rotation = rotation;
    }
    
    public float getRotation(){
        return rotation;
    }
    
    public void setImage(BufferedImage image){
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
    }
    
    public float getX(){
        return x;
    }
    
    public float getY(){
        return y;
    }
}
