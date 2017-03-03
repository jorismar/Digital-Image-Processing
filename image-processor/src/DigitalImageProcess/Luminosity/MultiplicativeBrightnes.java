package DigitalImageProcess.Luminosity;

import java.awt.Color;
import java.awt.image.BufferedImage;

import DigitalImageProcess.DigitalProcess;

public class MultiplicativeBrightnes extends DigitalProcess {

	@Override
	protected int transform(BufferedImage img, int px, int py, Object arg) {
		Integer C = (Integer) arg;

		Color color = new Color(img.getRGB(px, py));

		int R = color.getRed()   * C;
		int G = color.getGreen() * C;
		int B = color.getBlue()  * C;

		R = R < 0 ? 0: R > 255 ? 255: R;
		G = G < 0 ? 0: G > 255 ? 255: G;
		B = B < 0 ? 0: B > 255 ? 255: B;
		
		return new Color(R, G, B).getRGB();		
	}
}
