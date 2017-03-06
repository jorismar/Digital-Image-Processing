/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Effects;

import java.awt.Color;
import java.awt.image.BufferedImage;
import DigitalImageProcess.DigitalProcess;
import DigitalImageProcess.Colors.YIQConversor;

/**
 *
 * @author Jorismar
 */
public class Thresholding extends DigitalProcess {
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        Integer T = (Integer) arg;

        double[] yiq = new YIQConversor().convertRGBtoYIQ(new Color(img.getRGB(px, py)));
        
        yiq[0] = yiq[0] > T ? T : yiq[0];
        //yiq[1] = yiq[1] > T ? T : yiq[1];
        //yiq[2] = yiq[2] > T ? T : yiq[2];
        
        return new Color((int)yiq[0], (int)yiq[1], (int)yiq[2]).getRGB();
        
        /*
        Color color = new Color(img.getRGB(px, py));

        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        r = r > T ? T : r;
        g = g > T ? T : g;
        b = b > T ? T : b;

        return new Color(r, g, b).getRGB();
        */
    }
}
