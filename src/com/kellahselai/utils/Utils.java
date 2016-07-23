package com.kellahselai.utils;

import java.awt.image.BufferedImage;

/**
 * Created by pc2 on 23.07.16.
 */
public class Utils {

    public static BufferedImage resize(BufferedImage image, int widht, int height){
        BufferedImage newImage=new BufferedImage(widht,height, BufferedImage.TYPE_INT_ARGB);
        newImage.getGraphics().drawImage(image,0,0,widht,height, null);


        return newImage;
    }
}
