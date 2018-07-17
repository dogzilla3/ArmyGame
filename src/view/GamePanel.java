package view;

import controller.Main;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.gamefigure.GameObject;

public class GamePanel extends JPanel {

    // size of the canvas - determined at runtime once rendered
    public static int width;
    public static int height;
    
    // off screen rendering
    private Graphics2D g1;
    private Graphics2D g2;
    private Graphics2D g3;
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
                g2 = (Graphics2D) dbImage.getGraphics();
                g3 = (Graphics2D) dbImage.getGraphics();
            }
        }
        g1.clearRect(0, 0, width, height);
        g2.clearRect(0, 0, width, height);
        g3.clearRect(0, 0, width, height);
        g1.drawImage(Main.gameData.getCurrentLevel().getImage(), 0 , 0, null);
        if (!Main.gameEngine.isPaused()) {
            for (GameObject f : Main.gameData.enemyFigures) {
                f.render(g2);
            }

            for (GameObject f : Main.gameData.friendFigures) {
                //System.out.println("Render game figures");
                f.render(g2);
            }

        }

    }

    // use active rendering to put the buffered image on-screen
    public void printScreen() {
        Graphics g ;
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
