package commands;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import data.CompanyMapper;
import model.Connector;
import model.Employee;
import model.Department;

public class CommandInsertEmployee implements Command {

	@Override
	public String handle() {
		// TODO Auto-generated method stub
		
		//Entering details
		//
		Jdbi jdbi = Connector.getConnector();
	
		
		
		Scanner scanner = new Scanner(System.in);

		try {

		    Employee emp = new Employee();
		    
		    boolean nameComplete = false;
		    while (!nameComplete) {
			    System.out.println("Enter employee  name ");
			    String name = scanner.nextLine();
			    emp.setName(name);
			    nameComplete = true;
		    }
		    
		    boolean addressComplete = false;
		    while(!addressComplete) {
			    System.out.println("Enter employee  address ");
			    String address = scanner.nextLine();
			    emp.setAddress(address);
			    addressComplete = true;
		    }
		    
		    boolean emailComplete = false;
		    while (!emailComplete) {
			    try {
		    	System.out.println("Enter employee  email ");
			    String email = scanner.nextLine();
			    emp.setEmail(email);
			    emailComplete = true;
			    } catch(Exception e) {
			    	System.out.println(e.getMessage());
			    }
		    }
		    
		    
		    boolean niComplete = false;
		    while (!niComplete) {
			    try {
			    	System.out.println("Enter employee  ni ");
				    String ni = scanner.nextLine();
				    emp.setNI(ni);
				    niComplete = true;
			    } catch(Exception e) {
			    	System.out.println(e.getMessage());
			    }
		    }
		    
		    boolean accNoComplete = false;
		    while (!accNoComplete) {
		    	try {
				    System.out.println("Enter employee  accountNumber ");
				    String accountNr = scanner.nextLine();
				    emp.setBankAccount(accountNr);
				    accNoComplete = true;
			    } catch(Exception e) {
			    	System.out.println(e.getMessage());
			    }
		    }
		    
		    boolean sortcodeComplete = false;
		    while (!sortcodeComplete) {
		    	try {
				    System.out.println("Enter employee  sortcode ");
				    String sortCode = scanner.nextLine();
				    emp.setSortcode(sortCode);
				    sortcodeComplete = true;
			    } catch(Exception e) {
			    	System.out.println(e.getMessage());
			    }
		    }

		    boolean salaryComplete = false;
		    if (!salaryComplete) {
		    	try {
				    System.out.println("Enter employee  starting salary ");
				    String startingSalary = scanner.nextLine();
				    emp.setStartingSalary(Float.valueOf(startingSalary));
				    salaryComplete = true;
			    } catch(Exception e) {
			    	System.out.println(e.getMessage());
			    }
		    }

		    
		    List<Department> depList = jdbi.withHandle(handle -> {
		    	CompanyMapper companyMapper = handle.attach(CompanyMapper.class);
		    	
		    	return companyMapper.getDepartments();
		    });
		    
		    boolean departmentComplete = false;
		    while (!departmentComplete) {
		    	try {
				    System.out.println("Enter employee starting department from list: ");
				    String deps = "";
				    for (Department d: depList) {
				    	deps = deps + d.getName() + ", " ;
				    }
				    System.out.println(deps);
				    String startingDepartment = scanner.nextLine();
				    emp.setDepartment(startingDepartment, depList);
				    departmentComplete = true;
			    } catch(Exception e) {
			    	System.out.println(e.getMessage());
			    }
		    }
		    
		    
		    int success = jdbi.withHandle(handle -> {
		    	CompanyMapper companyMapper = handle.attach(CompanyMapper.class);
		    	
		    	return companyMapper.insertEmployee(emp.getName(), emp.getAddress(), emp.getEmail(), emp.getNI(),
		    			emp.getBankAccount(), emp.getSortcode(), emp.getStartingSalary(), emp.getDepartmentID());
		    	
		    });
		    
		    System.out.println("Success: " + success);
		
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Starting salary must be a numerical value.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Now returning to beginning prompt.");
		}
		return "";
	}

	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "insertEmployee";
	}

}
