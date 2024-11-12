package devzeus.com.kiemtra_ltweb_de6.dao.impl;

import devzeus.com.kiemtra_ltweb_de6.config.DBConnectMySQL;
import devzeus.com.kiemtra_ltweb_de6.dao.UserDao_22110139;
import devzeus.com.kiemtra_ltweb_de6.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl_22110139 implements UserDao_22110139 {
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users (username, password, phone, fullname, email, admin, active, images) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getPhone());
            statement.setString(4, user.getFullname());
            statement.setString(5, user.getEmail());
            statement.setBoolean(6, user.isAdmin());
            statement.setBoolean(7, user.isActive());
            statement.setString(8, user.getImages());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET password = ?, phone = ?, fullname = ?, email = ?, admin = ?, active = ?, images = ? WHERE username = ?";
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getPassword());
            statement.setString(2, user.getPhone());
            statement.setString(3, user.getFullname());
            statement.setString(4, user.getEmail());
            statement.setBoolean(5, user.isAdmin());
            statement.setBoolean(6, user.isActive());
            statement.setString(7, user.getImages());
            statement.setString(8, user.getUsername());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        User user = null;
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("fullname"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("admin"),
                        resultSet.getBoolean("active"),
                        resultSet.getString("images")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        User user = null;
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("fullname"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("admin"),
                        resultSet.getBoolean("active"),
                        resultSet.getString("images")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("fullname"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("admin"),
                        resultSet.getBoolean("active"),
                        resultSet.getString("images")
                );
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void deleteUser(String username) {
        String sql = "DELETE FROM users WHERE username = ?";
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
