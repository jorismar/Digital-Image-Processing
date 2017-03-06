package DigitalImageProcess.Luminosity;

import java.awt.Color;
import java.awt.image.BufferedImage;
import DigitalImageProcess.DigitalProcess;

public class MultiplicativeBrightnes extends DigitalProcess {
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        int C = (int)arg;

        Color color = new Color(img.getRGB(px, py));

        double r = color.getRed()   * C;
        double g = color.getGreen() * C;
        double b = color.getBlue()  * C;

        r = Math.round(r < 0 ? 0: r > 255 ? 255: r);
        g = Math.round(g < 0 ? 0: g > 255 ? 255: g);
        b = Math.round(b < 0 ? 0: b > 255 ? 255: b);

        return new Color((int)r, (int)g, (int)b).getRGB();		
    }
}
