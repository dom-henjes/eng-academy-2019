package commands;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import data.CompanyMapper;
import model.Connector;
import model.Employee;

public class CommandConnect implements Command {

	@Override
	public String handle() {
		Jdbi jdbi = Connector.getConnector();
		jdbi.installPlugin(new SqlObjectPlugin());
		
		Employee employee = jdbi.withHandle(handle -> {
			CompanyMapper companyMapper = handle.attach(CompanyMapper.class);
			
			return companyMapper.getEmployee("Bruce Wayne");
		});
		
		
		return employee.getName() + ", National insurance: " + employee.getNI();
	}

	@Override
	public String commandName() {
		return "connect";
	}
	
	

}
