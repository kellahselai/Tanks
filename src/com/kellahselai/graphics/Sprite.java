package com.kellahselai.graphics;

import com.kellahselai.utils.Utils;

import javax.rmi.CORBA.Util;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by pc2 on 22.07.16.
 */
public class Sprite {

    private float scale;

    private SpriteSheet sheet;
    private BufferedImage image;
    public Sprite(SpriteSheet sheet, float scale){
        this.scale = scale;
        this.sheet = sheet;
        image = sheet.getSprite(0);
        image = Utils.resize(image,(int) (image.getWidth() * scale),(int)(image.getHeight() * scale ));

    }

    public void render(Graphics2D g, float x, float y){

        g.drawImage(image,(int)(x),(int)(y),null);


    }
}
