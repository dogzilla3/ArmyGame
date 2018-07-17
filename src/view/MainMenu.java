/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ButtonListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Greg
 */
public class MainMenu extends JPanel{
    
    
    public static JButton tutorialButton;
    public static JButton startButton;
    public static JButton quitButton;
    public static JButton devMenuButton;
    public static ImageIcon image;
    ButtonListener buttonListener = new ButtonListener();

    public MainMenu(BorderLayout borderLayout) {
        super(borderLayout);
    }
    
    public void initialize(){
        try {
            BufferedImage bimage = (ImageIO.read(getClass().getResource("/Assets/Picture2.png")));
            image = new ImageIcon(bimage);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open file");
            System.exit(-1);
        }
        
        JLabel label = new JLabel("", image, JLabel.CENTER);
        add(label, BorderLayout.CENTER);

        JPanel mainMenuButtons = new JPanel(new GridLayout(1, 5));
        tutorialButton = new JButton("Tutorial");
        tutorialButton.addActionListener(buttonListener);
        tutorialButton.setFocusable(false);
        JPanel tutorialButtonPanel = new JPanel();
        tutorialButtonPanel.add(tutorialButton);
        mainMenuButtons.add(tutorialButtonPanel);

        startButton = new JButton("Start");
        startButton.addActionListener(buttonListener);
        startButton.setFocusable(false);
        JPanel startButtonPanel = new JPanel();
        startButtonPanel.add(startButton);
        mainMenuButtons.add(startButtonPanel);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(buttonListener);
        quitButton.setFocusable(false);
        JPanel quitButtonPanel = new JPanel();
        quitButtonPanel.add(quitButton);
        mainMenuButtons.add(quitButtonPanel);

        devMenuButton = new JButton("Dev Menu");
        devMenuButton.addActionListener(buttonListener);
        devMenuButton.setFocusable(false);
        JPanel devMenuButtonPanel = new JPanel();
        devMenuButtonPanel.add(devMenuButton);
        mainMenuButtons.add(devMenuButtonPanel);
        add(mainMenuButtons, BorderLayout.SOUTH);       
    }
}
