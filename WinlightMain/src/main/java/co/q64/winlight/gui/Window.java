package co.q64.winlight.gui;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JWindow;

import co.q64.winlight.input.FocusEvent;

public class Window extends JWindow {

	private static final long serialVersionUID = 1L;
	
	public static int WIDTH = 700;
	public static int SMALL_HEIGHT = 50;
	public static int HEIGHT = 500;
	public static int X = (int) ((Toolkit.getDefaultToolkit()
				.getScreenSize().getWidth() - WIDTH) / 2.0);
	public static int Y = (int) ((Toolkit.getDefaultToolkit()
			.getScreenSize().getHeight() - HEIGHT) / 2.0);
	
	public Window() {
	}

	public void open() {
		add(new Renderer());
		pack();
		setBackground(new Color(0,0,0,0));
		setSize(WIDTH, SMALL_HEIGHT);
		setMinimumSize(getSize());
		setLocation(X, Y);
		addWindowFocusListener(new FocusEvent());
		setVisible(true);
	}

	public void hideWindow() {
		setVisible(false);
	}

	public void showWindow() {
		setVisible(true);
	}
}
