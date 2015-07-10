package co.q64.winlight.gui;

public class WindowManager {
	
	private static WindowManager wm;
	
	private Window window;

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
		window.open();
	}

	public void showWindow() {
		window.showWindow();
	}

	public void hideWindow() {
		window.hideWindow();
	}
}
