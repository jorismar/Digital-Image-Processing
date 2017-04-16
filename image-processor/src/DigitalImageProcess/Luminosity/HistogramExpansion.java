/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Luminosity;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jorismar
 */
public class HistogramExpansion extends DigitalImageProcess.DigitalProcess {
    private int minR, minG, minB;
    private int maxR, maxG, maxB;
    private final int[][] RGB;

    public HistogramExpansion() {
        super();
        this.RGB = new int[3][256];
    }

    @Override
    public BufferedImage apply(BufferedImage img, Object arg) {
        this.minR = 255;
        this.minG = 255;
        this.minB = 255;
        this.maxR = 0;
        this.maxG = 0;
        this.maxB = 0;

        for(int x = 0; x < img.getWidth(); x++)
            for(int y = 0; y < img.getHeight(); y++) {
                Color color = new Color(img.getRGB(x, y));

                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                if(r < this.minR) this.minR = r;
                    else if(r > this.maxR) this.maxR = r;

                if(g < this.minG) this.minG = g;
                    else if(g > this.maxG) this.maxG = g;

                if(b < this.minB) this.minB = b;
                    else if(b > this.maxB) this.maxB = b;
            }

        for(int i = 0; i < 256; i++) {
            this.RGB[0][i] = Math.round((((float)(i - this.minR)) / (float)(this.maxR - this.minR)) * 255.0f);
            this.RGB[1][i] = Math.round((((float)(i - this.minG)) / (float)(this.maxG - this.minG)) * 255.0f);
            this.RGB[2][i] = Math.round((((float)(i - this.minB)) / (float)(this.maxB - this.minB)) * 255.0f);
        }
        
        return super.apply(img, arg);
    }
    
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        Color c = new Color(img.getRGB(px, py));
        return new Color(RGB[0][c.getRed()], RGB[1][c.getGreen()], RGB[2][c.getBlue()]).getRGB();
    }
}