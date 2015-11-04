package co.q64.winlight.gui;

import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;

import co.q64.winlight.util.Blur;

public class WindowManager {

	private static WindowManager wm;

	private Window window;
	private BufferedImage blur;

	public static WindowManager getWindowManager() {
		if (wm == null) {
			wm = new WindowManager();
		}
		return wm;
	}

	private WindowManager() {
		window = new Window();
	}

	public void openWindow() {
		blur = Blur.genBlur();
		try {
			window.open();
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public void showWindow() {
		blur = Blur.genBlur();
		window.showWindow();
	}

	public void hideWindow() {
		window.hideWindow();
	}

	public Window getWindow() {
		return window;
	}

	public int getX() {
		return Window.X;
	}

	public int getY() {
		return Window.Y;
	}

	public int getWidth() {
		return Window.WIDTH;
	}

	public int getHeight() {
		if (window.isSmall()) {
			return Window.SMALL_HEIGHT;
		}
		return Window.HEIGHT;
	}

	public BufferedImage getBlur() {
		return blur;
	}
}
