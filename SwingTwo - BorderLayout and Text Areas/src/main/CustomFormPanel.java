package main;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CustomFormPanel extends JPanel {

	private static final long serialVersionUID = -5077238902919016714L;

	public CustomFormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));
	}
}
