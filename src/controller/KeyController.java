package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.CopyOnWriteArrayList;
import model.gameobject.actors.player.Player;
import model.gameobject.actors.player.states.HeroHitState;
import model.gameobject.actors.player.states.HeroIdleState;
import model.gameobject.actors.player.states.HeroShootingState;
import model.gameobject.actors.player.states.HeroWalkingState;
import view.MainWindow;

public class KeyController extends KeyAdapter {

    private final CopyOnWriteArrayList<Integer> keysPressed = new CopyOnWriteArrayList<>();

    @Override
    public void keyPressed(KeyEvent e) {
        Player player = (Player) Main.gameData.getPlayer();

        if (Main.gameEngine.isPaused() == false && e.getKeyCode() != KeyEvent.VK_ESCAPE) {
            if (keysPressed.isEmpty() == true && !(player.getCurrentState() instanceof HeroShootingState) && !(player.getCurrentState() instanceof HeroHitState)) {
                keysPressed.add(e.getKeyCode());
            } else {
                if (!keysPressed.contains(e.getKeyCode()) && !(player.getCurrentState() instanceof HeroShootingState) && !(player.getCurrentState() instanceof HeroHitState)) {
                    keysPressed.add(e.getKeyCode());
                }
            }

            if (player != null && !(player.getCurrentState() instanceof HeroShootingState) && !(player.getCurrentState() instanceof HeroHitState)) {
                // horizontal move only
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        player.setRotation(180);
                        break;
                    case KeyEvent.VK_A:
                        player.setRotation(180);
                        break; 
                    case KeyEvent.VK_RIGHT:
                        player.setRotation(0);
                        break;
                    case KeyEvent.VK_D:
                        player.setRotation(0);
                        break; 
                    case KeyEvent.VK_UP:
                        player.setRotation(270);
                        break;
                    case KeyEvent.VK_W:
                        player.setRotation(270);
                        break; 
                    case KeyEvent.VK_DOWN:
                        player.setRotation(90);
                        break;
                    case KeyEvent.VK_S:
                        player.setRotation(90);
                        break; 
                }
                player.setState(new HeroWalkingState(player));
            }
        }
        
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            keysPressed.clear();
            Main.gameEngine.pause();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (Main.gameEngine.isPaused() == false && e.getKeyCode() != KeyEvent.VK_ESCAPE) {
            Player player = (Player) Main.gameData.getPlayer();
            if (player != null && !(player.getCurrentState() instanceof HeroShootingState) && !(player.getCurrentState() instanceof HeroHitState)) {
                if (keysPressed.contains(e.getKeyCode())) {
                    keysPressed.remove(keysPressed.indexOf(e.getKeyCode()));
                }
                if (keysPressed.isEmpty()) {
                    player.setState(new HeroIdleState(player));
                }
            }
        }
    }
}
