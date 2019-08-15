package data;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import model.Employee;

public interface CompanyMapper {

	@SqlQuery("SELECT Name from Employee where Name = ?")
	@RegisterBeanMapper(Employee.class)
	Employee getEmployee(String codename);
	
	@SqlUpdate("INSERT INTO Employee (Name, Address, Email, NI, accountNumber, sortCode, startingSalary)" +
	"values (?, ?, ?, ?, ?, ?, ?)")
	@RegisterBeanMapper(Employee.class)
	void insertEmployee(String name, String address, String email, String NI, String bankAccount, 
			float startingSalary);
	
		 
}
