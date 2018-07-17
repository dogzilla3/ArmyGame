/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ButtonListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Greg
 */
public class TutorialMenu extends JPanel {

    public static JTextArea textArea;
    public static JPanel buttonPanel;
    public static JButton mainMenuTutorialButton;
    ButtonListener buttonListener = new ButtonListener();

    public TutorialMenu(GridLayout gridLayout) {
        super(gridLayout);
    }

    public void initialize() {
        textArea = new JTextArea(
                "Thank you for playing the army game!\n"
                + "The hero is trapped behind enemy lines\n"
                + "and must fight his way through to freedom!\n\n"
                + "Hero Controls:\n"
                + "Use the arrow keys to move the hero.\n"
                + "Pick up med kits to restore your health.\n"
                + "Pick up power ups to upgrade your weapon."
                + "Defeat every enemy on a stage to advance to the next\n\n"
                + "Enemies:\n"
                + "You will encounter many enemies along the path\n\n"
                + "     Rifle Enemy:\n"
                + "     The rifle enemy will patrol his area until the\n"
                + "     hero comes into range then will persue relentlessly\n\n"
                + "     Flamer Enemy:\n"
                + "     The flamer enemy hides, usually in trees and waits\n"
                + "     for the hero. He then abmbushes the hero and enleashes\n"
                + "     his devastating flame thrower. He will also pursue the\n"
                + "     hero until he dies\n\n"
                + "     Mortar Enemy:\n"
                + "     The mortar enemy will remain stationary and lob\n"
                + "     mortar shells at the hero. He explodes violently\n"
                + "     upon death\n\n"
                + "     Sniper Enemy:\n"
                + "     The sniper enemy hides in the trees and shoots\n"
                + "     powerful sniper rounds at the herohe is a master\n"
                + "     of camoflauge and can seem to disappear after\n"
                + "     shooting. Shooting a sniper enemy will force\n"
                + "     him to change positions. Use this to your advantage\n\n"
                + "     Radio Enemy:\n"
                + "     The radio enemy may seem harmless at first. However\n"
                + "     he carries a radio with which to call in a powerful\n"
                + "     airstrike on the hero. The plane will do a bombing\n"
                + "     run across the stage in attempt to blow up the hero\n"
                + "     Eliminate the radio enemy quickly to clear the skies\n\n"
                + "     Tank Enemy:\n"
                + "     The hero must fight a tank that is gaurding the crossing\n"
                + "     to friendly lines. The tank is a powerful enemy with\n"
                + "     a lot of health. Use upgraded weapons to take it down quickly\n"
                + "     explosives should do the trick \n\n"
        );
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);

        buttonPanel = new JPanel();

        mainMenuTutorialButton = new JButton("Main Menu");
        mainMenuTutorialButton.setFocusable(false);
        mainMenuTutorialButton.addActionListener(buttonListener);
        buttonPanel.add(mainMenuTutorialButton);

        add(buttonPanel);
        add(scrollPane);
    }

}
