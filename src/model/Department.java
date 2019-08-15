package model;

public class Department {
	private int departmentID;
	private String departmentName;

	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public void setID(int ID) {
		departmentID = ID;
	}
	
	public int getID() {
		return departmentID;
	}
	
	public void setName(String name) {
		departmentName = name;
	}
	
	public String getName() {
		return departmentName;
	}

}
