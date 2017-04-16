/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalImageProcess.Filters;

import DigitalImageProcess.Tools.QuickSelect;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 *
 * @author Jorismar
 */
public class Median extends DigitalImageProcess.DigitalProcess {
    public static final byte USE_SORTING = 0x01;
    public static final byte USE_QUICKSELECTION = 0x01;
    
    private byte selectedType;
    
    public Median(byte type) {
        this.selectedType = type;
    }

    public void setType(byte selectedType) {
        this.selectedType = selectedType;
    }

    public byte getType() {
        return selectedType;
    }
    
    @Override
    protected int transform(BufferedImage img, int px, int py, Object inMatrixWidth) {
        int matrixWidth = (int) inMatrixWidth;
        int matSize = matrixWidth * matrixWidth;
        
        int[] listR = new int[matSize];
        int[] listG = new int[matSize];
        int[] listB = new int[matSize];
        
        Arrays.fill(listR, 0);
        Arrays.fill(listG, 0);
        Arrays.fill(listB, 0);
        
        for (int x = px - Math.round((float) matrixWidth/2), count = 0; x < px + (matrixWidth/2); x++)
            for (int y = py - Math.round((float) matrixWidth/2); y < py + (matrixWidth/2); y++) {
                if (x >= 0 && x < img.getWidth() && y >= 0 && y < img.getHeight()) {
                    Color color = new Color(img.getRGB(x, y));
                    
                    listR[count] = color.getRed();
                    listG[count] = color.getGreen();
                    listB[count] = color.getBlue();
                    
                    color = null;
                    count++;
                }
            }
        
        int r = 0;
        int g = 0;
        int b = 0;
        
        if (this.selectedType == Median.USE_SORTING) {
            Arrays.sort(listR);
            Arrays.sort(listG);
            Arrays.sort(listB);
            
            r = listR[listR.length/2];
            g = listG[listG.length/2];
            b = listB[listB.length/2];
        } else if (this.selectedType == Median.USE_QUICKSELECTION) {
            r = QuickSelect.getMedian(listR);
            g = QuickSelect.getMedian(listG);
            b = QuickSelect.getMedian(listB);
        }
        
        return new Color(r, g, b).getRGB();
    }
}
