package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.level.*;
import view.*;

public class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == MainMenu.tutorialButton) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Tutorial Menu");
        } else if (event.getSource() == MainMenu.startButton) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.setCurrentLevel(new Level_1());
            Main.gameEngine.unPause();
        } else if (event.getSource() == MainMenu.quitButton) {

        } else if (event.getSource() == PauseMenu.resumeGameButton) {
            System.out.println("Resume Clicked");
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameEngine.unPause();
        } else if (event.getSource() == PauseMenu.mainMenuGameButton) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Main Menu");
            Main.gamePanel.repaint();
            System.out.println("Main Menu Clicked");
        } else if (event.getSource() == MainMenu.devMenuButton) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Dev Menu");
            Main.gamePanel.repaint();
            System.out.println("Dev Menu Clicked");
        } else if (event.getSource() == DevMenu.mainMenuDevButton) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Main Menu");
            Main.gamePanel.repaint();
            System.out.println("Dev Menu Clicked");
        } else if (event.getSource() == DevMenu.rifleEnemy) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.setCurrentLevel(new TestLevelRifle());
            Main.gameEngine.unPause();
        } else if (event.getSource() == DevMenu.flamerEnemy) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.setCurrentLevel(new TestLevelFlamer());
            Main.gameEngine.unPause();
        } else if (event.getSource() == DevMenu.mortarEnemy) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.setCurrentLevel(new TestLevelMortar());
            Main.gameEngine.unPause();
        } else if (event.getSource() == DevMenu.sniperEnemy) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.setCurrentLevel(new TestLevelSniper());
            Main.gameEngine.unPause();
        } else if (event.getSource() == DevMenu.radioEnemy) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.setCurrentLevel(new TestLevelRadio());
            Main.gameEngine.unPause();
        } else if (event.getSource() == DevMenu.bossEnemy) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.setCurrentLevel(new TestLevelTank());
            Main.gameEngine.unPause();
        } else if (event.getSource() == DevMenu.pickups) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.setCurrentLevel(new TestLevelPickups());
            Main.gameEngine.unPause();
        } else if (event.getSource() == DevMenu.level1) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.setCurrentLevel(new Level_1());
            Main.gameEngine.unPause();
        } else if (event.getSource() == DevMenu.level2) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.setCurrentLevel(new Level_2());
            Main.gameEngine.unPause();
        } else if (event.getSource() == DevMenu.level3) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.setCurrentLevel(new Level_3());
            Main.gameEngine.unPause();
        } else if (event.getSource() == DevMenu.level4) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.setCurrentLevel(new Level_4());
            Main.gameEngine.unPause();
        } else if (event.getSource() == RestartMenu.resumeRestartMenuButton) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.clearGameFigures();
            //Main.gameData.getCurrentLevel().initialize();
            Main.gameData.setCurrentLevel(Main.gameData.getCurrentLevel());
            Main.gameEngine.playerRestart();
            Main.gameEngine.unPause();
        } else if (event.getSource() == RestartMenu.mainMenuRestartMenuButton) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Main Menu");
            Main.gamePanel.repaint();
        } else if (event.getSource() == EndGameScreen.mainMenuEndGameButton) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Main Menu");
            Main.gamePanel.repaint();
        } else if (event.getSource() == TutorialMenu.mainMenuTutorialButton) {
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Main Menu");
            Main.gamePanel.repaint();
        }
    }
}
