package model;

public class Person {
	private static int count = 0;
	private int id;
	private String name;
	private String occupation;
	private String taxId;
	private boolean indianCitizen;
	private EmploymentCategory empCat;
	private Gender gender;
	private AgeCategory ageCategory;

	public Person(String name, String occupation, String taxId, boolean indianCitizen, EmploymentCategory empCat,
			Gender gender, AgeCategory ageCategory) {
		super();
		this.name = name;
		this.occupation = occupation;
		this.taxId = taxId;
		this.indianCitizen = indianCitizen;
		this.empCat = empCat;
		this.gender = gender;
		this.ageCategory = ageCategory;
		this.id = count;
		count++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public boolean isIndianCitizen() {
		return indianCitizen;
	}

	public void setIndianCitizen(boolean indianCitizen) {
		this.indianCitizen = indianCitizen;
	}

	public EmploymentCategory getEmpCat() {
		return empCat;
	}

	public void setEmpCat(EmploymentCategory empCat) {
		this.empCat = empCat;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public AgeCategory getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}

}
