package model.gameobject;

import controller.Main;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    protected float x;
    protected float y;
    protected float dx;
    protected float dy;
    protected float speed;
    protected float rotation = 0;
    protected float alpha = 1f;
    protected float size = 1;
    protected float width = 0;
    protected float height = 0;
    protected boolean damageable;
    protected int health = 100;
    public int drawLayer = 2;
    public boolean isDone = false;
    public boolean isFriend = false;

    protected BufferedImage image = null;

    public GameObject() {

    }

    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // changes per frame
    public void render(Graphics2D g) {
        if (image != null) {
            Graphics2D g2 = (Graphics2D) g.create();
            //g2.drawRect((int) (x - ((width - 10) / 2)), (int) (y - (height / 2)), (int) width - 10, (int) height - 2);
            g2.rotate(Math.toRadians(rotation), (x), (y));
            g2.translate(x, y);
            g2.scale(size, size);
            g2.translate(-x, -y);
            AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2.setComposite(alphaComposite);
            g2.drawImage(image, (int) (x - (width / 2)), (int) (y - (height / 2)), null);
            //g2.drawRect((int) (x - (width / 2)), (int) (y - (height / 2)),(int) width-2, (int) height-2);
            g2.dispose();
        }
    }

    //Debug purposes
    public void debugLog() {

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getRotation() {
        return rotation;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getAlpha() {
        return alpha;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
        dx = speed * ((float) Math.cos(Math.toRadians(rotation)));
        dy = speed * ((float) Math.sin(Math.toRadians(rotation)));
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    /*protected void setWidth(float width) {
        this.width = width;
    }

    protected void setHeight(float height) {
        this.width = height;
    }*/
    public void setImage(BufferedImage image) {
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
    }

    public void rotate(float degrees) {
        this.rotation += degrees;
    }

    public void changeImage(BufferedImage image) {
        this.image = image;
    }

    public void update() {
    }

    public void checkDone() {
        if (isDone == true) {
            Main.gameData.renderObjects.remove(this);
            if (isFriend == true) {
                Main.gameData.friendColliders.remove(this);
            } else {
                Main.gameData.enemyColliders.remove(this);
            }

        }
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isDamageable() {
        return damageable;
    }

    public void setDamageable(boolean damageable) {
        this.damageable = damageable;
    }

    public int getDamage() {
        return 0;
    }

    public float getDx() {
        return dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void move(float dx, float dy){
        x += dx;
        y += dy;
    }
}
