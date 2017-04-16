/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Luminosity;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jorismar
 */
public class HistogramEqualization extends DigitalImageProcess.DigitalProcess {
    private final int[][][] RGB;

    public HistogramEqualization() {
        super();
        this.RGB = new int[3][256][2];

        // Start color counter
        for(int i = 0; i < 256; i++) {
            this.RGB[0][i][0] = 0;  // Red
            this.RGB[1][i][0] = 0;  // Green
            this.RGB[2][i][0] = 0;  // Blue
        }
    }

    @Override
    public BufferedImage apply(BufferedImage img, Object arg) {
        // Counting the levels of color bands.
        for(int x = 0; x < img.getWidth(); x++) {
            for(int y = 0; y < img.getHeight(); y++) {
                Color color = new Color(img.getRGB(x, y));

                this.RGB[0][color.getRed()][0]++;   // Red count
                this.RGB[1][color.getGreen()][0]++; // Green count
                this.RGB[2][color.getBlue()][0]++;  // Blue count
            }
        }

        float c = 255.0f / (float)(img.getWidth() * img.getHeight());
        
        int countR = 0;
        int countG = 0;
        int countB = 0;
        
        for(int i = 0; i < 256; i++) {
            // Bands count
            countR += this.RGB[0][i][0];  // Red
            countG += this.RGB[1][i][0];  // Green
            countB += this.RGB[2][i][0];  // Blue

            // Get F value
            this.RGB[0][i][1] = Math.round(c * countR);  // Red
            this.RGB[1][i][1] = Math.round(c * countG);  // Green
            this.RGB[2][i][1] = Math.round(c * countB);  // Blue
        }

        return super.apply(img, arg);
    }
    
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        Color c = new Color(img.getRGB(px, py));
        return new Color(RGB[0][c.getRed()][1], RGB[1][c.getGreen()][1], RGB[2][c.getBlue()][1]).getRGB();
    }
}