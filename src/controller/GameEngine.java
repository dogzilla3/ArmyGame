package controller;

import java.util.concurrent.TimeUnit;

public class GameEngine implements Runnable {

    private boolean running = true;
    private final int FRAMES_PER_SECOND = 40;
    private boolean isPaused = true;

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
            //System.out.println("Sytem paused? " + isPaused);
            if (!isPaused) {
                System.out.println ("Game Engine Paused - " + isPaused);
                processCollisions();
                Main.gameData.update();
                Main.gamePanel.gameRender();
                Main.gamePanel.printScreen();

                
            }
            else
                System.out.println("Game Engine Paused - " + isPaused);
        }

    }

    private void processCollisions() {
        // detect collisions between friendFigure and enemyFigures
        // if detected, mark it as STATE_DONE, so that
        // they can be removed at update() method

        for (model.gamefigure.actors.Actor friendFigure : Main.gameData.friendFigures) {
            for (model.gamefigure.actors.Actor enemyFigure : Main.gameData.enemyFigures) {
                if (friendFigure.getCollisionBox().intersects(enemyFigure.getCollisionBox())) {
                    friendFigure.onCollision(enemyFigure);
                }
            }
        }
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void pause() {
        isPaused = true;
    }

    public void unPause() {
        isPaused = false;
        
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
