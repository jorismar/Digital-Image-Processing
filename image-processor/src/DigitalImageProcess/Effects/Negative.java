/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Effects;

import DigitalImageProcess.Colors.ColorSpace;
import DigitalImageProcess.Colors.YIQConversor;
import java.awt.Color;
import java.awt.image.BufferedImage;
import DigitalImageProcess.DigitalProcess;

/**
 *
 * @author Jorismar
 */
public class Negative extends DigitalProcess {
    private int current_color_space;

    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        //int is_yiq = (boolean)arg;
        Color color = new Color(img.getRGB(px, py));

        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        
        r = 255 - r;
        //if(is_yiq) {
            //double[] yiq = new YIQConversor().convertRGBtoYIQ(new Color(img.getRGB(px, py)));
            //return new Color(255 - (int)yiq[0], (int)yiq[1], (int)yiq[2]).getRGB();
        if(this.current_color_space != ColorSpace.YIQ) {
            g = 255 - g;
            b = 255 - b;
        }
        
        return new Color(r, g, b).getRGB();
    }

    public Negative(int current_color_space) {
        this.current_color_space = current_color_space;
    }
}
