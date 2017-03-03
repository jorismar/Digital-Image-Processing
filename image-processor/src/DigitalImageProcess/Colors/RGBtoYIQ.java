/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Colors;

import java.awt.Color;
import java.awt.image.BufferedImage;
import DigitalImageProcess.DigitalProcess;

/**
 *
 * @author Jorismar
 */
public class RGBtoYIQ extends DigitalProcess {
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        Color color = new Color(img.getRGB(px, py));
        
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        double y = Math.round(((0.299f * r) + (0.587f * g) + (0.114f * b)));
        double i = Math.round(((0.596f * r) - (0.274f * g) - (0.322f * b)));
        double q = Math.round(((0.212f * r) - (0.523f * g) + (0.311f * b)));       
        
        i = i < 0? 0 : i;
        q = q < 0? 0 : q; 
        
        return new Color((int)y, (int)i, (int)q).getRGB();
    }
}
