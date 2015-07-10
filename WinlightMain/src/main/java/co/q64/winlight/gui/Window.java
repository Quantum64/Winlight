package co.q64.winlight.gui;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	public Window() {
		setUndecorated(true);
	}

	public void open() {
		add(new Renderer());
		pack();
		setMinimumSize(getSize());
		setVisible(true);
	}

	public void hideWindow() {
		setVisible(false);
	}

	public void showWindow() {
		setVisible(true);
	}
}
