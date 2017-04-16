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
    public static long elapsedTime = 0;
    public static BufferedImage processedImage = null;
    
    public BufferedImage apply(BufferedImage img, Object arg) {
        // Start a new image
        if(DigitalProcess.processedImage == null)
            DigitalProcess.processedImage = new BufferedImage(
                img.getWidth(), 
                img.getHeight(), 
                img.getType()
            );
        
        // Gets start operation time
        long startOperationTime = System.nanoTime();
        
        // Apply operation to image
        for(int y = 0; y < img.getHeight(); y++)
            for(int x = 0; x < img.getWidth(); x++)
                DigitalProcess.processedImage.setRGB(x, y, this.transform(img, x, y, arg));
        
        // Gets end operation time
        long endOperationTime = System.nanoTime();
        
        // Update elapsed time
        DigitalProcess.elapsedTime = endOperationTime - startOperationTime;
        
        // Return the processed image
        return DigitalProcess.processedImage;
    }
    
    protected abstract int transform(BufferedImage img, int px, int py, Object arg);
}