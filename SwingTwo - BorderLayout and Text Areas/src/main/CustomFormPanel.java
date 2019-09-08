package main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CustomFormPanel extends JPanel {

	private static final long serialVersionUID = -5077238902919016714L;

	private JLabel nameLabel, occupationLabel;
	private JTextField nameField, occupationField;
	private JButton okBtn;
	private int fieldWidthSize = 10;

	public CustomFormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(fieldWidthSize);
		occupationField = new JTextField(fieldWidthSize);

		okBtn = new JButton("OK");

		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));

		// it's so flexible
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		/////////// First row //////////////////

		gc.weightx = 1;
		gc.weighty = 0.1;

		// creating cells. set these first
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		// anchor: without this everything would be in the center
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);

		/////////// Second row //////////////////

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridy = 1;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(occupationLabel, gc);

		gc.gridy = 1;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField, gc);

		/////////// Third row //////////////////

		gc.weightx = 1;
		gc.weighty = 2.0;

		gc.gridy = 2;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);

	}
}
