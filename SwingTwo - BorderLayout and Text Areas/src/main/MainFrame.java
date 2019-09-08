package main;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	// since this MainFrame Creating ALL The Frames
	// this class must be treated as Controller.

	private static final long serialVersionUID = 1L;

	private TextPanel textPanel;
	private CustomToolbar toolbar;
	private CustomFormPanel formPanel;

	public MainFrame() {
		super("Underground Marketplace");

		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		toolbar = new CustomToolbar();
		formPanel = new CustomFormPanel();

		add(toolbar, BorderLayout.NORTH); // top
		add(textPanel, BorderLayout.CENTER);
		add(formPanel, BorderLayout.WEST);

		toolbar.setTextChangeListener(new StringChangeListener() {
			public void textReciever(String text) {
				textPanel.appendText(text);
			}
		});

		formPanel.setFormListener(new FormListener() {
			@Override
			public void formEventOccurred(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				int ageCat = e.getAgeCategory();
				String empCat = e.getEmpCat();

				textPanel.appendText(name + ": " + occupation + ": " + ageCat + ": " + empCat + "\n");
			}
		});

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
