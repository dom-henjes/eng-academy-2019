package commands;

import java.util.List;
import java.util.Scanner;

import org.jdbi.v3.core.Jdbi;

import data.CompanyMapper;
import model.Connector;
import model.Department;
import model.Employee;
import model.SalesEmployee;

public class CommandInsertSalesEmployee implements Command{

	@Override
	public String handle() {
		// TODO Auto-generated method stub
		
		Jdbi jdbi = Connector.getConnector();	
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			SalesEmployee sales_emps = new SalesEmployee();
			/*
			System.out.println("Enter sales employee  name ");
			String name = scanner.nextLine();
			sales_emps.setName(name);
			
			System.out.println("Enter sales employee  address ");
		    String address = scanner.nextLine();
		    sales_emps.setAddress(address);
		    
		    System.out.println("Enter sales employee  email ");
		    String email = scanner.nextLine();
		    sales_emps.setEmail(email);
		    
		    System.out.println("Enter employee  ni ");
		    String ni = scanner.nextLine();
		    sales_emps.setNI(ni);
		    
		    System.out.println("Enter sales employee  accountNr ");
		    String accountNr = scanner.nextLine();
		    sales_emps.setBankAccount(accountNr);
		    
		    System.out.println("Enter sales employee  sortcode ");
		    String sortCode = scanner.nextLine();
		    sales_emps.setSortcode(sortCode);
		    
		    System.out.println("Enter sales employee  starting salary ");
		    String startingSalary = scanner.nextLine();
		    sales_emps.setStartingSalary(Float.parseFloat(startingSalary)); */
			
		    System.out.println("Enter sales employee id ");
		    String se_id = scanner.nextLine();
		    sales_emps.setEmployeeNumber(Integer.parseInt(se_id)); 
		    
		    System.out.println("Enter commision rate of this employee");
		    String se_commisionRate = scanner.nextLine();
		    sales_emps.setCommision_rate(Double.parseDouble(se_commisionRate)); 
		    
		    System.out.println("Enter total sales of this employee ");
		    String se_totalSales = scanner.nextLine();
		    sales_emps.setTotal_sales(Double.parseDouble(se_totalSales)); 

		    int res = jdbi.withHandle(handle -> {
		    	CompanyMapper companyMapper = handle.attach(CompanyMapper.class);
		    	
		    	return companyMapper.insertSalesEmployee(sales_emps.getCommision_rate(),sales_emps.getTotal_sales(),sales_emps.getEmployeeNumber());
		    });
		    
		    System.out.println(res);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String commandName() {
		// TODO Auto-generated method stub
		return "insertSalesEmployee";
	}

}
