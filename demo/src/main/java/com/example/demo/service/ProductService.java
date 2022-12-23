package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.model.ProductModel;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public void createProduct(ProductModel productModel, Category category)
    {
        Product product=new Product();
        product.setProductName(productModel.getProductName());
        product.setCategory(category);
        product.setProductprice(productModel.getProductprice());
        productRepository.save(product);
    }
    public void deleteProduct(ProductModel productModel)
    {
        Product product=  productRepository.findByProductName(productModel.getProductName());
        productRepository.delete(product);
    }
    public void updateProduct(String name, ProductModel productModel)
    {
        Product product=  productRepository.findByProductName(name);
        product.setProductName(productModel.getProductName());
       // product.setCategory(productModel.getCategory());
        product.setProductprice(productModel.getProductprice());
        productRepository.save(product);
    }

    public List<Product> listProduct()
    {
        return productRepository.findAll();
    }

    public List<Product> listProductcontaining(String name)
    {
        return productRepository.findByProductNameContaining(name);
    }

    public List<Product> productofcategory(String name)
    {
        return productRepository.findByCategory(name);
    }



}
