package jm.task.core.jdbc.dao;

import java.sql.Connection;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(50)," +
                "lastName VARCHAR(50)," +
                "age TINYINT)";

        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";

        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";

        try (Connection connection = Util.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);
            ps.executeUpdate();

            System.out.println("User with name – " + name + " added to database");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection connection = Util.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastName"));
                user.setAge(rs.getByte("age"));
                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM users";

        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
