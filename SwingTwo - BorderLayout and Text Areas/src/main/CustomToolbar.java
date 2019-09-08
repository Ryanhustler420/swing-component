package main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CustomToolbar extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton helloBtn;
	private JButton goodbayBtn;

	private TextPanel textPanel;

	public CustomToolbar() {

		helloBtn = new JButton("Hello");
		goodbayBtn = new JButton("Goodbay");

		helloBtn.addActionListener(this);
		goodbayBtn.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(helloBtn);
		add(goodbayBtn);

	}

	public void setTextPanel(TextPanel textPanel) {
		this.textPanel = textPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == helloBtn) {
			// System.out.println("Hello");
			textPanel.appendText("Hello \n");
		} else {
			// System.out.println("Goodbay");
			textPanel.appendText("Goodbye \n");
		}
	}
}
