package commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jdbi.v3.core.Jdbi;

import data.CompanyMapper;
import model.Connector;
import model.Employee;

public class CommandEmployeeDepartment implements Command {

	@Override
	public String handle() {
		
		Scanner scanner = new Scanner(System.in);
		Jdbi jdbi = Connector.getConnector();

	    System.out.print("Enter the department: ");

	    String input = scanner.nextLine();
	    
	    try {
		    List<Employee> employees = jdbi.withHandle(handle -> {
				CompanyMapper companyMapper = handle.attach(CompanyMapper.class);
				
				return companyMapper.getEmployeeByDepartment(input);
			});
		    
		    for (Employee employee : employees) {
		    	System.out.println("Employee Name: " + employee.getName() );
		    	System.out.println("Employee Name: " + employee.getEmployeeNUmber());
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
