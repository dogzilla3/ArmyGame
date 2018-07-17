package view;

import controller.ButtonListener;
import controller.KeyController;
import controller.Main;
import controller.MouseController;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

    public JPanel mainMenu;
    public JPanel pauseMenu;
    public static JPanel gameDisplay;
    public static CardLayout displayScreens;
    public static JButton tutorialButton;
    public static JButton startButton;
    public static JButton quitButton;
    public static MouseController mouseController;
    
    //These variables are the game menu
    public static JPanel gameMenu;
    public static JPanel infoPanel;
    public static JLabel levelLabel;
    public static JLabel levelStatusText;
    public static JPanel buttonPanel;
    public static JButton startLevelButton;
    public static JButton resumeGameButton;
    public static JButton saveGameButton;
    public static JButton muteGameButton;
    public static JButton mainMenuGameButton;
    public static ImageIcon image;

    public MainWindow() {
        Container contentPane = getContentPane();
        gameDisplay = new JPanel(new CardLayout());
        displayScreens = (CardLayout) gameDisplay.getLayout();
        ButtonListener buttonListener = new ButtonListener();

        mainMenu = new JPanel(new BorderLayout());
        //D:/School Stuff/Object Oriented Software Design and Construction/TermProject/TermProject_ArmyGame/src/Assets
        
        try{
            BufferedImage bimage = (ImageIO.read(getClass().getResource("/Assets/Picture2.png")));
            image = new ImageIcon(bimage);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Cannot open file");
            System.exit(-1);
        } 
        
        JLabel label = new JLabel("", image, JLabel.CENTER);
        //JPanel panel = new JPanel();
        //panel.add(label);
        mainMenu.add(label, BorderLayout.CENTER);
        
        JPanel mainMenuButtons = new JPanel(new GridLayout(1, 5));
        tutorialButton = new JButton("Tutorial");
        tutorialButton.addActionListener(buttonListener);
        JPanel tutorialButtonPanel = new JPanel();
        tutorialButtonPanel.add(tutorialButton);
        mainMenuButtons.add(tutorialButtonPanel);

        
        startButton = new JButton("Start");
        startButton.addActionListener(buttonListener);
        JPanel startButtonPanel = new JPanel();
        startButtonPanel.add(startButton);
        mainMenuButtons.add(startButtonPanel);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(buttonListener);
        JPanel quitButtonPanel = new JPanel();
        quitButtonPanel.add(quitButton);
        mainMenuButtons.add(quitButtonPanel);
        mainMenu.add(mainMenuButtons, BorderLayout.SOUTH);
        gameDisplay.add(mainMenu);
        
        //These variables are the game menu
        gameMenu = new JPanel(new GridLayout(2,1));
        infoPanel = new JPanel(new GridLayout(2,1));
        levelLabel = new JLabel();
        levelStatusText = new JLabel();
        buttonPanel = new JPanel(new GridLayout(5,1));
        startLevelButton = new JButton("Start Level");
        startLevelButton.addActionListener(buttonListener);
        buttonPanel.add(startLevelButton);
        resumeGameButton = new JButton("Resume");
        resumeGameButton.addActionListener(buttonListener);
        buttonPanel.add(resumeGameButton);
        saveGameButton = new JButton("Save Game");
        saveGameButton.addActionListener(buttonListener);
        buttonPanel.add(saveGameButton);
        muteGameButton = new JButton("Mute");
        muteGameButton.addActionListener(buttonListener);
        buttonPanel.add(muteGameButton);
        mainMenuGameButton = new JButton("Main menu");
        mainMenuGameButton.addActionListener(buttonListener);
        buttonPanel.add(mainMenuGameButton);
        gameMenu.add(infoPanel);
        gameMenu.add(buttonPanel);
        
        gameDisplay.add(gameMenu);
        gameDisplay.add(Main.gamePanel);
        
        System.out.println("Main menu created");
        displayScreens.addLayoutComponent(gameMenu, "Game Menu");
        displayScreens.addLayoutComponent(Main.gamePanel, "Game Screen");
        displayScreens.addLayoutComponent(mainMenu, "Main Menu");

        mouseController = new MouseController();
        Main.gamePanel.addMouseListener(mouseController);
        Main.gamePanel.addMouseMotionListener(mouseController);

        KeyController keyListener = new KeyController();
        this.addKeyListener(keyListener);
        this.setFocusable(true);
        Main.gamePanel.setFocusable(false);
        // just have one Component "true", the rest must be "false"
        tutorialButton.setFocusable(false);
        startButton.setFocusable(false);
        quitButton.setFocusable(false);
        gameDisplay.setFocusable(false);

        Main.gameEngine.pause();

        
        //displayScreens = (CardLayout) gameDisplay.getLayout();
        System.out.println("Main menu created");
        //displayScreens.addLayoutComponent(Main.gamePanel, "Game Screen");
        //displayScreens.addLayoutComponent(mainMenu, "Main Menu");
        contentPane.add(gameDisplay);
        //displayScreens.show(gameDisplay, "Main Menu");
    }
    
    public static void display(String display){
        
    }
}
