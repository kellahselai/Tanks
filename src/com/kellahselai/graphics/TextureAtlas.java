package com.kellahselai.graphics;

import com.kellahselai.utils.ResourceLoader;

import java.awt.image.BufferedImage;
import com.kellahselai.utils.ResourceLoader;

/**
 * Created by pc2 on 22.07.16.
 */
public class TextureAtlas {

    BufferedImage image;

    public TextureAtlas(String imageName){
        image= ResourceLoader.LoadImage(imageName);

    }

    public BufferedImage cut(int x, int y, int w, int h){
        return image.getSubimage(x,y,w,h);
    }
}
