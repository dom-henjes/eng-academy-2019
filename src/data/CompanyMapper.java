package data;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import model.Employee;
import model.Department;
import model.Employee_Department;

public interface CompanyMapper {

	@SqlQuery("SELECT Name FROM Employee WHERE Name = ?")
	Employee getEmployee(String codename);
	
	@SqlQuery("SELECT Employee.employeeNumber, Employee.Name FROM Employee JOIN Department ON Employee.DepartmentID = Department.DepartmentID WHERE Department.Name = ?")
	@RegisterBeanMapper(Employee.class)
	List<Employee> getEmployeeByDepartment(String Department);
	
	@SqlUpdate("INSERT INTO Employee (Name, Address, Email, NI, accountNumber, sortCode, startingSalary, DepartmentID) " +
	"VALUES (?, ?, ?, ?, ?, ?, ?, ?)")
	@RegisterBeanMapper(Employee.class)
	int insertEmployee(String name, String address, String email, String NI, String bankAccount, String sortCode, float startingSalary, int DepartmentID);
	
	@SqlQuery("SELECT Department.Name AS Department_Name, Employee.Name AS Employee_Name FROM Employee JOIN Department ON Employee.DepartmentID = Department.DepartmentID ORDER BY Department.Name")
	@RegisterBeanMapper(Employee_Department.class)
	List<Employee_Department> getEmployeesForDepartments();
	
	@SqlQuery("SELECT DepartmentID, Name FROM Department;")
	@RegisterBeanMapper(Department.class)
	List<Department> getDepartments();
		
	@SqlUpdate("INSERT INTO SalesEmployee(commision_rate, total_sales, employeeNumber) " +
	"VALUES (?, ?, ?)")
	@RegisterBeanMapper(Employee.class)
	int insertSalesEmployee(double commision_rate,double total_sales, int employeeNumber);
			
	
	
}
