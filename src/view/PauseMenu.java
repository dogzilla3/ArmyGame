/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ButtonListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Greg
 */
public class PauseMenu extends JPanel {

    public static JPanel devMenu;
    public static JPanel infoPanel;
    public static JLabel levelLabel;
    public static JLabel levelStatusText;
    public static JPanel buttonPanel;
    public static JPanel devButtonPanel;
    public static JButton startLevelButton;
    public static JButton resumeGameButton;
    public static JButton saveGameButton;
    public static JButton muteGameButton;
    public static JButton mainMenuGameButton;
    ButtonListener buttonListener = new ButtonListener();

    public PauseMenu(GridLayout gridLayout) {
        super(gridLayout);
    }

    public void initialize() {
        
        infoPanel = new JPanel(new GridLayout(2, 1));
        levelLabel = new JLabel("Level 1");
        levelStatusText = new JLabel("Level 1");
        
        buttonPanel = new JPanel(new GridLayout(5, 1));
        
        startLevelButton = new JButton("Start Level");
        startLevelButton.setFocusable(false);
        startLevelButton.addActionListener(buttonListener);
        buttonPanel.add(startLevelButton);
        
        resumeGameButton = new JButton("Resume");
        resumeGameButton.addActionListener(buttonListener);
        resumeGameButton.setFocusable(false);
        
        buttonPanel.add(resumeGameButton);
        saveGameButton = new JButton("Save Game");
        saveGameButton.addActionListener(buttonListener);
        saveGameButton.setFocusable(false);
        buttonPanel.add(saveGameButton);
        
        muteGameButton = new JButton("Mute");
        muteGameButton.addActionListener(buttonListener);
        muteGameButton.setFocusable(false);
        buttonPanel.add(muteGameButton);
        
        mainMenuGameButton = new JButton("Main menu");
        mainMenuGameButton.addActionListener(buttonListener);
        mainMenuGameButton.setFocusable(false);
        buttonPanel.add(mainMenuGameButton);
        
        
        add(infoPanel);
        add(buttonPanel);
    }

}
