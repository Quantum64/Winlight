package co.q64.winlight;

import co.q64.winlight.gui.WindowManager;

public class Winlight {

	private static Winlight instance;

	public static void main(String[] args) {
		instance = new Winlight();
		instance.main();
	}

	private void main() {
		WindowManager.getWindowManager().openWindow();
	}
}
