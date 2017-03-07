/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Filters;

import DigitalImageProcess.DigitalProcess;
import DigitalImageProcess.Tools.Mask;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jorismar
 */
public class Laplaciano extends DigitalProcess {
    @Override
    public BufferedImage apply(BufferedImage img, Object arg) {
        Mask mask_laplaciano = new Mask(
            new int[][] {
                {  0, -1,  0}, 
                { -1,  4, -1}, 
                {  0, -1,  0}
            }
        );
        
        return super.apply(img, mask_laplaciano);
    }

    @Override
    protected int transform(BufferedImage img, int x, int y, Object arg) {
        return new Correlation().applyAndGetRGB(img, x, y, (Mask) arg);
    }
}
