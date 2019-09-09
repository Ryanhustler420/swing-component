package controller;

import java.util.ArrayList;

import gui.FormEvent;
import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;

public class Controller {
	Database db = new Database();

	public ArrayList<Person> getPeoples() {
		return db.getPeoples();
	}

	public void addPerson(FormEvent ev) {
		String name = ev.getName();
		String occupation = ev.getOccupation();
		int ageCatId = ev.getAgeCategory();
		String empCat = ev.getEmpCat();
		boolean isIndian = ev.isIndianCitizen();
		String taxId = ev.getTaxId();
		String genderStr = ev.getGender();

		AgeCategory ageCategory = AgeCategory.CHILD;

		switch (ageCatId) {
		case 1:
			ageCategory = AgeCategory.ADULT;
			break;
		case 2:
			ageCategory = AgeCategory.SENIOR;
			break;
		}

		EmploymentCategory employmentCategory = EmploymentCategory.UNEMPLOYED;

		if (empCat.equals("employed")) {
			employmentCategory = EmploymentCategory.EMPLOYED;
		} else if (empCat.equals("self-employed")) {
			employmentCategory = EmploymentCategory.SELFEMPLOYED;
		}

		Gender gender = Gender.MALE;

		if (genderStr.equals("Female")) {
			gender = Gender.FEMALE;
		}

		Person person = new Person(name, occupation, taxId, isIndian, employmentCategory, gender, ageCategory);

		db.addPerson(person);
	}
}
