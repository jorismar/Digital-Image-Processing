/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Filters;

import DigitalImageProcess.Tools.Mask;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

/**
 *
 * @author Jorismar
 */
public class Sobel extends DigitalImageProcess.DigitalProcess {
    private BufferedImage img_horizontal;
    private BufferedImage img_vertical;
    
    @Override
    public BufferedImage apply(BufferedImage img, Object arg) {
        Mask to_lines = new Mask(
            new int[][] {
                { 1,  2,  1}, 
                { 0,  0,  0}, 
                {-1, -2, -1}
            }
        );
        
        Mask to_columns = new Mask(
            new int[][] {
                {-1,  0,  1}, 
                {-2,  0,  2}, 
                {-1,  0,  1}
            }
        );

        this.img_horizontal = new Convolution().apply(img, to_lines);
        this.img_vertical = new Convolution().apply(img, to_columns);
        
        return super.apply(img, arg);
    }

    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        Color ch = new Color(this.img_horizontal.getRGB(px, py), true);
        Color cv = new Color(this.img_vertical.getRGB(px, py), true);

        int r = (int) Math.round(
            Math.sqrt(
                (ch.getRed() * ch.getRed()) + (cv.getRed() * cv.getRed())
            )
        );
        
        int g = (int) Math.round(
            Math.sqrt(
                (ch.getGreen() * ch.getGreen()) + (cv.getGreen() * cv.getGreen())
            )
        );
        
        int b = (int) Math.round(
           Math.sqrt(
                (ch.getBlue() * ch.getBlue()) + (cv.getBlue() * cv.getBlue())
           )
        );

        r = r > 255 ? 255 : r < 0 ? 0 : r;
        g = g > 255 ? 255 : g < 0 ? 0 : g;
        b = b > 255 ? 255 : b < 0 ? 0 : b;

        return new Color(r, g, b).getRGB();
    }
}
