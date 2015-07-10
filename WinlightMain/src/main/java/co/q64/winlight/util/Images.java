package co.q64.winlight.util;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public static Image SEARCH = null;
	
	static {
		try {
			SEARCH = ImageIO.read(Images.class.getResourceAsStream("/search.png"));
		} catch (IOException e) {
			SEARCH = null;
			e.printStackTrace();
		}
	}
}
