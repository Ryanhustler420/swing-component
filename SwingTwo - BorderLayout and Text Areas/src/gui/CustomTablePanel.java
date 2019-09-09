package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Person;

public class CustomTablePanel extends JTable {

	private static final long serialVersionUID = 1785234132841545262L;

	private JTable table;
	private PersonTableModel tableModel;

	public CustomTablePanel() {
		
        //headers for the table
        String[] columns = new String[] {
            "Id", "Name", "Hourly Rate", "Part Time"
        };
        
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {1, "John", 40.0, false },
            {2, "Rambo", 70.0, false },
            {3, "Zorro", 60.0, true },
        };

		tableModel = new PersonTableModel();
		table = new JTable(data, columns);

		setLayout(new BorderLayout());
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void setData(ArrayList<Person> db) {
		tableModel.setData(db);
	}

	public void refresh() {
		tableModel.fireTableDataChanged();
	}

}
