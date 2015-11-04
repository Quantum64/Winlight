package co.q64.winlight.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.jhlabs.image.GaussianFilter;

public class Shadow {

	private static BufferedImage shadow;
	private static GaussianFilter gf10 = new GaussianFilter(10);
	private static GaussianFilter gf20 = new GaussianFilter(30);

	public static BufferedImage getShadow(BufferedImage image, boolean refresh) {

		if (shadow != null && refresh == false) {
			return shadow;
		}

		BufferedImage mask = new BufferedImage(image.getWidth(),
				image.getHeight(), BufferedImage.TYPE_INT_ARGB);

		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				int argb = image.getRGB(x, y);
				argb = (int) ((argb >> 24 & 0xFF) * 0.4f) << 24
						| Color.black.getRGB() & 0x00FFFFFF;
				mask.setRGB(x, y, argb);
			}
		}
		BufferedImage glow = new BufferedImage(image.getWidth() + 10,
				image.getHeight() + 60, image.getType());
		Graphics2D g = glow.createGraphics();
		g.drawImage(mask, 26, 12, image.getWidth() - 23,
				image.getHeight() - 16, null);
		g.dispose();
		BufferedImage filteredGlow = new BufferedImage(image.getWidth() + 10,
				image.getHeight() + 60, image.getType());
		gf10.filter(glow, filteredGlow);

		BufferedImage drop = new BufferedImage(image.getWidth() + 10,
				image.getHeight() + 60, image.getType());
		Graphics2D g2 = drop.createGraphics();
		g2.drawImage(mask, 55, 22, image.getWidth() - 75,
				image.getHeight() - 18, null);
		g2.dispose();
		BufferedImage filteredDrop = new BufferedImage(image.getWidth() + 10,
				image.getHeight() + 60, image.getType());
		gf20.filter(drop, filteredDrop);

		BufferedImage result = new BufferedImage(image.getWidth() + 10,
				image.getHeight() + 60, image.getType());
		Graphics2D g2d = result.createGraphics();
		g2d.drawImage(filteredGlow, 0, 0, filteredGlow.getWidth(),
				filteredGlow.getHeight(), null);
		g2d.drawImage(filteredDrop, 0, 0, filteredDrop.getWidth(),
				filteredDrop.getHeight(), null);
		g2d.dispose();

		return result;
	}
}
