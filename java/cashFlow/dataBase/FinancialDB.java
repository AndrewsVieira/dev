package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.FinancialRecord;
import model.PayamentRecord;
import model.RevenueRecord;
import model.utils.Client;
import model.utils.Provider;

public class FinancialDB {
    public static void insert(FinancialRecord record) {

        final String INSERT_FINANCIAL = "INSERT INTO financial (date, description, value, category) VALUES (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(INSERT_FINANCIAL, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, record.getDate());
            statement.setString(2, record.getDescription());
            statement.setDouble(3, record.getValue());
            statement.setInt(4, record.getCategory().getId());
            statement.execute();

            result = statement.getGeneratedKeys();
            while (result.next()) {
                record.setId(result.getInt("id"));
            }
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

    public static void update(FinancialRecord record) {

        final String UPDATE_FINANCIAL = "UPDATE financial SET date = ?, description = ?, value = ? WHERE id = ? ";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(UPDATE_FINANCIAL);
            statement.setDate(1, record.getDate());
            statement.setString(2, record.getDescription());
            statement.setDouble(3, record.getValue());
            statement.setInt(4, record.getId());
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

    public static void delete(FinancialRecord record) {
        final String DELETE_FINANCIAL = "DELETE FROM financial WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(DELETE_FINANCIAL);
            statement.setInt(1, record.getId());
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

    public static List<FinancialRecord> list(String ProviderOrClient, String recordType) {
        List<FinancialRecord> records = new ArrayList<>();

        final String SELECT_FINANCIAL = "SELECT f.id, f.date, f.value, p." + ProviderOrClient + ", f.description FROM financial f INNER JOIN "
                + recordType + " p ON f.id = p.id_financial ORDER BY date";

        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery(SELECT_FINANCIAL);
            while (result.next()) {

                if (recordType.equals("payament")) {
                    PayamentRecord record = new PayamentRecord();
                    record.setId(result.getInt("id"));
                    record.setDate(result.getDate("date"));
                    record.setValue(result.getDouble("value"));
                    record.setProvider(new Provider(result.getString(ProviderOrClient)));
                    record.setCategory(CategoryDB.getCategoryById(record.getId()));
                    record.setDescription(result.getString("description"));
                    records.add(record);
                } else {
                    RevenueRecord record = new RevenueRecord();
                    record.setId(result.getInt("id"));
                    record.setDate(result.getDate("date"));
                    record.setValue(result.getDouble("value"));
                    record.setClient(new Client(result.getString(ProviderOrClient)));
                    record.setCategory(CategoryDB.getCategoryById(record.getId()));
                    record.setDescription(result.getString("description"));
                    records.add(record);
                }

            }

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

        return records;
    }

} // fim da classe FinancialDB
