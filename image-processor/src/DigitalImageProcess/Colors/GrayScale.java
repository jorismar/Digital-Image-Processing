/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Colors;
import DigitalImageProcess.DigitalProcess;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jorismar
 */
public class GrayScale extends DigitalProcess {
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        Color color = new Color(img.getRGB(px, py));
        
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        
        int gray_scale = (int)Math.round((r + g + b) / 3.0f);

        return new Color(gray_scale, gray_scale, gray_scale).getRGB();
    }    
}
