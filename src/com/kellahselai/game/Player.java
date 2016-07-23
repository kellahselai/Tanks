package com.kellahselai.game;

import com.kellahselai.display.Display;
import com.kellahselai.graphics.Sprite;
import com.kellahselai.graphics.SpriteSheet;
import com.kellahselai.graphics.TextureAtlas;
import com.kellahselai.io.Input;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc2 on 22.07.16.
 */
public class Player extends Entity {
    public static final int SPRITE_SCALE=16;
    public static final int SPRITES_PER_HEADING = 1;

    //tmp
    public static int ANIMATION=0;





    private enum Heading {


        NORTH(0 * SPRITE_SCALE, 0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        EAST(6 * SPRITE_SCALE, 0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        SOUTH(4 * SPRITE_SCALE, 0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        WEST(2 * SPRITE_SCALE, 0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),

        NORTH_AN(1 * SPRITE_SCALE, 0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        EAST_AN(7 * SPRITE_SCALE, 0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        SOUTH_AN(5 * SPRITE_SCALE, 0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        WEST_AN(3 * SPRITE_SCALE, 0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE);



        private int x, y, h, w;

        Heading(int x, int y, int h, int w)        {


            this.x = x;
            this.y = y;
            this.h = h;
            this.w = w;

        }
        protected BufferedImage texture(TextureAtlas atlas){
            return atlas.cut(x,y,w,h);
        }
    }


    private Heading heading;
    private Map<Heading, Sprite> spriteMap;
    private float scale;
    private float speed;

    public Player(float x, float y,float scale,float speed, TextureAtlas atlas) {
        super(EntityType.Player,x,y);




        heading= Heading.NORTH;
        spriteMap=new HashMap<Heading,Sprite>();
        this.scale=scale;
        this.speed=speed;
        for(Heading h: Heading.values()){
            SpriteSheet sheet = new SpriteSheet(h.texture(atlas),SPRITES_PER_HEADING,SPRITE_SCALE);
            Sprite sprite = new Sprite(sheet, scale);
            spriteMap.put(h,sprite);

        }


    }





    public void update(Input input){

        ANIMATION++;






        float newX = x;
        float newY = y;

        if(input.getKey(KeyEvent.VK_UP)){
            newY-=speed;
            //heading=Heading.NORTH;
            if(ANIMATION>10){
                heading=Heading.NORTH_AN;
            }
            if(ANIMATION>20){
                heading=Heading.NORTH;
                ANIMATION=0;
            }
        }else if(input.getKey(KeyEvent.VK_RIGHT)) {
            newX += speed;
            //heading=Heading.EAST;
            if(ANIMATION>10){
                heading=Heading.EAST_AN;
            }
            if(ANIMATION>20){
                heading=Heading.EAST;
                ANIMATION=0;
            }
        }else if(input.getKey(KeyEvent.VK_DOWN)) {
            newY += speed;
            //=Heading.SOUTH;
            if(ANIMATION>10){
                heading=Heading.SOUTH_AN;
            }
            if(ANIMATION>20){
                heading=Heading.SOUTH;
                ANIMATION=0;
            }
        }else if(input.getKey(KeyEvent.VK_LEFT)) {
            newX -= speed;
            //heading=Heading.WEST;
            if(ANIMATION>10){
                heading=Heading.WEST_AN;
            }
            if(ANIMATION>20){
                heading=Heading.WEST;
                ANIMATION=0;
            }
        }

            if(newX < 0){
                newX=0;

        }else if (newX>=Game.WIDTH-SPRITE_SCALE * scale){
            newX=Game.WIDTH-SPRITE_SCALE*scale;
        }

        if(newY < 0){
            newY=0;

        }else if (newY>=Game.HEIGHT-SPRITE_SCALE * scale){
            newY=Game.HEIGHT-SPRITE_SCALE*scale;
        }

        x= newX;
        y=newY;
    }
    public void render(Graphics2D g){
        spriteMap.get(heading).render(g,x,y);

    }


}
