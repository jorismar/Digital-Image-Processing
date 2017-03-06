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
    public BufferedImage apply(BufferedImage img, Object arg) {
        BufferedImage output = new BufferedImage(
            img.getWidth(), 
            img.getHeight(), 
            img.getType()
        );
        
        for(int y = 0; y < img.getHeight(); y++)
            for(int x = 0; x < img.getWidth(); x++)
                output.setRGB(x, y, this.transform(img, x, y, arg));
        
        return output;
    }
    
    protected abstract int transform(BufferedImage img, int px, int py, Object arg);
}