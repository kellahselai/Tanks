package com.kellahselai.game;

import com.kellahselai.display.Display;
import com.kellahselai.game.level.Level;
import com.kellahselai.graphics.Sprite;
import com.kellahselai.graphics.SpriteSheet;
import com.kellahselai.graphics.TextureAtlas;
import com.kellahselai.utils.Time;
import com.kellahselai.io.Input;

import java.awt.*;
import java.awt.event.KeyEvent;


/**
 * Created by pc2 on 21.07.16.
 */
public class Game implements Runnable{

    public static final int WIDTH=800;
    public static final int HEIGHT=600;
    public static final String TITLE="Tanks";
    public static final int CLEAR_COLOR = 0xFF000000;
    public static final int NUM_BUFFERS = 3;

    public static final float UPDATE_RATE = 60.0f;
    public static final float UPDATE_INTERVAL = Time.SECOND / UPDATE_RATE;
    public static final long IDLE_TIME = 1;
    public static final String ATLAS_FILE_NAME = "texture_atlas.png";


    private boolean running;
    private Thread gameThread;
    private Graphics2D graphics;
    private Input input;
    private TextureAtlas atlas;
    private Player player;
    private Level lvl;











    public Game(){
        running=false;
        Display.create(WIDTH,HEIGHT,TITLE,CLEAR_COLOR,NUM_BUFFERS);
        graphics=Display.getGraphics();
        input = new Input();
        Display.addInputListener(input);
        atlas = new TextureAtlas(ATLAS_FILE_NAME);
        player = new Player(300,300,3,3,atlas);
        lvl= new Level(atlas);










    }
    public synchronized void start(){
        if(running)
            return;

        running=true;
        gameThread=new Thread(this);
        gameThread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;

        running=false;

        try {
            gameThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        cleanup();

    }

    private void update(){

        player.update(input);
        lvl.update();


    }
    private void render(){
        Display.clear();

        lvl.render(graphics);
        player.render(graphics);

        Display.swapBuffers();
    }
    public void run(){

        int fps =0;
        int upd =0;
        int updl=0;

        long count =0;

        float delta=0;

        long lastTime = Time.get();
        while(running){
            long now = Time.get();
            long elapsedTime=now-lastTime;
            lastTime = now;

            count+= elapsedTime;


            boolean render = false;

            delta += ( elapsedTime / UPDATE_INTERVAL);
            while(delta>1) {
                update();
                upd++;
                delta--;
                if (render) {
                    updl++;
                } else {
                    render = true;
                }
            }

            if(render){
                render();
                fps++;
            }else{
                try {
                    Thread.sleep(IDLE_TIME);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        if(count>=Time.SECOND){
            Display.setTitle(TITLE+" || FPS: "+fps+" |  UPD: "+upd+ " | "+ updl);
            upd=0;
            fps=0;
            updl=0;
            count=0;
        }
        }
    }
    private void cleanup(){
        Display.destroy();
    }

}
