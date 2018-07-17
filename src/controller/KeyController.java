package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.CopyOnWriteArrayList;
import model.gamefigure.actors.hero.Hero;
import view.MainWindow;

public class KeyController extends KeyAdapter {

    private final CopyOnWriteArrayList<Integer> keysPressed = new CopyOnWriteArrayList<>();

    @Override
    public void keyPressed(KeyEvent e) {
        Hero player = (Hero) Main.gameData.getPlayer();

        if (keysPressed.isEmpty() == true) {
            keysPressed.add(e.getKeyCode());
        } else {
            if (!keysPressed.contains(e.getKeyCode())) {
                keysPressed.add(e.getKeyCode());
            }
        }

        if (player != null) {
            // horizontal move only
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    player.setRotation(180);
                    player.walking();
                    break;
                case KeyEvent.VK_RIGHT:
                    player.setRotation(0);
                    player.walking();
                    break;
                case KeyEvent.VK_UP:
                    player.setRotation(270);
                    player.walking();
                    break;
                case KeyEvent.VK_DOWN:
                    player.setRotation(90);
                    player.walking();
                    break;
            }
        }
        
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            keysPressed.clear();
            Main.gameEngine.pause();
            MainWindow.displayScreens.show(MainWindow.gameDisplay, "Game Menu");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Hero player = (Hero) Main.gameData.getPlayer();
        if (player != null) {
            if (keysPressed.contains(e.getKeyCode())) {
                keysPressed.remove(keysPressed.indexOf(e.getKeyCode()));
            }
            if (keysPressed.isEmpty()) {
                player.idle();
            }
        }

    }
}
