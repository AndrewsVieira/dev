package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// representa um banco de dados para tarefas

public class TaskDB {

    public static boolean insert(Task task) {
        final String query1 = "INSERT INTO task (task, description) VALUES (?, ?)";
        final String query2 = "INSERT INTO task_category (id_tk, id_ct) VALUES (?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, task.getTask());
            statement.setString(2, task.getDescription());
            statement.execute();
            
            resultSet = statement.getGeneratedKeys(); // armazena as chaves geradas (PK)
            while (resultSet.next()) {
                task.setId(resultSet.getInt(1)); // como eu sei que gera apenas uma chave, eu seleciono a primeira
            }

            statement.close();
            
            statement = connection.prepareStatement(query2);
            statement.setInt(1, task.getId());
            for (Category category : task.getCategories()) {
                statement.setInt(2, category.getId());
                statement.addBatch();
            }
            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
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

    public static boolean update(Task task) {
        final String query1 = "UPDATE task SET task = ?, description = ? WHERE id = ?";
        final String query2 = "DELETE FROM task_category WHERE id_tk = ?";
        final String query3 = "INSERT INTO task_category (id_tk, id_ct) VALUES (?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(query1);
            statement.setString(1, task.getTask());
            statement.setString(2, task.getDescription());
            statement.setInt(3, task.getId());
            statement.execute();
            statement.close();

            statement = connection.prepareStatement(query2);
            statement.setInt(1, task.getId());
            statement.execute();
            statement.close();

            statement = connection.prepareStatement(query3);
            statement.setInt(1, task.getId());
            for (Category category : task.getCategories()) {
                statement.setInt(2, category.getId());
                statement.addBatch();
            }
            statement.executeBatch();
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

    public static boolean delete(Task task) {
        final String query1 = "DELETE FROM task WHERE id = ?";
        final String query2 = "DELETE FROM task_category WHERE id_tk = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(query2);
            statement.setInt(1, task.getId());
            statement.execute();
            statement.close();

            statement = connection.prepareStatement(query1);
            statement.setInt(1, task.getId());
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

    public static List<Task> list() {
        List<Task> tasks = new ArrayList<>();

        final String query = "SELECT * FROM task ORDER BY id";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setTask(resultSet.getString("task"));
                task.setDescription(resultSet.getString("description"));

                List<Category> categories = CategoryDB.listTheSelecteds(task.getId());
                task.setCategories(categories);

                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tasks;
    }
} // fim da classe TaskDB
