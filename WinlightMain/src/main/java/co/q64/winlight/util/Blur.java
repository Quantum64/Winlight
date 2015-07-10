package co.q64.winlight.util;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.jhlabs.image.GaussianFilter;

public class Blur {
	public static BufferedImage genBlur() {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
				.getScreenSize());
		try {
			BufferedImage capture = new Robot().createScreenCapture(screenRect);
			GaussianFilter gf = new GaussianFilter(20);
			BufferedImage bi = new BufferedImage((int) screenRect.getWidth(),
					(int) screenRect.getHeight(), BufferedImage.TYPE_INT_ARGB);
			gf.filter(capture, bi);
			return bi;
		} catch (AWTException e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}

}
