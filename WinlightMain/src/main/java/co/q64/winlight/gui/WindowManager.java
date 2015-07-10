package co.q64.winlight.gui;

import java.awt.image.BufferedImage;

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
		window.open();
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

	public BufferedImage getBlur() {
		return blur;
	}
}
