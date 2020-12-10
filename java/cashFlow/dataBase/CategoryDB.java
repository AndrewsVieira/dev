package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;
import model.utils.Category;

public class CategoryDB {
    public static boolean insert(Category category) {
        final String INSERT = "INSERT INTO category (name, type) VALUES (?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, category.getName());
            statement.setString(2, category.getType().getType());
            result = statement.getGeneratedKeys();
            while (result.next()) {
                category.setId(result.getInt("id"));
            }
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
                return false;
            }
        }
        return true;
    }

	public static boolean delete(Category category) {
        final String DELETE = "DELETE FROM category WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, category.getId());
            statement.execute();
           
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;

	}
}
