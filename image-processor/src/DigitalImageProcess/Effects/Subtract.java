/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Effects;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jorismar
 */
public class Subtract extends DigitalImageProcess.DigitalProcess {
    @Override
    protected int transform(BufferedImage imgA, int px, int py, Object arg) {
    	BufferedImage imgB = (BufferedImage) arg;
        
    	Color colorA = new Color(imgA.getRGB(px, py));
        
        if (px > imgB.getWidth() - 1 || py > imgB.getHeight() - 1)
            return colorA.getRGB();
        
    	Color colorB = new Color(imgB.getRGB(px, py));
    	
    	int R = colorA.getRed() - colorB.getRed();
    	int G = colorA.getGreen() - colorB.getGreen();
    	int B = colorA.getBlue() - colorB.getBlue();
    	
    	R = R > 0 ? R : 0;
    	G = G > 0 ? G : 0;
    	B = B > 0 ? B : 0;
    	
    	return new Color(R,G,B).getRGB();
    }
}