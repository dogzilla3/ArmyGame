package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.level.Level_1;
import view.MainWindow;

public class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == MainWindow.tutorialButton) {
            
        }
        else if(event.getSource() == MainWindow.startButton){
            Level_1 level_1 = new Level_1();
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameData.setCurrentLevel(level_1);
            Main.gameEngine.unPause();
        }
        else if(event.getSource() == MainWindow.quitButton){
            
        }
        else if(event.getSource() == MainWindow.resumeGameButton){
            System.out.println("Resume Clicked");
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Screen");
            Main.gameEngine.unPause();
        }
        else if(event.getSource() == MainWindow.mainMenuGameButton){
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Main Menu");
            Main.gamePanel.repaint();
            System.out.println("Main Menu Clicked");
        }
    }

}
