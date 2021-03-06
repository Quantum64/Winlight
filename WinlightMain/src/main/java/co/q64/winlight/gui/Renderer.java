package co.q64.winlight.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JTextField;

import co.q64.winlight.util.Images;
import co.q64.winlight.util.Shadow;

public class Renderer extends JComponent {

	private static final long serialVersionUID = 1L;
	
	protected Renderer() {

	}

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
		System.out.println("Paint");
		Graphics2D g2 = (Graphics2D) g;

		int x = WindowManager.getWindowManager().getX();
		int y = WindowManager.getWindowManager().getY();
		int width = WindowManager.getWindowManager().getWidth();
		int height = WindowManager.getWindowManager().getHeight();

		BufferedImage bim = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D mf = bim.createGraphics();

		RenderingHints qualityHints = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		qualityHints.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		mf.setRenderingHints(qualityHints);
		mf.setClip(new RoundRectangle2D.Double(0, 0, width, height, 10, 10));
		mf.drawImage(WindowManager.getWindowManager().getBlur(), 0, 0, width,
				height, x, y, x + width, y + height, null);
		mf.setColor(new Color(0.9f, 0.9f, 0.9f, 0.9f));
		mf.fillRect(0, 0, width, height);
		mf.drawImage(Images.SEARCH, 5, 5, 40, 40, null);
		mf.dispose();

		BufferedImage shadow = Shadow.getShadow(bim, false);
		g2.drawImage(shadow , 0,0, shadow.getWidth() + 30, shadow.getHeight() + 65, null);
		g2.drawImage(bim, 30, 20, width, height, null);
		g2.setRenderingHints(qualityHints);
		super.paintComponent(g);

	}
}