package co.q64.winlight.input;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import co.q64.winlight.gui.WindowManager;

public class FocusEvent implements WindowFocusListener {
	public void windowLostFocus(WindowEvent e) {
		System.out.println("Lost");
		WindowManager.getWindowManager().hideWindow();
	}

	@Override
	public void windowGainedFocus(WindowEvent arg0) {

	}
}
