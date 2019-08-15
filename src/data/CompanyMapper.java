package data;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import model.Employee;

public interface CompanyMapper {

	@SqlQuery("SELECT Name FROM Employee WHERE Name = ?")
	Employee getEmployee(String codename);
	
	@SqlQuery("SELECT Employee.employeeNumber, Employee.Name FROM Employee JOIN Department ON Employee.DepartmentID = Department.DepartmentID WHERE Department.Name = ?")
	@RegisterBeanMapper(Employee.class)
	List<Employee> getEmployeeByDepartment(String Department);
	
	@SqlUpdate("INSERT INTO Employee (Name, Address, Email, NI, accountNumber, sortCode, startingSalary) " +
	"VALUES (?, ?, ?, ?, ?, ?, ?)")
	@RegisterBeanMapper(Employee.class)
	int insertEmployee(String name, String address, String email, String NI, String bankAccount, String sortCode, float startingSalary);		 
}
