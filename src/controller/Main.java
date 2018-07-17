package controller;

import javax.swing.JFrame;
import model.GameData;
import view.GamePanel;
import view.MainWindow;

public class Main {

    public static GamePanel gamePanel;
    public static GameData gameData;
    public static GameEngine gameEngine;

    public static int WIN_WIDTH = 1200;
    public static int WIN_HEIGHT = 650;

    public static void main(String[] args) {

        gameEngine = new GameEngine();
        gameData = new GameData();
        gamePanel = new GamePanel();

        JFrame game = new MainWindow();
        game.setTitle("Greg Levy - Army Game");
        game.setSize(WIN_WIDTH, WIN_HEIGHT);
        game.setLocation(100, 20);
        game.setResizable(false); // window size cannot change
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);

        // start animation
        new Thread(gameEngine).start();

    }
}
