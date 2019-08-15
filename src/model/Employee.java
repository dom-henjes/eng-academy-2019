package model;

import java.io.IOException;
import java.util.List;

public class Employee {
	
	public String name;
	public String address;
	public String email;
	public String NI;
	public String bankAccount;
	public String sortcode;
	public float startingSalary;
	public int employeeNumber;
	public int departmentID;
	
	public Employee(String name, String address, String email, String NI, String bankAccount,
			String sortCode, float startingSalary) throws IOException {
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
	
	public void setName(String name) throws IOException {
		if (name.length() > 0 && name.length() <= 45) {
			this.name = name;
		} else {
			throw new IOException("Name must have length 1-45 characters.");
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) throws IOException {
		if (address.length() > 0 && address.length() <= 150) {
			this.address = address;
		} else {
			throw new IOException("Address must have length 1-150 characters.");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws IOException {
		if (email.length() > 5 && email.length() <= 150) {
			if (email.contains("@")) {
				this.email = email;
			} else {
				throw new IOException("Email must have valid format (see RFC 5322 for details on compliance).");
			}
		} else {
			throw new IOException("Email must have length 6-150.");
		}
	}

	public String getNI() {
		return NI;
	}

	public void setNI(String nI) throws IOException {
		if (nI.length() == 9) {
			if (nI.toUpperCase().matches("^[A-CEGHJ-PR-TW-Z]{1}[A-CEGHJ-NPR-TW-Z]{1}[0-9]{6}[A-D]{0,1}$")) {
				this.NI = nI.toUpperCase();
			} else {
				throw new IOException("That is not a valid national insurance number");
			}
		
		} else {
			throw new IOException("NI must have length 9.");
		}
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) throws IOException {
		if (bankAccount.length() == 8) {
			if (bankAccount.matches("[0-9]*")) {
				this.bankAccount = bankAccount;
			} else {
				throw new IOException("Bank account must consist of only digits");
			}
		} else {
			throw new IOException("Bank account must have length 8.");
		}
	}

	public String getSortcode() {
		return sortcode;
	}

	public void setSortcode(String sortcode) throws IOException {
		if (sortcode.length() == 6) {
			if (sortcode.matches("[0-9]*")) {
				this.sortcode = sortcode;
			} else {
				throw new IOException("Sort code must consist of only digits");
			}
		} else {
			throw new IOException("Sort code must have length 6.");
		}
	}

	public float getStartingSalary() {
		return startingSalary;
	}

	public void setStartingSalary(float startingSalary) throws IOException {
		if (startingSalary <= 0) {
			throw new IOException("Starting salary cannot be zero or negative.");
		}
		this.startingSalary = startingSalary;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	public int getDepartmentID() {
		return departmentID;
	}
	
	public void setDepartment(String department, List<Department> depList) throws IOException {
		boolean flag = false;
		
		for (Department d: depList) {
			if (d.getName().toLowerCase().contentEquals(department)) {
				flag = true;
				departmentID = d.getID();
			}
		}
		if (flag) {
			throw new IOException("Invalid department name");
		}
	}

}
