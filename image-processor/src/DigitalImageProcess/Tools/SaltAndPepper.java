/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Tools;

import DigitalImageProcess.DigitalProcess;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Jorismar
 */
public class SaltAndPepper extends DigitalProcess {
    @Override
    public BufferedImage apply(BufferedImage img, Object arg) {
        float rate = (float) arg;

        int px_num = Math.round(img.getHeight() * img.getWidth() * rate);
        Random generator = new Random();
        
        // Copy image
        for(int y = 0; y < img.getHeight(); y++)
            for(int x = 0; x < img.getWidth(); x++)
                DigitalProcess.TEMP_IMAGE.setRGB(x, y, img.getRGB(x, y));
        
        for(int i = 0; i < px_num; i++) {
            // Apply salt
            this.transform(
                DigitalProcess.TEMP_IMAGE,    
                generator.nextInt(img.getWidth()),  // x
                generator.nextInt(img.getHeight()), // y
                255                                 // color (white)
            );
            
            // Apply pepper
            this.transform(
                DigitalProcess.TEMP_IMAGE,    
                generator.nextInt(img.getWidth()),  // x
                generator.nextInt(img.getHeight()), // y
                0                                   // color (white)
            );
        }
        
        return DigitalProcess.TEMP_IMAGE;
    }
    
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        int value = (int) arg;
        
        if(img.getRGB(px, py) == value)
            value = value == 0 ? 255 : 0;
        
        img.setRGB(px, py, new Color(value, value, value).getRGB());
        
        return 0;
    }
}
