package data;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import model.Employee;

public interface CompanyMapper {

	@SqlQuery("SELECT name from Employee where name = ?")
	@RegisterBeanMapper(Employee.class)
	Employee getEmployee(String codename);
}
