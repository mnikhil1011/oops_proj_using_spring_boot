package com.example.demo.controller;

import com.example.demo.model.ProductToCartModel;
import com.example.demo.repository.CartRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartRepository cartRepository;

    @PostMapping("/add")

    public String addProduct(@RequestBody ProductToCartModel productToCartModel)
    {
        return "done";
    }




}
