    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Effects;

import DigitalImageProcess.Colors.ColorSpace;
import java.awt.Color;
import java.awt.image.BufferedImage;
import DigitalImageProcess.DigitalProcess;
import DigitalImageProcess.Colors.YIQConversor;

/**
 *
 * @author Jorismar
 */
public class Thresholding extends DigitalProcess {
    private final int current_color_space;
    
    @Override
    public BufferedImage apply(BufferedImage img, Object arg) {
        int Tr = 0, Tg = 0, Tb = 0;
        
        if(arg == null) {
            for(int py = 0; py < img.getHeight(); py++)
                for(int px = 0; px < img.getWidth(); px++) {
                    Color color = new Color(img.getRGB(px, py));
                    Tr += color.getRed();
                    
                    if(this.current_color_space != ColorSpace.YIQ) {
                        Tg += color.getGreen();
                        Tb += color.getBlue();
                    }
                }
        
            Tr = Math.round((float) Tr / (float)(img.getHeight() * img.getWidth()));

            if(this.current_color_space != ColorSpace.YIQ) {
                Tg = Math.round((float) Tg / (float)(img.getHeight() * img.getWidth()));
                Tb = Math.round((float) Tb / (float)(img.getHeight() * img.getWidth()));
                
                Tr = (Tr + Tg + Tb) / 3;
            }
        } else
            Tr = (int) arg;
        
        return super.apply(img, Tr);
    }
    
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        int T = (int) arg;
        int result;
        Color color = new Color(img.getRGB(px, py));
        
        float r = color.getRed();
        float g = color.getGreen();
        float b = color.getBlue();

        if(this.current_color_space == ColorSpace.YIQ) {
            //float[] yiq = new YIQConversor().convertRGBtoYIQ(color);
            
            //float r = yiq[0];
            //float g = yiq[1];
            //float b = yiq[2];
            
            r = r > T ? 255 : 0;
            //g = g > T ? T : g;
            //b = b > T ? T : b;

            result = new Color((int)Math.round(r), (int)Math.round(g), (int)Math.round(b)).getRGB();
        } else {
            r = r > T ? 255 : 0;
            g = g > T ? 255 : 0;
            b = b > T ? 255 : 0;

            result = new Color((int)Math.round(r), (int)Math.round(g), (int)Math.round(b)).getRGB();
        }
        
        return result;
    }

    public Thresholding(int color_space) {
        this.current_color_space = color_space;
    }
}
