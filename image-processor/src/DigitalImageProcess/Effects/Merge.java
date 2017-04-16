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
public class Merge extends DigitalImageProcess.DigitalProcess {
    @Override
    protected int transform(BufferedImage imgA, int px, int py, Object arg) {
    	BufferedImage imgB = (BufferedImage) arg;
        
    	Color colorA = new Color(imgA.getRGB(px, py));
        
        if (px > imgB.getWidth() - 1 || py > imgB.getHeight() - 1)
            return colorA.getRGB();
        
    	Color colorB = new Color(imgB.getRGB(px, py));
    	
    	int R = Math.round((float)(colorA.getRed() + colorB.getRed()) / 2.0f);
    	int G = Math.round((float)(colorA.getGreen() + colorB.getGreen()) / 2.0f);
    	int B = Math.round((float)(colorA.getBlue() + colorB.getBlue()) / 2.0f);
    	
    	return new Color(R,G,B).getRGB();
    }
}