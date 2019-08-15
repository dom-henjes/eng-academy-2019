package commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jdbi.v3.core.Jdbi;

import data.CompanyMapper;
import model.Connector;
import model.Department;
import model.Employee;

public class CommandEmployeeDepartment implements Command {

	@Override
	public String handle() {

	    System.out.print("Enter the department from list: ");
	    
		Scanner scanner = new Scanner(System.in);
		Jdbi jdbi = Connector.getConnector();
		List<Department> depList = jdbi.withHandle(handle -> {
	    	CompanyMapper companyMapper = handle.attach(CompanyMapper.class);
	    	
	    	return companyMapper.getDepartments();
	    });
	    String deps = "";
	    for (Department d: depList) {
	    	deps = deps + d.getName() + ", " ;
	    }
	    System.out.println(deps);
		

	    String input = scanner.nextLine();
	    boolean flag = false;
	    for (Department d: depList) {
	    	if (d.getName().equals(input)) {
	    		flag = true; // found name, name is valid
	    	}
	    }
	    
	    if (!flag) {
	    	System.out.println("Could not find department. Please check your spelling");
	    	return "";
	    }
	    
	    try {
		    List<Employee> employees = jdbi.withHandle(handle -> {
				CompanyMapper companyMapper = handle.attach(CompanyMapper.class);
				
				return companyMapper.getEmployeeByDepartment(input);
			});
		    
		    if (employees.size() == 0) {
		    	System.out.println("No employees in department.");
		    }
		    for (Employee employee : employees) {
		    	System.out.println("Employee Name: " + employee.getName() );
//		    	System.out.println("Employee Employee Number: " + employee.getEmployeeNumber());
		    	System.out.println("_____________");
		    }
		    
		    
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    
	    
	    return "";
	}

	@Override
	public String commandName() {
		return "employeeDepartment";
	}

}
