package main;

import java.util.EventObject;

public class FormEvent extends EventObject {

	private static final long serialVersionUID = -4299487318290485714L;

	private String name;
	private String occupation;
	private int ageCategory;
	private String empCat;
	private boolean indianCitizen;

	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String name, String occupation, int ageCat, String empCat,
			boolean isIndianCitizen) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCat;
		this.empCat = empCat;
		this.indianCitizen = isIndianCitizen;
	}

	public boolean isIndianCitizen() {
		return indianCitizen;
	}

	public String getEmpCat() {
		return empCat;
	}

	public int getAgeCategory() {
		return ageCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
