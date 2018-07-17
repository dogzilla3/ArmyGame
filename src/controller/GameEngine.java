package controller;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import model.gameobject.CollisionBox;
import model.gameobject.GameObject;
import model.Collideable;
import view.MainWindow;
import view.RestartMenu;

public class GameEngine implements Runnable {

    private boolean running = true;
    private final int FRAMES_PER_SECOND = 40;
    private boolean isPaused = true;
    private boolean pauseGame = true;
    private boolean playerDead = false;
    private boolean gameWon = false;
    //private CollisionQuadTree collisionContainer = new CollisionQuadTree(0, new Rectangle(0, 0, 600, 600));

    @Override
    public void run() {

        while (running) {
            long startTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();
            int sleepTime = (int) (1.0 / FRAMES_PER_SECOND * 1000)
                    - (int) (endTime - startTime);

            if (sleepTime > 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(sleepTime);
                } catch (InterruptedException e) {

                }
            }
            if (!isPaused) {
                processCollisions();
                Main.gameData.update();
                Main.gamePanel.gameRender();
                Main.gamePanel.printScreen();
                if (pauseGame == true) {
                    isPaused = true;
                    MainWindow.displayScreens.show(MainWindow.gameDisplay, "Pause Menu");
                }
                if(playerDead == true){
                    isPaused = true;
                    MainWindow.displayScreens.show(MainWindow.gameDisplay, "Restart Menu");
                }
                if(gameWon == true){
                    isPaused = true;
                    MainWindow.displayScreens.show(MainWindow.gameDisplay, "End Game Screen");
                }
                
            }
        }
    }

    private void processCollisions() {
        // detect collisions between friendFigure and enemyFigures
        // if detected, mark it as STATE_DONE, so that
        // they can be removed at update() method

        for (Collideable source : Main.gameData.friendColliders) {
            for (Collideable collider : Main.gameData.enemyColliders) {
                if (collider.getCollisionBox().getBounds().intersects(source.getCollisionBox().getBounds())) {
                    source.onCollision(collider);
                    collider.onCollision(source);
                }
            }
            for (Collideable collider : Main.gameData.obstacleColliders) {
                if (collider.getCollisionBox().getBounds().intersects(source.getCollisionBox().getBounds())) {
                    source.onCollision(collider);
                    collider.onCollision(source);
                }
            }
        }

        for (Collideable source : Main.gameData.enemyColliders) {
            for (Collideable collider : Main.gameData.obstacleColliders) {
                if (collider.getCollisionBox().getBounds().intersects(source.getCollisionBox().getBounds())) {
                    source.onCollision(collider);
                    collider.onCollision(source);
                }
            }
        }

        /*collisionContainer.clear();
        for (int i = 0; i < Main.gameData.collideables.size(); i++) {
            //System.out.println("Inserting: " + Main.gameData.collideables.get(i));
            collisionContainer.insert(Main.gameData.collideables.get(i));
        }

        List<Collideable> returnObjects = new ArrayList<Collideable>();
        for (int i = 0; i < Main.gameData.collideables.size(); i++) {
            returnObjects.clear();
            collisionContainer.retrieve(returnObjects, Main.gameData.collideables.get(i));
            for (int x = 0; x < returnObjects.size(); x++) {
                if (Main.gameData.collideables.get(i) != returnObjects.get(x)) {
                    if (returnObjects.get(x).getCollisionBox().getCollider().intersects(Main.gameData.collideables.get(i).getCollisionBox().getCollider())) {
                        Main.gameData.collideables.get(i).onCollision(returnObjects.get(x));
                    }
                }
            }
        }*/
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void pause() {
        pauseGame = true;
        System.out.println("Game Engine Paused? - " + isPaused);
    }

    public void unPause() {
        isPaused = false;
        pauseGame = false;
        System.out.println("Game Engine Paused? - " + isPaused);

    }
    
    public void playerDead() {
        playerDead = true;
        RestartMenu.levelLabel.setText(Main.gameData.getCurrentLevel().getName());
        RestartMenu.levelStatusText.setText("You Died...Restart?");
        System.out.println("Game Engine Paused? - " + isPaused);
    }

    public void gameWon(){
        gameWon = true;
    }
    
    public void playerRestart() {
        isPaused = false;
        playerDead = false;
        System.out.println("Game Engine Paused? - " + isPaused);

    }

    public boolean isRunning() {
        return running;
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }
}
