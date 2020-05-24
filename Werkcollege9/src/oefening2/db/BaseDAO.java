package oefening2.db;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class BaseDAO {
	private Connection connection;

	protected Connection getConnection() throws SQLException {
		if(connection == null || connection.isClosed())
			connection = DatabaseSingleton.getDatabaseSingleton().getConnection(true);
		return connection;
	}
	

	protected void setConnection(Connection connection) {
		this.connection = connection;
	}

}
