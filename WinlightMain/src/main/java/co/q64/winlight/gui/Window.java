package co.q64.winlight.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JTextField;
import javax.swing.JWindow;

import co.q64.winlight.input.FocusEvent;

public class Window extends JWindow {

	private static final long serialVersionUID = 1L;

	public static int WIDTH = 700;
	public static int SMALL_HEIGHT = 50;
	public static int HEIGHT = 500;
	public static int X = (int) ((Toolkit.getDefaultToolkit().getScreenSize()
			.getWidth() - WIDTH) / 2.0);
	public static int Y = (int) ((Toolkit.getDefaultToolkit().getScreenSize()
			.getHeight() - HEIGHT) / 2.0);

	private Renderer r = new Renderer();
	private boolean isSmall = true;
	private JTextField textField = new JTextField();

	public Window() {
	}

	public void open() throws FontFormatException, IOException {

		InputStream is = Window.class.getResourceAsStream("/Futura.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, is);

		textField = new JTextField();
		textField.setEditable(true);
		textField.setFont(font);
		textField.setLocation(100, 10);
		textField.setSize(600, 40);
		textField.setText("asdasdasd");
		textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textField.setBackground(new Color(1, 1, 1, 1));
		add(textField);
		r.setLocation(0, 0);
		r.setSize(1000, 1000);
		add(r);

		setBackground(new Color(0, 0, 0, 0));
		setSize(WIDTH + 60, SMALL_HEIGHT + 120);
		setMinimumSize(getSize());
		setLocation(X - 30, Y - 20);
		setLayout(null);
		addWindowFocusListener(new FocusEvent());
		setVisible(true);
		Thread u = new Thread(new Update());
		u.run();
	}

	public void hideWindow() {
		setVisible(false);
	}

	public void showWindow() {
		setVisible(true);
		Thread u = new Thread(new Update());
		u.run();
	}

	public boolean isSmall() {
		return isSmall;
	}

	public Renderer getRenderer() {
		return r;
	}
}
