package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/cashflow";
    private static final String USER = "postgres";
    private static final String PSWORD = "2512";

    private static Connection connection;

    private ConnectionFactory() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USER, PSWORD);
        }
        return connection;
    }

}
