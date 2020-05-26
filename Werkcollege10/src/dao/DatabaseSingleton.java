package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {

    private static DatabaseSingleton instance;
    private Connection conn;

    private DatabaseSingleton()
    {
    }

    public static DatabaseSingleton getInstance() {
        if(instance== null)
            instance = new DatabaseSingleton();
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if(conn==null || conn.isClosed())
        {
            conn = DriverManager.getConnection("jdbc:mysql://dt5.ehb.be/1920RUBEN_DJ" , "1920RUBEN_DJ", "DCX5hAM");
        }
        return conn;
    }
}
