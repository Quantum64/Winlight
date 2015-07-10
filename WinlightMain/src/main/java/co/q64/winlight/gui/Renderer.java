package co.q64.winlight.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Renderer extends JComponent {

	private static final long serialVersionUID = 1L;

	@Override
	public Dimension getMinimumSize() {
		return new Dimension(100, 100);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 300);
	}

	@Override
	public void paintComponent(Graphics g) {
		int margin = 10;
		Dimension dim = getSize();
		super.paintComponent(g);
		g.setColor(Color.red);
		g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin
				* 2);
	}
}