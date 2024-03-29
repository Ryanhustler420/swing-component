package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.Controller;

public class MainFrame extends JFrame {

	// since this MainFrame Creating ALL The Frames
	// this class must be treated as Controller.

	private static final long serialVersionUID = 1L;

	private TextPanel textPanel;
	private CustomToolbar toolbar;
	private CustomFormPanel formPanel;
	private JFileChooser fileChooser;
	private Controller controller;
	private CustomTablePanel customTablePanel;

	public MainFrame() {
		super("Underground Marketplace");

		controller = new Controller();

		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		toolbar = new CustomToolbar();
		formPanel = new CustomFormPanel();
		customTablePanel = new CustomTablePanel();
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFileFilter());

		customTablePanel.setData(controller.getPeoples());

		add(toolbar, BorderLayout.NORTH); // top
		add(customTablePanel, BorderLayout.CENTER);
		add(formPanel, BorderLayout.WEST);

		setJMenuBar(createMenuBar());

		toolbar.setTextChangeListener(new IStringChangeListener() {
			public void textReciever(String text) {
				textPanel.appendText(text);
			}
		});

		formPanel.setFormListener(new IFormListener() {
			@Override
			public void formEventOccurred(FormEvent e) {
				controller.addPerson(e);
				customTablePanel.refresh();
			}
		});

		setMinimumSize(new Dimension(500, 400));
		setSize(900, 700);
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

		importDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}
			}
		});

		exportDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}
			}
		});

		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {

				int action = JOptionPane.showConfirmDialog(MainFrame.this,
						"Do you really want to exit the application?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}

				return;
			}
		});

		return menuBar;
	}
}
