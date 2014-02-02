package com.jag;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * @author Parnassian
 * @version 0.1
 * @since 0.1
 * @see jag
 * @category rs3
 */
public class Bootstrap {

	public static void main(String[] args) {
		handleArgs(args);
		setLookAndFeel();
	}

	private static void handleArgs(String[] args) {
		//just an example...
		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			switch (arg) {
			case "-exit":
				System.exit(0);
				break;
			case "-msgbox":
				JOptionPane.showMessageDialog(null, args[++i], "Welcome",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
	}

	private static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
