/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ButtonListener;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Greg
 */
public class EndGameScreen extends JPanel{
    
    public static JLabel endGameText;
    public static JPanel buttonPanel;
    public static JPanel infoPanel;
    public static JButton mainMenuEndGameButton;
    ButtonListener buttonListener = new ButtonListener();
    
    public EndGameScreen(GridLayout gridLayout) {
        super(gridLayout);
    }
    
    public void initialize() {
        
        infoPanel = new JPanel(new GridLayout(2, 1));
        endGameText = new JLabel("You have beaten the game! Congratulations");
        endGameText.setFont(new Font("Arial Bold", Font.BOLD, 32));
        infoPanel.add(endGameText);
        
        buttonPanel = new JPanel(new GridLayout(5, 1));
        
        mainMenuEndGameButton = new JButton("Main menu");
        mainMenuEndGameButton.addActionListener(buttonListener);
        mainMenuEndGameButton.setFocusable(false);
        buttonPanel.add(mainMenuEndGameButton);
        
        add(infoPanel);
        add(buttonPanel);
    }
}
