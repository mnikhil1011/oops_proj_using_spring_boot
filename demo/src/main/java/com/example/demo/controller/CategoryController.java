package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.model.CategoryModel;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public String createCategory(@RequestBody CategoryModel categoryModel)

    {
        categoryService.createCategory(categoryModel);
        return "category";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestBody CategoryModel categoryModel)
    {
        categoryService.deleteCategory(categoryModel);
        return "deleted";
    }

    @PostMapping("/update/{categoryName}")
    public String updateCategory(@PathVariable("categoryName") String name, @RequestBody CategoryModel categoryModel)
    {
        categoryService.updateCategory(name,categoryModel);
        return "updated";
    }

    @GetMapping("/")
    public List<Category> listCategory() {
        return categoryService.listCategory();
    }




}
