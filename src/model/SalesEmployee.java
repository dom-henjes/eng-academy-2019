package model;

public class SalesEmployee extends Employee {
	
	private int employeeNumber;
	private double commision_rate;
	private double total_sales;
	
	
	public SalesEmployee() {
		super();
	}
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public double getCommision_rate() {
		return commision_rate;
	}
	public void setCommision_rate(double commision_rate) {
		this.commision_rate = commision_rate;
	}
	public double getTotal_sales() {
		return total_sales;
	}
	public void setTotal_sales(double d) {
		this.total_sales = d;
	}
	
	
	
	
	//public SalesEmployee(int salesEmployeesNumber,double commision_rate,float total_sales) {}
	
	

}
