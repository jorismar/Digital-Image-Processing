package DigitalImageProcess.Luminosity;

import DigitalImageProcess.Colors.ColorSpace;
import java.awt.Color;
import java.awt.image.BufferedImage;
import DigitalImageProcess.DigitalProcess;

public class MultiplicativeBrightnes extends DigitalProcess {
    @Override
    protected int transform(BufferedImage img, int px, int py, Object arg) {
        float C = (float)arg;

        Color color = new Color(img.getRGB(px, py));

        float r = color.getRed();
        float g = color.getGreen();
        float b = color.getBlue();

        r *= C;
        r = Math.round(r < 0 ? 0: r > 255 ? 255: r);

        if(this.current_color_space == ColorSpace.RGB) {
            g *= C;
            b *= C;
            g = Math.round(g < 0 ? 0: g > 255 ? 255: g);
            b = Math.round(b < 0 ? 0: b > 255 ? 255: b);
        }

        return new Color((int)r, (int)g, (int)b).getRGB();		
    }

    private final int current_color_space;

    public MultiplicativeBrightnes(int current_color_space) {
        this.current_color_space = current_color_space;
    }
}
