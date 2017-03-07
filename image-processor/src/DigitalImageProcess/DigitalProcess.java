/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess;

import java.awt.image.BufferedImage;

/**
 *
 * @author Jorismar
 */

public abstract class DigitalProcess {
    public static BufferedImage TEMP_IMAGE = null;
    
    public BufferedImage apply(BufferedImage img, Object arg) {
        if(DigitalProcess.TEMP_IMAGE == null)
            DigitalProcess.TEMP_IMAGE = new BufferedImage(
                img.getWidth(), 
                img.getHeight(), 
                img.getType()
            );
        
        for(int y = 0; y < img.getHeight(); y++)
            for(int x = 0; x < img.getWidth(); x++)
                DigitalProcess.TEMP_IMAGE.setRGB(x, y, this.transform(img, x, y, arg));
        
        return DigitalProcess.TEMP_IMAGE;
    }
    
    protected abstract int transform(BufferedImage img, int px, int py, Object arg);
}