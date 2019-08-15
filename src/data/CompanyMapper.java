package data;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import model.Employee;

public interface CompanyMapper {

	@SqlQuery("SELECT Name FROM Employee WHERE Name = ?")
	@RegisterBeanMapper(Employee.class)
	Employee getEmployee(String codename);
	
	@SqlQuery("SELECT employeeNumber FROM Employee WHERE Department = ?")
	@RegisterBeanMapper(Employee.class)
	List<Employee> getEmployeeByDepartment(String Department);
	
	@SqlUpdate("INSERT INTO Employee (Name, Address, Email, NI, accountNumber, sortCode, startingSalary)" +
	"VALUES (?, ?, ?, ?, ?, ?, ?)")
	@RegisterBeanMapper(Employee.class)
	void insertEmployee(String name, String address, String email, String NI, String bankAccount, 
			float startingSalary);
	
		 
}
