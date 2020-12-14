package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.utils.Category;
import model.utils.TypeCategory;

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

    public static List<Category> list() {
        List<Category> categories = new ArrayList<>();

        final String SELECT = "SELECT * FROM category ORDER BY id";

        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery(SELECT);
            while (result.next()) {
                Category category = new Category();
                category.setId(result.getInt("id"));
                category.setName(result.getString("name"));
                category.setType(result.getString("type"));
                categories.add(category);
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

        return categories;
    }

    public static List<Category> list(TypeCategory type) {
        List<Category> categories = new ArrayList<>();

        final String SELECT = "SELECT * FROM category WHERE type = '" + type.getType() + "' ORDER BY id";

        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery(SELECT);
            while (result.next()) {
                Category category = new Category();
                category.setId(result.getInt("id"));
                category.setName(result.getString("name"));
                category.setType(result.getString("type"));

                categories.add(category);
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

        return categories;
    }

    public static boolean update(Category category) {
        final String UPDATE = "UPDATE category SET name = ?, type = ? WHERE id = ? ";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, category.getName());
            statement.setString(2, category.getType().getType());
            statement.setInt(3, category.getId());
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

	public static Category getCategoryById(int id) {
		Category category = new Category();

        final String SELECT = "SELECT c.name, c.type FROM category c INNER JOIN financial f ON c.id = f.category WHERE c.id = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SELECT);
            result = statement.executeQuery();

            while (result.next()) {
                category.setId(id);
                category.setName(result.getString("name"));
                category.setType(result.getString("type"));
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

        return category;
	}
}
