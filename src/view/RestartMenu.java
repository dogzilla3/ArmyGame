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
public class RestartMenu extends JPanel{

    public static JButton resumeRestartMenuButton;
    public static JButton mainMenuRestartMenuButton;
    public static JPanel infoPanel;
    public static JLabel levelLabel;
    public static JLabel levelStatusText;
    public static JPanel buttonPanel;
    ButtonListener buttonListener = new ButtonListener();

    public RestartMenu(GridLayout gridLayout) {
        super(gridLayout);
    }

    public void initialize() {

        infoPanel = new JPanel(new GridLayout(2, 1));
        levelLabel = new JLabel("Level 1");
        levelLabel.setFont(new Font("Arial Bold", Font.BOLD, 32));
        levelStatusText = new JLabel("Youre Dead");
        levelStatusText.setFont(new Font("Arial Bold", Font.BOLD, 32));
        infoPanel.add(levelLabel);
        infoPanel.add(levelStatusText);

        buttonPanel = new JPanel(new GridLayout(2, 1));
        resumeRestartMenuButton = new JButton("Restart");
        resumeRestartMenuButton.addActionListener(buttonListener);
        resumeRestartMenuButton.setFocusable(false);
        buttonPanel.add(resumeRestartMenuButton);

        mainMenuRestartMenuButton = new JButton("Main menu");
        mainMenuRestartMenuButton.addActionListener(buttonListener);
        mainMenuRestartMenuButton.setFocusable(false);
        buttonPanel.add(mainMenuRestartMenuButton);
        
        add(infoPanel);
        add(buttonPanel);
    }

}
