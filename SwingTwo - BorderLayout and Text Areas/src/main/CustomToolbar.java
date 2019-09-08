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
	private StringChangeListener textListener;

	public CustomToolbar() {

		helloBtn = new JButton("Hello");
		goodbayBtn = new JButton("Goodbay");

		helloBtn.addActionListener(this);
		goodbayBtn.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(helloBtn);
		add(goodbayBtn);

	}

	public void setTextChangeListener(StringChangeListener listener) {
		this.textListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();

		if (clicked == helloBtn) {
			if (textListener != null)
				this.textListener.textReciever("Hello \n");
		} else if (clicked == goodbayBtn) {
			if (textListener != null)
				this.textListener.textReciever("GoodBay \n");
		}

	}

}
