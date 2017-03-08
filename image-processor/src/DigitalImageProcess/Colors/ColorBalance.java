/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Colors;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jorismar
 */
public class ColorBalance extends DigitalImageProcess.DigitalProcess {
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        int[] rgb = (int[]) arg;

        Color color = new Color(img.getRGB(px, py));

        int r = color.getRed()   + rgb[0];
        int g = color.getGreen() + rgb[1];
        int b = color.getBlue()  + rgb[2];

        r = r < 0 ? 0: r > 255 ? 255: r;
        g = g < 0 ? 0: g > 255 ? 255: g;
        b = b < 0 ? 0: b > 255 ? 255: b;

        return new Color(r, g, b).getRGB();
    }
}
