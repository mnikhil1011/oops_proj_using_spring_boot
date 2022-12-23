package com.example.demo.controller;


import com.example.demo.entity.Category;
import com.example.demo.entity.OrderPlaced;
import com.example.demo.entity.Product;
import com.example.demo.model.OrderPlacedModel;
import com.example.demo.model.ProductModel;
import com.example.demo.repository.OrderPlacedRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.OrderPlacedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderplaced")

public class OrderPlacedController {

    @Autowired
    OrderPlacedService orderPlacedService;
    @Autowired
    OrderPlacedRepository orderPlacedRepository;


    @GetMapping("/")
    public List<OrderPlaced> listOrderPlaced() {
        return orderPlacedService.listOrderPlaced();
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody OrderPlacedModel orderPlacedModel)
    {
        orderPlacedService.createOrderPlaced(orderPlacedModel);
        return "made it homie";
    }


}
