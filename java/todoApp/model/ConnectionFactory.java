package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "";
    private static final String USER = "";
    private static final String PSWORD = "";

    private static Connection connection;

    private ConnectionFactory() {
    };

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USER, PSWORD);
        }
        return connection;
    }
}
