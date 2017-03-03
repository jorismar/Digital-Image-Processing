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
        
        return new BufferedImage(
            img.getColorModel(), 
            img.copyData(null), 
            img.getColorModel().isAlphaPremultiplied(), 
            null
        );
    }
    
    public static int getProportionalWidth(int height, int width, int new_height) {
        return (int)(((double) width / (double)height) * (double)new_height);
    }

    public static int getProportionalHeight(int height, int width, int new_width) {
        return (int)(((double)height / (double)width) * (double)new_width);
    }
}
