/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Filters;

import java.awt.Color;
import java.awt.image.BufferedImage;
import DigitalImageProcess.Tools.Mask;
import DigitalImageProcess.DigitalProcess;

/**
 *
 * @author Jorismar
 */
public class Correlation extends DigitalProcess {
    @Override
    protected int transform(BufferedImage img, int x, int y, Object arg) {
        int[] rgb = this.applyAndGetBands(img, x, y, (Mask) arg);
        
        rgb[0] = rgb[0] > 255 ? 255 : rgb[0] < 0 ? 0 : rgb[0];
        rgb[1] = rgb[1] > 255 ? 255 : rgb[1] < 0 ? 0 : rgb[1];
        rgb[2] = rgb[2] > 255 ? 255 : rgb[2] < 0 ? 0 : rgb[2];

        return new Color(rgb[0], rgb[1], rgb[1]).getRGB();
    }
    
    public int applyAndGetRGB(BufferedImage img, int x, int y, Mask mask) {
        return this.transform(img, x, y, mask);
    }
    
    public int[] applyAndGetBands(BufferedImage img, int x, int y, Mask mask) {
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
        
        return new int[]{r, g, b};
    }
}
