package gui;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// TODO: Create Strategy Pattern To Change Layout At Runtime.
				new MainFrame();
			}
		});

	}

}
