package com.kellahselai.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by pc2 on 22.07.16.
 */
public class Sprite {

    private float scale;

    private SpriteSheet sheet;

    public Sprite(SpriteSheet sheet, float scale){
        this.scale = scale;
        this.sheet = sheet;

    }

    public void render(Graphics2D g, float x, float y){
        BufferedImage image = sheet.getSprite(0);
        g.drawImage(image,(int)(x),(int)(y),(int) (image.getWidth() * scale),(int)(image.getHeight() * scale ),null);


    }
}
