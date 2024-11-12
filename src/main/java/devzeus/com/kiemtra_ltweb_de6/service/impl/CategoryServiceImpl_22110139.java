package devzeus.com.kiemtra_ltweb_de6.service.impl;

import devzeus.com.kiemtra_ltweb_de6.dao.CategoryDao_22110139;
import devzeus.com.kiemtra_ltweb_de6.dao.impl.CategoryDaoImpl_22110139;
import devzeus.com.kiemtra_ltweb_de6.model.Category_22110139;
import devzeus.com.kiemtra_ltweb_de6.service.CategoryService_22110139;

import java.util.List;

public class CategoryServiceImpl_22110139 implements CategoryService_22110139 {
    CategoryDao_22110139 categoryDao = new CategoryDaoImpl_22110139();
    @Override
    public Category_22110139 getCategory(int id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public List<Category_22110139> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}
