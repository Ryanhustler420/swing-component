package main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class CustomFormPanel extends JPanel {
	
	private static final long serialVersionUID = -5077238902919016714L;

	public CustomFormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
	}
}
