package main;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private TextPanel textPanel;
	private CustomToolbar toolbar;

	public MainFrame() {
		super("Hello World");

		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		toolbar = new CustomToolbar();

		add(toolbar, BorderLayout.NORTH); // top
		add(textPanel, BorderLayout.CENTER);

		toolbar.setTextChangeListener(new StringChangeListener() {
			public void textReciever(String text) {
				textPanel.appendText(text);
			}
		});

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
