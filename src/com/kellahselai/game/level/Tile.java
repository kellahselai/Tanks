package com.kellahselai.game.level;

import com.kellahselai.graphics.SpriteSheet;
import com.kellahselai.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by pc2 on 23.07.16.
 */
public class Tile {

    private BufferedImage image;
    private TileType type;


    protected Tile(BufferedImage image, int scale, TileType type){
        this.type= type;
        this.image = Utils.resize(image,image.getWidth()*scale,image.getHeight()*scale);

    }

     protected void render(Graphics2D g,int x, int y){
         g.drawImage(image,x,y,null);

     }
    protected TileType type(){
        return type;
    }

}
