package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.model.ProductModel;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/create")
    public String createProduct(@RequestBody ProductModel productModel)
    {
        Category category= categoryRepository.findByCategoryId(productModel.getCategoryId());

           productService.createProduct(productModel,category);
           return "made it homie";


    }

    @PostMapping("/delete")
    public  String deleteProduct(@RequestBody ProductModel productModel)
    {
        productService.deleteProduct(productModel);
        return "product deleted";
    }

    @GetMapping("/")
    public List<Product> listProduct() {
        return productService.listProduct();
    }

    @PostMapping("/update/{name}")
    public String updateProduct(@PathVariable("name") String name,@RequestBody ProductModel productModel)
    {
        productService.updateProduct(name, productModel);
        return "updated";
    }

    @PostMapping("/search")
    public  List<Product> searchProduct(String name )
    {
        return  productService.listProductcontaining(name);
    }

    @RequestMapping ("/{category}")
    public  List<Product> podwithcategory(@PathVariable("category") String name)
    {
        return productService.productofcategory(name);
    }






}
