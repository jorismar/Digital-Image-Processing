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
    private int current_color_space;
    
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        int T = (int) arg;
        int result;
        Color color = new Color(img.getRGB(px, py));
        
        if(this.current_color_space != ColorSpace.YIQ) {
            double[] yiq = new YIQConversor().convertRGBtoYIQ(color);

            yiq[0] = yiq[0] > T ? T : yiq[0];
            //yiq[1] = yiq[1] > T ? T : yiq[1];
            //yiq[2] = yiq[2] > T ? T : yiq[2];

            result = new Color((int)yiq[0], (int)yiq[1], (int)yiq[2]).getRGB();
        } else {
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();

            r = r > T ? T : r;
            //g = g > T ? T : g;
            //b = b > T ? T : b;

            result = new Color(r, g, b).getRGB();
        }
        
        return result;
    }

    public Thresholding(int color_space) {
        this.current_color_space = color_space;
    }
}
