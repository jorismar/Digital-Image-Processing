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
        Integer matrix_width = (Integer) matx_width;
        /*
        Mask mask = new Mask();
        
        mask.fillMask(1);
        
        int[] rgb = new Correlation().applyMask(img, px, py, mask);
        
        int px0 = px - mask.getWidth() / 2;
        int py0 = py - mask.getHeight() / 2;
        */
        
        int r = 0, g = 0, b = 0;
       
        long len = matrix_width * matrix_width;
        
        for (int x = px - (Math.round((float)(matrix_width / 2))); x < (px + (matrix_width / 2)); x++)
            for (int y = py - (Math.round((float)(matrix_width / 2))); y < (py + (matrix_width / 2)); y++)
                if (x >= 0 && x < img.getWidth() && y >= 0 && y < img.getHeight()) {
                    Color color = new Color(img.getRGB(x, y), true);
                    
                    r += color.getRed();
                    g += color.getGreen();
                    b += color.getBlue();
                } else len--;

        return new Color(Math.round(r/len), Math.round(g/len), Math.round(b/len)).getRGB();
        
    }
}
