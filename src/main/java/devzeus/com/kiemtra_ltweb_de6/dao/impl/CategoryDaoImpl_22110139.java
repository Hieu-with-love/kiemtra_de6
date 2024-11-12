package devzeus.com.kiemtra_ltweb_de6.dao.impl;

import devzeus.com.kiemtra_ltweb_de6.config.DBConnectMySQL;
import devzeus.com.kiemtra_ltweb_de6.dao.CategoryDao_22110139;
import devzeus.com.kiemtra_ltweb_de6.model.Category_22110139;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl_22110139 implements CategoryDao_22110139 {

    @Override
    public void addCategory(Category_22110139 category) {
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
    public void updateCategory(Category_22110139 category) {
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
    public Category_22110139 getCategoryById(int categoryId) {
        String sql = "SELECT * FROM category WHERE categoryid = ?";
        Category_22110139 category = null;
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                category = new Category_22110139(
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
    public List<Category_22110139> getAllCategories() {
        String sql = "SELECT * FROM category";
        List<Category_22110139> categories = new ArrayList<>();
        try (Connection connection = DBConnectMySQL.getDatabaseConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Category_22110139 category = new Category_22110139(
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
