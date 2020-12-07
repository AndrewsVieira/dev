package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import connection.ConnectionFactory;
import model.FinancialRecord;

public class RevenueDB {
    public static void insert(FinancialRecord revenue) {

        final String INSERT_REVENUE = "INSERT INTO revenue (id_financial, client) VALUES (?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {

            FinancialDB.insert(revenue);

            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(INSERT_REVENUE);
            statement.setInt(1, revenue.getId());
            statement.setString(2, revenue.getClientOrProvider().toString());
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

    public static void update(FinancialRecord revenue) {

        final String UPDATE_PAYAMENT = "UPDATE revenue SET client = ? WHERE id_financial = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            FinancialDB.update(revenue);

            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(UPDATE_PAYAMENT);
            statement.setString(1, revenue.getClientOrProvider().toString());
            statement.setInt(2, revenue.getId());
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

    public static void delete(FinancialRecord revenue) {

        final String DELETE_PAYAMENT = "DELETE FROM revenue WHERE id_financial = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(DELETE_PAYAMENT);
            statement.setInt(1, revenue.getId());
            statement.execute();

            FinancialDB.delete(revenue);

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
        final String REVENUE = "revenue";
        final String CLIENT = "client";
        return FinancialDB.list(CLIENT, REVENUE);
    }
}
