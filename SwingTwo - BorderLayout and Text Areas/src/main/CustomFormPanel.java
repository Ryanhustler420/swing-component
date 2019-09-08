package main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CustomFormPanel extends JPanel {

	private static final long serialVersionUID = -5077238902919016714L;

	private JLabel nameLabel, occupationLabel;
	private JTextField nameField, occupationField;
	private JButton okBtn;
	private int fieldWidthSize = 10;
	private FormListener formEventEmitter;
	private JList<AgeCategory> ageList;
	private JComboBox<String> employeCombo;
	private JCheckBox citizenCheck;
	private JTextField taxField;
	private JLabel taxLabel;

	public CustomFormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(fieldWidthSize);
		occupationField = new JTextField(fieldWidthSize);
		ageList = new JList<>();
		employeCombo = new JComboBox<>();
		citizenCheck = new JCheckBox();
		taxField = new JTextField(10);
		taxLabel = new JLabel("Tax ID");

		// Setup text ID
		taxLabel.setEnabled(false);
		taxField.setEnabled(false);

		citizenCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isTicked = citizenCheck.isSelected();
				taxLabel.setEnabled(isTicked);
				taxField.setEnabled(isTicked);
			}
		});

		// Setup List box
		DefaultListModel<AgeCategory> ageModel = new DefaultListModel<>();
		ageModel.addElement(new AgeCategory(0, "Under 18"));
		ageModel.addElement(new AgeCategory(1, "18 to 65"));
		ageModel.addElement(new AgeCategory(2, "65 or over"));
		ageList.setModel(ageModel);
		ageList.setPreferredSize(new Dimension(110, 66));
		ageList.setBorder(BorderFactory.createEtchedBorder());

		// Setup Combo box
		DefaultComboBoxModel<String> employeeModel = new DefaultComboBoxModel<>();
		employeeModel.addElement("employed");
		employeeModel.addElement("self-employed");
		employeeModel.addElement("unemployed");
		employeCombo.setModel(employeeModel);
		// employeCombo.setEditable(true);

		ageList.setSelectedIndex(1);
		employeCombo.setSelectedIndex(1);

		okBtn = new JButton("OK");

		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = nameField.getText().trim();
				String occupation = occupationField.getText().trim();
				AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
				String employeeCat = (String) employeCombo.getSelectedItem();
				boolean isIndian = (boolean) citizenCheck.isSelected();

				if (!name.isEmpty() && !occupation.isEmpty() && !employeeCat.isEmpty()) {
					FormEvent ev = new FormEvent(this, name, occupation, ageCat.getId(), employeeCat, isIndian);
					if (formEventEmitter != null) {
						formEventEmitter.formEventOccurred(ev);
					}
				}
			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));

		layoutComponent();

	}

	public void layoutComponent() {
		// it's so flexible
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		/////////// First row //////////////////

		gc.gridy = 0;

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

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(occupationLabel, gc);

		gc.gridy = 1;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField, gc);

		/////////// Next row //////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Age: "), gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(ageList, gc);

		/////////// Next row //////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(4, 0, 0, 5);
		add(new JLabel("Employment: "), gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(employeCombo, gc);

		/////////// Next row //////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(2, 0, 0, 5);
		add(new JLabel("Indian Citizen: "), gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(citizenCheck, gc);

		/////////// Next row //////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(taxLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(taxField, gc);

		/////////// Next row //////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2.0;

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);

	}

	public void setFormListener(FormListener e) {
		this.formEventEmitter = e;
	}
}

class AgeCategory {
	private int id;
	private String text;

	public AgeCategory(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return text;
	}
}
