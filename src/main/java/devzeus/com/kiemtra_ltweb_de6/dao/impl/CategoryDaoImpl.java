package devzeus.com.kiemtra_ltweb_de6.dao.impl;

import devzeus.com.kiemtra_ltweb_de6.config.DBConnectMySQL;
import devzeus.com.kiemtra_ltweb_de6.dao.CategoryDao;
import devzeus.com.kiemtra_ltweb_de6.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public void addCategory(Category category) {
        String sql = "INSERT INTO category (categoryname, categorycode, images, status) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, category.getCategoryName());
            statement.setString(2, category.getCategoryCode());
            statement.setString(3, category.getImages());
            statement.setBoolean(4, category.isStatus());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCategory(Category category) {
        String sql = "UPDATE category SET categoryname = ?, categorycode = ?, images = ?, status = ? WHERE categoryid = ?";
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, category.getCategoryName());
            statement.setString(2, category.getCategoryCode());
            statement.setString(3, category.getImages());
            statement.setBoolean(4, category.isStatus());
            statement.setInt(5, category.getCategoryId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category getCategoryById(int categoryId) {
        String sql = "SELECT * FROM category WHERE categoryid = ?";
        Category category = null;
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                category = new Category(
                        resultSet.getInt("categoryid"),
                        resultSet.getString("categoryname"),
                        resultSet.getString("categorycode"),
                        resultSet.getString("images"),
                        resultSet.getBoolean("status")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        String sql = "SELECT * FROM category";
        List<Category> categories = new ArrayList<>();
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Category category = new Category(
                        resultSet.getInt("categoryid"),
                        resultSet.getString("categoryname"),
                        resultSet.getString("categorycode"),
                        resultSet.getString("images"),
                        resultSet.getBoolean("status")
                );
                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void deleteCategory(int categoryId) {
        String sql = "DELETE FROM category WHERE categoryid = ?";
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, categoryId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
