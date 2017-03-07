/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Filters;

import java.awt.Color;
import java.awt.image.BufferedImage;
import DigitalImageProcess.DigitalProcess;
import DigitalImageProcess.Tools.Mask;

/**
 *
 * @author Jorismar
 */
public class Average extends DigitalProcess {
    @Override
    protected int transform(BufferedImage img, int px, int py, Object matx_width) {
        Integer matrixWH = (Integer) matx_width;
        
        // Create mask
        Mask mask = new Mask(matrixWH, matrixWH);
        mask.fillMask(1);
        
        // Apply mask
        int[] rgb = new Correlation().applyAndGetBands(img, px, py, mask);
        
    // ----- Calculates number of the processed pixels. ----- //
        
        // Matrix Center
        int pxC = matrixWH / 2;
        int pyC = matrixWH / 2;
        
        // M(0,0) position
        int px0 = px - pxC;
        int py0 = py - pyC;
        
        // M(n,n) position
        int pxN = px + matrixWH - pxC - 1;
        int pyN = py + matrixWH - pyC - 1;
        
        // Get number of the processed columns
        int numW;
        numW = px0 < 0 ? matrixWH + px0 : matrixWH;
        numW = pxN >= img.getWidth() ? numW - (pxN - (img.getWidth() - 1)) : numW;
        
        // Get number of the processed lines
        int numH;
        numH = py0 < 0 ? matrixWH + py0 : matrixWH;
        numH = pyN >= img.getHeight() ? numH - (pyN - (img.getHeight() - 1)) : numH;
        
        // Get the number of processed pixels
        int len = numW * numH;
        
    // ------------------------------------------------------ //

        // Return new color of entry pixel.
        return (
            new Color(
                Math.round(rgb[0] / len), 
                Math.round(rgb[1] / len), 
                Math.round(rgb[2] / len)
            ).getRGB()
        );
    }
}
