/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Filters;

import DigitalImageProcess.DigitalProcess;
import DigitalImageProcess.Tools.Mask;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jorismar
 */
public class Correlation extends DigitalProcess {
    @Override
    protected int transform(BufferedImage img, int x, int y, Object arg) {
        Mask mask = (Mask) arg;
        int r = 0, g = 0, b = 0;
        
        for(int my = 0, py = y - mask.getHeight() / 2; my < mask.getHeight() && py < img.getHeight(); my++, py++) {
            if(py < 0)
                continue;
            
            for(int mx = 0, px = x - mask.getWidth() / 2; mx < mask.getWidth() && px < img.getWidth(); mx++, px++) {
                if(px < 0)
                    continue;
                
                Color color = new Color(img.getRGB(px, py), true);
                
                r += mask.getValue(mx, my) * color.getRed();
                g += mask.getValue(mx, my) * color.getGreen();
                b += mask.getValue(mx, my) * color.getBlue();
            }
        }
        
        r = r > 255 ? 255 : r < 0 ? 0 : r;
        g = g > 255 ? 255 : g < 0 ? 0 : g;
        b = b > 255 ? 255 : b < 0 ? 0 : b;

        return new Color(r, g, b).getRGB();
    }
}
