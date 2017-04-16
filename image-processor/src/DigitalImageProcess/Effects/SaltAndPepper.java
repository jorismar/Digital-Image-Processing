/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Effects;

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
                DigitalProcess.processedImage.setRGB(x, y, img.getRGB(x, y));
        
        for(int i = 0; i < px_num; i++) {
            // Apply salt
            this.transform(DigitalProcess.processedImage,    
                generator.nextInt(img.getWidth()),  // x
                generator.nextInt(img.getHeight()), // y
                255                                 // color (white)
            );
/*            
            // Apply pepper
            this.transform(
                DigitalProcess.processedImage,    
                generator.nextInt(img.getWidth()),  // x
                generator.nextInt(img.getHeight()), // y
                0                                   // color (white)
            );*/
        }
        
        return DigitalProcess.processedImage;
    }
    
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        Color color = new Color(img.getRGB(px, py));
        
        if(color.getRed() == color.getGreen() && color.getRed() == color.getBlue()) {
            int value = new Random().nextInt(2) == 0 ? 0 : 255;
            img.setRGB(px, py, new Color(value, value, value).getRGB());
        } else {
            int select_band = new Random().nextInt(3);
            
            if(select_band == 0)
                img.setRGB(px, py, new Color(255, 0, 0).getRGB());
            else if(select_band == 1)
                img.setRGB(px, py, new Color(0, 255, 0).getRGB());
            else
                img.setRGB(px, py, new Color(0, 0, 255).getRGB());
        }
            
        return 0;
    }
}
