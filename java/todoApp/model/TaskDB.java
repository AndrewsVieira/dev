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
        final String query = "INSERT INTO task (task, description) VALUES (?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(query);
            statement.setString(1, task.getTask());
            statement.setString(2, task.getDescription());
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

    public static boolean update(Task task) {
        final String query = "UPDATE task SET task = ?, description = ? WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(query);
            statement.setString(1, task.getTask());
            statement.setString(2, task.getDescription());
            statement.setInt(3, task.getId());
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

    public static boolean delete(Task task) {
        final String query = "DELETE FROM task WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(query);
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
        List<Task> tasks = new ArrayList<Task>();

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
