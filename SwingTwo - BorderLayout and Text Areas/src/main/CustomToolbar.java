package main;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CustomToolbar extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton helloBtn;
	private JButton goodbayBtn;

	public CustomToolbar() {

		helloBtn = new JButton("Hello");
		goodbayBtn = new JButton("Goodbay");

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(helloBtn);
		add(goodbayBtn);

	}
}
