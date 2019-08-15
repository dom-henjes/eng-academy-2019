package commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jdbi.v3.core.Jdbi;

import data.CompanyMapper;
import model.Connector;
import model.Employee;
import model.Employee_Department;

public class CommandDisplayDepartments implements Command{

	@Override
	public String handle() {
		
		Scanner scanner = new Scanner(System.in);
		Jdbi jdbi = Connector.getConnector();
		
		List<Employee_Department> employeeDepartments = jdbi.withHandle(handle -> {
			CompanyMapper companyMapper = handle.attach(CompanyMapper.class);
			
			return companyMapper.getEmployeesForDepartments();
		});
		
		for (Employee_Department employeeDepartment : employeeDepartments) {
	    	System.out.println("Employee Department: " + employeeDepartment.getDepartment_name() );
	    	System.out.println("Employee Name: " + employeeDepartment.getEmployee_name());
//	    	System.out.println("Employee Employee Number: " + employee.getEmployeeNumber());
	    	System.out.println("_____________");
	    }
		return "";
		
	}

	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "displayDepartments";
	}
	
	
}
