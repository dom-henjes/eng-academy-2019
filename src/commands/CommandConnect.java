package commands;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import model.Connector;

public class CommandConnect implements Command {

	@Override
	public String handle() {
		Jdbi jdbi = Connector.getConnector();
		jdbi.installPlugin(new SqlObjectPlugin());
		
		//use mapper
		
		
		return "blank for now";
	}

	@Override
	public String commandName() {
		return "connect";
	}
	
	

}
