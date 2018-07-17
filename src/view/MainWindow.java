package view;

import controller.KeyController;
import controller.Main;
import controller.MouseController;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

    public static JPanel gameDisplay;
    public static CardLayout displayScreens;
    public static MouseController mouseController;
    public static RestartMenu restartMenu;

    //Menus
    public MainMenu mainMenu;
    public PauseMenu pauseMenu;
    public DevMenu devMenu;
    public TutorialMenu tutorialMenu;
    public static EndGameScreen endGameScreen;

    //These variables are the game menu  
    public MainWindow() {
        Container contentPane = getContentPane();
        gameDisplay = new JPanel(new CardLayout());
        displayScreens = (CardLayout) gameDisplay.getLayout();

        mainMenu = new MainMenu(new BorderLayout());
        mainMenu.initialize();
        gameDisplay.add(mainMenu);
        displayScreens.addLayoutComponent(mainMenu, "Main Menu");

        pauseMenu = new PauseMenu(new GridLayout(2, 1));
        pauseMenu.initialize();
        gameDisplay.add(pauseMenu);
        displayScreens.addLayoutComponent(pauseMenu, "Pause Menu");

        devMenu = new DevMenu(new GridLayout(2, 1));
        devMenu.initialize();
        gameDisplay.add(devMenu);
        displayScreens.addLayoutComponent(devMenu, "Dev Menu");

        endGameScreen = new EndGameScreen(new GridLayout(2, 1));
        endGameScreen.initialize();
        gameDisplay.add(endGameScreen);
        displayScreens.addLayoutComponent(endGameScreen, "End Game Screen");

        restartMenu = new RestartMenu(new GridLayout(2, 1));
        restartMenu.initialize();
        gameDisplay.add(restartMenu);
        displayScreens.addLayoutComponent(restartMenu, "Restart Menu");

        tutorialMenu = new TutorialMenu(new GridLayout(2, 1));
        tutorialMenu.initialize();
        gameDisplay.add(tutorialMenu);
        displayScreens.addLayoutComponent(tutorialMenu, "Tutorial Menu");

        gameDisplay.add(Main.gamePanel);
        displayScreens.addLayoutComponent(Main.gamePanel, "Game Screen");

        mouseController = new MouseController();
        Main.gamePanel.addMouseListener(mouseController);
        Main.gamePanel.addMouseMotionListener(mouseController);

        KeyController keyListener = new KeyController();
        this.addKeyListener(keyListener);
        this.setFocusable(true);

        Main.gamePanel.setFocusable(false);
        gameDisplay.setFocusable(false);

        Main.gameEngine.pause();

        System.out.println("Main menu created");
        contentPane.add(gameDisplay);
    }

    public static void display(String display) {

    }
}
