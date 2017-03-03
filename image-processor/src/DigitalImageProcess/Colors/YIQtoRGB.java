/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Colors;

import java.awt.*;
import java.awt.image.BufferedImage;
import DigitalImageProcess.DigitalProcess;

/**
 *
 * @author Jorismar
 */

public class YIQtoRGB extends DigitalProcess {
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        Color color = new Color(img.getRGB(px, py));

        int y = color.getRed();
        int i = color.getGreen();
        int q = color.getBlue();

        double r = Math.round(y + (0.953 * i) + (0.621 * q));
        double g = Math.round(y - (0.272 * i) - (0.647 * q));
        double b = Math.round(y - (1.106 * i) + (1.703 * q));

        r = r > 255.0 ? 255.0 : r < 0.0 ? 0.0 : r;
        g = g > 255.0 ? 255.0 : g < 0.0 ? 0.0 : g;
        b = b > 255.0 ? 255.0 : b < 0.0 ? 0.0 : b;

        return new Color((int)r, (int)g, (int)b).getRGB();
    }
}
