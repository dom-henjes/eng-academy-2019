package model;

public class Employee {
	
	public String name;
	public String address;
	public String email;
	public String NI;
	public String bankAccount;
	public String sortcode;
	public float startingSalary;
	public int employeeNumber;
	
	public Employee(String name, String address, String email, String NI, String bankAccount,
			String sortCode, float startingSalary) {
		this.setName(name);
		this.setAddress(address);
		this.setEmail(email);
		this.setNI(NI);
		this.setBankAccount(bankAccount);
		this.setSortcode(sortCode);
		this.setStartingSalary(startingSalary);
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

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

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

}
