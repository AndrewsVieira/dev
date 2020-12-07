package dataBase;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.FinancialRecord;
import model.PayamentRecord;
import model.utils.Provider;

public class PayamentDB {

    public static void insert(FinancialRecord payament) {

        final String INSERT_FINANCIAL = "INSERT INTO financial (date, description, value) VALUES (?, ?, ?)";
        final String INSERT_PAYAMENT = "INSERT INTO payament (id_financial, provider) VALUES (?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(INSERT_FINANCIAL, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, payament.getDate());
            statement.setString(2, payament.getDescription());
            statement.setDouble(3, payament.getValue());
            statement.execute();

            result = statement.getGeneratedKeys();
            while (result.next()) {
                payament.setId(result.getInt("id"));
            }

            statement.close();

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
        reload();
    }

    public static void update(FinancialRecord payament) {

        final String UPDATE_FINANCIAL = "UPDATE financial SET date = ?, description = ?, value = ? WHERE id = ? ";
        final String UPDATE_PAYAMENT = "UPDATE payament SET provider = ? WHERE id_financial = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(UPDATE_FINANCIAL);
            statement.setDate(1, payament.getDate());
            statement.setString(2, payament.getDescription());
            statement.setDouble(3, payament.getValue());
            statement.setInt(4, payament.getId());
            statement.execute();
            statement.close();

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

        reload();
    }

    public static void delete(FinancialRecord payament) {

        final String DELETE_PAYAMENT = "DELETE FROM payament WHERE id_financial = ?";
        final String DELETE_FINANCIAL = "DELETE FROM financial WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(DELETE_PAYAMENT);
            statement.setInt(1, payament.getId());
            statement.execute();
            statement.close();

            statement = connection.prepareStatement(DELETE_FINANCIAL);
            statement.setInt(1, payament.getId());
            statement.execute();
            statement.close();

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

        reload();
    }

    public static List<FinancialRecord> list() {
        List<FinancialRecord> payaments = new ArrayList<>();

        final String SELECT_FINANCIAL = "SELECT f.id, f.date, f.value, p.provider, f.description FROM financial f INNER JOIN payament p ON f.id = p.id_financial ORDER BY date";

        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery(SELECT_FINANCIAL);
            while (result.next()){
                PayamentRecord pay = new PayamentRecord();
                pay.setId(result.getInt("id"));
                pay.setDate(result.getDate("date"));
                pay.setValue(result.getDouble("value"));
                pay.setProvider(new Provider(result.getString("provider")));
                pay.setDescription(result.getString("description"));
                payaments.add(pay);
            }

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

        return payaments;
    }

    private static void reload() {
        CashFlowDB.setPayaments(list());
    }
}
