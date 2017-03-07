/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Luminosity;

import DigitalImageProcess.Colors.ColorSpace;
import java.awt.Color;
import java.awt.image.BufferedImage;
import DigitalImageProcess.DigitalProcess;

/**
 *
 * @author Jorismar
 */
public class AdditiveBrightnes extends DigitalProcess {
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        int C = (int)arg;

        Color color = new Color(img.getRGB(px, py));

        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        
        r += C;
        r = r < 0 ? 0: r > 255 ? 255: r;

        if(this.current_color_space == ColorSpace.RGB) {
            g += C;
            b += C;
            g = g < 0 ? 0: g > 255 ? 255: g;
            b = b < 0 ? 0: b > 255 ? 255: b;
        }

        return new Color(r, g, b).getRGB();
    }

    private int current_color_space;

    public AdditiveBrightnes(int current_color_space) {
        this.current_color_space = current_color_space;
    }

    public void setColorSpace(int color_space) {
        this.current_color_space = color_space;
    }
}
