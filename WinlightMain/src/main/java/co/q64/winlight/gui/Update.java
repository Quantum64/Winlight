package co.q64.winlight.gui;

public class Update implements Runnable {

	@Override
	public void run() {
		while (true) {
			if (!WindowManager.getWindowManager().getWindow().isVisible()) {
				break;
			}
			WindowManager.getWindowManager().getWindow().getRenderer()
					.repaint();
		}
	}
}
