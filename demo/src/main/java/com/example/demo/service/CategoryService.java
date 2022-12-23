package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.model.CategoryModel;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public void createCategory(CategoryModel categoryModel)
    {
        Category category=new Category();
        category.setCategoryName(categoryModel.getCategoryName());
        categoryRepository.save(category);

    }

    @Transactional
    public void deleteCategory(CategoryModel categoryModel)
    {
        Category category=categoryRepository.findByCategoryName(categoryModel.getCategoryName());
        categoryRepository.delete(category);
    }

    public void updateCategory(String name ,CategoryModel categoryModel)
    {
        Category category=categoryRepository.findByCategoryName(name);
        category.setCategoryName(categoryModel.getCategoryName());
        categoryRepository.save(category);

    }

    public List<Category> listCategory()

    {

        return categoryRepository.findAll();
    }


}
