package devzeus.com.kiemtra_ltweb_de6.dao;

import devzeus.com.kiemtra_ltweb_de6.model.Category;

import java.util.List;

public interface CategoryDao {
    void addCategory(Category category);
    void updateCategory(Category category);
    Category getCategoryById(int categoryId);
    List<Category> getAllCategories();
    void deleteCategory(int categoryId);
}
