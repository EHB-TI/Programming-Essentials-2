package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {
    private Connection conn;

    public BaseDAO()
    {
    }

    public Connection getConn() throws SQLException {
        if(conn == null || conn.isClosed()) {
            conn = DatabaseSingleton.getInstance().getConnection();
        }
        return conn;
    }
}
