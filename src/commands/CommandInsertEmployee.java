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
		    System.out.println("Enter employee  name ");
		    String name = scanner.nextLine();
		    emp.setName(name);
		    
		    System.out.println("Enter employee  address ");
		    String address = scanner.nextLine();
		    emp.setAddress(address);
		    
		    System.out.println("Enter employee  email ");
		    String email = scanner.nextLine();
		    emp.setEmail(email);
		    
		    System.out.println("Enter employee  ni ");
		    String ni = scanner.nextLine();
		    emp.setNI(ni);
		    
		    System.out.println("Enter employee  accountNr ");
		    String accountNr = scanner.nextLine();
		    emp.setBankAccount(accountNr);
		    
		    System.out.println("Enter employee  sortcode ");
		    String sortCode = scanner.nextLine();
		    emp.setSortcode(sortCode);

		    System.out.println("Enter employee  starting salary ");
		    String startingSalary = scanner.nextLine();
		    emp.setStartingSalary(Float.parseFloat(startingSalary));

		    List<Department> depList = jdbi.withHandle(handle -> {
		    	CompanyMapper companyMapper = handle.attach(CompanyMapper.class);
		    	
		    	return companyMapper.getDepartments();
		    });
		    System.out.println("Enter employee starting department from list: ");
		    String deps = "";
		    for (Department d: depList) {
		    	deps = deps + d.getName() + ", " ;
		    }
		    System.out.println(deps);
		    String startingDepartment = scanner.nextLine();
		    emp.setDepartment(startingDepartment, depList);
		    
		    
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
