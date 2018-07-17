package view;

import controller.Main;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.gameobject.GameObject;

public class GamePanel extends JPanel {

    // size of the canvas - determined at runtime once rendered
    public static int width;
    public static int height;

    // off screen rendering
    private Graphics2D g1;
    public static String weaponName = "Rifle";
    public static String healthTitle = "Health";
    public static int ammo = -1;
    public static int health = 100;
    private Image dbImage = null; // double buffer image

    public void gameRender() {
        width = getSize().width;
        height = getSize().height;
        if (dbImage == null) {
            // Creates an off-screen drawable image to be used for double buffering
            dbImage = createImage(width, height);
            if (dbImage == null) {
                System.out.println("Critical Error: dbImage is null");
                System.exit(1);
            } else {
                g1 = (Graphics2D) dbImage.getGraphics();
            }
        }
        g1.clearRect(0, 0, width, height);
        
        if (!Main.gameEngine.isPaused()) {
            g1.drawImage(Main.gameData.getCurrentLevel().getImage(), 0, 0, null);
            for (int i = 1; i <= 3; i++) {
                for (GameObject f : Main.gameData.renderObjects) {
                    //System.out.println("Render game figures");
                    if (f.drawLayer == i) {
                        f.render(g1);
                    }
                }
            }

            g1.setFont(new Font("Arial Bold", Font.BOLD, 32));
            if (ammo == -1) {
                g1.drawString(weaponName + ": inf", 20, 600);
            } else {
                g1.drawString(weaponName + ": " + ammo, 20, 600);
            }
            if (health > 0) {
                g1.drawString(healthTitle + ": " + health, 20, 565);
            } else {
                g1.drawString(healthTitle + ": DEAD", 20, 565);
            }
        }

    }

    // use active rendering to put the buffered image on-screen
    public void printScreen() {
        Graphics g;
        try {
            g = this.getGraphics();
            if ((g != null) && (dbImage != null)) {
                g.drawImage(dbImage, 0, 0, null);
            }
            Toolkit.getDefaultToolkit().sync();  // sync the display on some systems
            if (g != null) {
                g.dispose();
            }
        } catch (Exception e) {
            System.out.println("Graphics error: " + e);
        }
    }

    @Override
    public int getWidth() {
        return getSize().width;
    }

    @Override
    public int getHeight() {
        return getSize().height;
    }

}
