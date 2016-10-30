package ru.habrahabr.sergiosergio;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sg on 30.10.16.
 */
public class Game implements Runnable{

    private boolean running;
    protected int timedelay = 100;

    protected Canvas canvas;
    protected GameMap map;
    protected Player player;

    public void start() {
        if (running){
            return;
        }
        running = true;
        canvas = new Canvas();
        map = new GameMap;
        player = new Player;
        new Thread(this).start();
    }

    public void stop(){
        running = false;
    }
    public Canvas getCanvas(){
        return canvas;
    }

    @Override
    public void run(){
        while(running){
            try{
                TimeUnit.MICROSECONDS.sleep(timedelay);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            update;
        }
    }

    protected void update() {
        canvas.removeRenders();
        int mapW = map.getWidth(), mapH = map.getHeight(), x, y, tileID;

        for (y = 0; y < mapH; y++){
            for (x = 0; x < mapW; x++){
                tileID = map.getTileId(x, y);
                canvas.addRender(new BaseTile((tileID == 2) ? "/data/black.png" : "/data/white.png", x * BaseTile.SIZE, y * BaseTile.Size));
            }
        }
    }

    canvas.addRender(player);


}
