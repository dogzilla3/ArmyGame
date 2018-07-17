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

/**
 *
 * @author Greg
 */
public class DevMenu extends JPanel {

    public static JButton rifleEnemy;
    public static JButton flamerEnemy;
    public static JButton mortarEnemy;
    public static JButton radioEnemy;
    public static JButton sniperEnemy;
    public static JButton bossEnemy;
    public static JButton pickups;
    public static JButton level1;
    public static JButton level2;
    public static JButton level3;
    public static JButton level4;
    public static JButton mainMenuDevButton;
    ButtonListener buttonListener = new ButtonListener();

    public DevMenu(GridLayout gridLayout) {
        super(gridLayout);
    }

    public void initialize() {

        JPanel devButtonPanel = new JPanel(new GridLayout(12, 1));
        rifleEnemy = new JButton("Rifle Enemy");
        rifleEnemy.addActionListener(buttonListener);
        rifleEnemy.setFocusable(false);
        devButtonPanel.add(rifleEnemy);

        flamerEnemy = new JButton("Flamer Enemy");
        flamerEnemy.addActionListener(buttonListener);
        flamerEnemy.setFocusable(false);
        devButtonPanel.add(flamerEnemy);

        mortarEnemy = new JButton("Mortar Enemy");
        mortarEnemy.addActionListener(buttonListener);
        mortarEnemy.setFocusable(false);
        devButtonPanel.add(mortarEnemy);

        sniperEnemy = new JButton("Sniper Enemy");
        sniperEnemy.addActionListener(buttonListener);
        sniperEnemy.setFocusable(false);
        devButtonPanel.add(sniperEnemy);

        radioEnemy = new JButton("Radio Enemy");
        radioEnemy.addActionListener(buttonListener);
        radioEnemy.setFocusable(false);
        devButtonPanel.add(radioEnemy);

        bossEnemy = new JButton("Boss Enemy");
        bossEnemy.addActionListener(buttonListener);
        bossEnemy.setFocusable(false);
        devButtonPanel.add(bossEnemy);

        pickups = new JButton("Pickups");
        pickups.addActionListener(buttonListener);
        pickups.setFocusable(false);
        devButtonPanel.add(pickups);

        level1 = new JButton("Level 1");
        level1.addActionListener(buttonListener);
        level1.setFocusable(false);
        devButtonPanel.add(level1);

        level2 = new JButton("Level 2");
        level2.addActionListener(buttonListener);
        level2.setFocusable(false);
        devButtonPanel.add(level2);

        level3 = new JButton("Level 3");
        level3.addActionListener(buttonListener);
        level3.setFocusable(false);
        devButtonPanel.add(level3);

        level4 = new JButton("Level 4");
        level4.addActionListener(buttonListener);
        level4.setFocusable(false);
        devButtonPanel.add(level4);

        mainMenuDevButton = new JButton("Main menu");
        mainMenuDevButton.addActionListener(buttonListener);
        mainMenuDevButton.setFocusable(false);
        devButtonPanel.add(mainMenuDevButton);

        add(devButtonPanel);
    }
}
