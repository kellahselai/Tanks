package com.kellahselai.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by pc2 on 22.07.16.
 */
public class ResourceLoader {

    public static final String PATH = "res/";

    public static BufferedImage LoadImage(String fileName){
        BufferedImage image = null;

        try{
            image = ImageIO.read( new File(PATH + fileName));



        }catch(IOException e){
            e.printStackTrace();
        }

        return image;

    }

}
