package oefening2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
	private static DatabaseSingleton ref;

	private Connection connection;

	private DatabaseSingleton() {
	}

	public static DatabaseSingleton getDatabaseSingleton() {
		if (ref == null)
			ref = new DatabaseSingleton();
		return ref;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();

	}

	public Connection getConnection(boolean autoCommit) throws SQLException {
		if (connection == null || connection.isClosed()) {

			try {
				connection = DriverManager.getConnection(
						"jdbc:mysql://dt5.ehb.be/"+DatabaseProperties.USERNAME,
						DatabaseProperties.USERNAME,
						DatabaseProperties.PASSWORD);

			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
				throw ex;
			}
		}
		return connection;
	}

}
