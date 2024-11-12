package devzeus.com.kiemtra_ltweb_de6.service.impl;

import devzeus.com.kiemtra_ltweb_de6.dao.CategoryDao;
import devzeus.com.kiemtra_ltweb_de6.dao.impl.CategoryDaoImpl;
import devzeus.com.kiemtra_ltweb_de6.model.Category;
import devzeus.com.kiemtra_ltweb_de6.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public Category getCategory(int id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}
