package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import connection.ConnectionFactory;
import model.FinancialRecord;


public class PayamentDB {

    public static void insert(FinancialRecord payament) {

        final String INSERT_PAYAMENT = "INSERT INTO payament (id_financial, provider) VALUES (?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {

            FinancialDB.insert(payament);

            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(INSERT_PAYAMENT);
            statement.setInt(1, payament.getId());
            statement.setString(2, payament.getClientOrProvider().toString());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void update(FinancialRecord payament) {

        final String UPDATE_PAYAMENT = "UPDATE payament SET provider = ? WHERE id_financial = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            FinancialDB.update(payament);

            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(UPDATE_PAYAMENT);
            statement.setString(1, payament.getClientOrProvider().toString());
            statement.setInt(2, payament.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(FinancialRecord payament) {

        final String DELETE_PAYAMENT = "DELETE FROM payament WHERE id_financial = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(DELETE_PAYAMENT);
            statement.setInt(1, payament.getId());
            statement.execute();

            FinancialDB.delete(payament);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<FinancialRecord> list() {
        final String PAYAMENT = "payament";
        final String PROVIDER = "provider";
        return FinancialDB.list(PROVIDER, PAYAMENT);
    }
}
