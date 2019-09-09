package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.AgeCategory;
import model.EmploymentCategory;
import model.Gender;
import model.Person;

public class PersonTableModel extends AbstractTableModel {

	/* This class is just wrapper of person Data */
	private ArrayList<Person> db;

	public PersonTableModel() {
	}

	public void setData(ArrayList<Person> db) {
		this.db = db;
	}

	private static final long serialVersionUID = -6508897732445332520L;

	@Override
	public int getColumnCount() {
		return 0;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Person person = db.get(row);
		switch (column) {
		case 0:
			return person.getId();
		case 1:
			return person.getName();
		case 2:
			return person.getOccupation();
		case 3:
			return person.getAgeCategory();
		case 4:
			return person.getEmpCat();
		case 5:
			return person.isIndianCitizen();
		case 6:
			return person.getTaxId();
		}

		return null;
	}
}
