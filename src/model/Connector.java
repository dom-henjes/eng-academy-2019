package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class Connector {
	private static Jdbi conn;
	
	public Connector() {
		super();
		// expand here
	}
	
	private Jdbi getConnector() {
		if (conn == null) {
			try {
				FileInputStream propsStream = new FileInputStream("employeesdb.properties");
				
				Properties props = new Properties();
				props.load(propsStream);

				String user = props.getProperty("user");
				String password = props.getProperty("password");
				String host = props.getProperty("host");
				
				if (user == null || password == null || host == null) {
					throw new IOException();
				}
				
				Jdbi jdbi = Jdbi.create("jdbc:mysql://localhost/world", "worlduser", "worldPwd!");
				jdbi.installPlugin(new SqlObjectPlugin());
				conn = jdbi;
			} catch (FileNotFoundException e) {
				System.err.println("Failed to find config file for DB connection.");
			} catch (IOException e) {
				System.err.println("Config file for DB connection could not be loaded properly.");
			}
			
		}
		return conn;
	}
}
