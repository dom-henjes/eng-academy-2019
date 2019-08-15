package model;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class Connector {
	private static Jdbi conn;
	
	public Connector() {
		super();
		// expand here
	}
	
	private Jdbi getConnector() {
		if (conn != null) {
			Jdbi jdbi = Jdbi.create("jdbc:mysql://localhost/world", "worlduser", "worldPwd!");
			jdbi.installPlugin(new SqlObjectPlugin());
			conn = jdbi;
		}
		return conn;
	}
}
