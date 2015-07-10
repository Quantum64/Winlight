package co.q64.winlight.input;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import co.q64.winlight.gui.WindowManager;

public class FocusEvent extends WindowAdapter  {
	public void windowDeactivated(WindowEvent e) {
        WindowManager.getWindowManager().hideWindow();
    }
}
