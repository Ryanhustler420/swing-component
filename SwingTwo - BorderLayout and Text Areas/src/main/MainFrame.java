package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

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

		setJMenuBar(createMenuBar());

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
				boolean isIndian = e.isIndianCitizen();

				textPanel.appendText(name + ": " + occupation + ": " + ageCat + ": " + empCat + ": " + isIndian + "\n");
				System.out.println(e.getGender());
			}
		});

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		// File
		JMenu fileMenu = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");

		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		menuBar.add(fileMenu);

		// Window
		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);

		showMenu.add(showFormItem);
		windowMenu.add(showMenu);

		// adding everything to menuBar
		menuBar.add(windowMenu);

		// checkBox person form action Listener
		showFormItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();
				formPanel.setVisible(menuItem.isSelected());
			}
		});

		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);

		// Setup Accelerator

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		return menuBar;
	}
}
