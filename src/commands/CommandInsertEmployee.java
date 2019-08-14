package commands;

import java.util.Scanner;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import data.CompanyMapper;
import model.Connector;
import model.Employee;

public class CommandInsertEmployee implements Command {

	@Override
	public String handle() {
		// TODO Auto-generated method stub
		
		//Entering details
		//
		Jdbi jdbi = Connector.getConnector();
	
		
		
		Scanner scanner = new Scanner(System.in);

		try {
	    System.out.println("Enter employee  name ");
	    
	    String name = scanner.nextLine();
	    
	    System.out.println("Enter employee  address ");
	    
	    String address = scanner.nextLine();
	    
	    System.out.println("Enter employee  email ");
	    
	    String email = scanner.nextLine();
	    
	    System.out.println("Enter employee  ni ");
	    
	    String ni = scanner.nextLine();
	    
	    System.out.println("Enter employee  accountNr ");
	    
	    String accountNr = scanner.nextLine();
	    
	    System.out.println("Enter employee  sortcode ");
	    
	    String sortCode = scanner.nextLine();
	    
	    System.out.println("Enter employee  starting salary ");
	    
	    String startingSalary = scanner.nextLine();
	    
	    
	    Employee emp = new Employee();
	    emp.setName(name);
	    emp.setAddress(address);
	    emp.setEmail(email);
	    emp.setNI(ni);
	    emp.setBankAccount(accountNr);
	    emp.setSortcode(sortCode);
	    emp.setStartingSalary(Float.parseFloat(startingSalary));
	    
	    jdbi.withHandle(handle -> {
	    	CompanyMapper companyMapper = handle.attach(CompanyMapper.class);
	    	
	    	companyMapper.insertEmployee(emp);
	    });
	    
		
		}
		catch(Exception e) {
			System.out.println("Error");
		}
		return "";
	}

	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "insertEmployee";
	}

}
