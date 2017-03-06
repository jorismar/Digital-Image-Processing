/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Tools;

import java.awt.image.BufferedImage;

/**
 *
 * @author Jorismar
 */
public class Image {
    public static BufferedImage clone(BufferedImage img) {
        if(img == null)
            return null;
        
        /***************************************************
        BufferedImage image = new BufferedImage(
            img.getColorModel(), 
            img.copyData(null), 
            img.getColorModel().isAlphaPremultiplied(), 
            null
        );
        ***************************************************/
        
        /***************************************************/
        BufferedImage image = new BufferedImage(
            img.getWidth(), 
            img.getHeight(), 
            img.getType()
        );

        for(int y = 0; y < img.getHeight(); y++)
            for(int x = 0; x < img.getWidth(); x++)
                image.setRGB(x, y, img.getRGB(x, y));
        /***************************************************/
        
        return image;
    }
    
    public static int getProportionalWidth(int height, int width, int new_height) {
        return (int)(((double) width / (double)height) * (double)new_height);
    }

    public static int getProportionalHeight(int height, int width, int new_width) {
        return (int)(((double)height / (double)width) * (double)new_width);
    }
}
