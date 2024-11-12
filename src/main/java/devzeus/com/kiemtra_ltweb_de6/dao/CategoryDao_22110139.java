package devzeus.com.kiemtra_ltweb_de6.dao;

import devzeus.com.kiemtra_ltweb_de6.model.Category_22110139;

import java.util.List;

public interface CategoryDao_22110139 {
    void addCategory(Category_22110139 category);
    void updateCategory(Category_22110139 category);
    Category_22110139 getCategoryById(int categoryId);
    List<Category_22110139> getAllCategories();
    void deleteCategory(int categoryId);
}
