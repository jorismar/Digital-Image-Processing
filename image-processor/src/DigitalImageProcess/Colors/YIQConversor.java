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
public class YIQConversor extends DigitalProcess {
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        boolean to_yiq = (boolean) arg;
        
        Color color = new Color(img.getRGB(px, py));
        
        int[] rgb;
        
        if(to_yiq) {
            float[] yiq = this.convertRGBtoYIQ(color);
            rgb = new int[]{(int)yiq[0], (int)yiq[1], (int)yiq[2]};
        } else
            rgb = this.convertYIQtoRGB(color);
        
        return new Color(rgb[0], rgb[1], rgb[2]).getRGB();
    }
    
    public float[] convertRGBtoYIQ(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        float y = ((0.299f * r) + (0.587f * g) + (0.114f * b));
        float i = ((0.596f * r) - (0.275f * g) - (0.321f * b));
        float q = ((0.212f * r) - (0.523f * g) + (0.311f * b));       
        
        i = i < 0? 0 : i;
        q = q < 0? 0 : q; 
        
        return new float[]{y, i, q};
    }
    
    public int[] convertYIQtoRGB(Color color) {
        int y = color.getRed();
        int i = color.getGreen();
        int q = color.getBlue();

        int r = (int)Math.round(y + (0.956 * i) + (0.621 * q));
        int g = (int)Math.round(y - (0.272 * i) - (0.647 * q));
        int b = (int)Math.round(y - (1.106 * i) + (1.703 * q));

        r = r > 255 ? 255 : r < 0 ? 0 : r;
        g = g > 255 ? 255 : g < 0 ? 0 : g;
        b = b > 255 ? 255 : b < 0 ? 0 : b;
        
        return new int[]{r, g, b};
    }
}
