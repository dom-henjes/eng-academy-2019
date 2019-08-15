package model;

public class Employee {
	
	private String name;
	private String address;
	private String email;
	private String NI;
	private String bankAccount;
	private String sortcode;
	private float startingSalary;
	private int employeeNUmber;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNI() {
		return NI;
	}

	public void setNI(String nI) {
		NI = nI;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getSortcode() {
		return sortcode;
	}

	public void setSortcode(String sortcode) {
		this.sortcode = sortcode;
	}

	public float getStartingSalary() {
		return startingSalary;
	}

	public void setStartingSalary(float startingSalary) {
		this.startingSalary = startingSalary;
	}

	public int getEmployeeNUmber() {
		return employeeNUmber;
	}

	public void setEmployeeNUmber(int employeeNUmber) {
		this.employeeNUmber = employeeNUmber;
	}

}
