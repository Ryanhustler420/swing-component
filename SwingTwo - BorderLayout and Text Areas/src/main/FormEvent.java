package main;

import java.util.EventObject;

public class FormEvent extends EventObject {

	private static final long serialVersionUID = -4299487318290485714L;

	private String name;
	private String occupation;
	private int ageCategory;
	private String empCat;
	private boolean indianCitizen;
	private String taxId;
	private String gender;

	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String name, String occupation, int ageCat, String empCat, boolean isIndianCitizen,
			String taxId, String gender) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCat;
		this.empCat = empCat;
		this.indianCitizen = isIndianCitizen;
		this.taxId = taxId;
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public String getTaxId() {
		return taxId;
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
