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
public class Convolution extends DigitalProcess {
    @Override
    public BufferedImage apply(BufferedImage img, Object arg) {
        Mask mask = (Mask) arg;
        Mask mask_rotated = new Mask(mask.getWidth(), mask.getHeight());
        
        // Mask mirroring
        for(int y0 = 0, y1 = mask.getHeight() - 1; y0 < mask.getHeight(); y0++, y1--)
            for(int x0 = 0, x1 = mask.getWidth() - 1; x0 < mask.getWidth(); x0++, x1--)
                mask_rotated.setValue(x0, y0, mask.getValue(x1, y1));
        
        // Apply rotated mask to image
        return super.apply(img, mask_rotated);
    }
    
    @Override
    protected int transform(BufferedImage img, int x, int y, Object arg) {
        return new Correlation().applyAndGetRGB(img, x, y, (Mask) arg);
    }
}
