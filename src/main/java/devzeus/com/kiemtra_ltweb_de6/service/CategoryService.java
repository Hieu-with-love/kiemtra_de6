package devzeus.com.kiemtra_ltweb_de6.service;

import devzeus.com.kiemtra_ltweb_de6.model.Category;

import java.util.List;

public interface CategoryService {
    Category getCategory(int id);
    List<Category> getAllCategories();
}
