/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Effects;

import java.awt.Color;
import java.awt.image.BufferedImage;
import DigitalImageProcess.DigitalProcess;

/**
 *
 * @author Jorismar
 */
public class Thresholding extends DigitalProcess {

    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        Integer T = (Integer) arg;

        Color color = new Color(img.getRGB(px, py));

        int R = color.getRed();
        int G = color.getGreen();
        int B = color.getBlue();

        //check and set threshold T in 3 channels
        R = R > T ? 255 : 0;
        G = G > T ? 255 : 0;
        B = B > T ? 255 : 0;

        return new Color(R, G, B).getRGB();
    }
}
