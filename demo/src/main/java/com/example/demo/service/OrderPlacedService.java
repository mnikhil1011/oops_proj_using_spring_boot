package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Customer;
import com.example.demo.entity.OrderPlaced;
import com.example.demo.entity.Product;
import com.example.demo.model.OrderPlacedModel;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderPlacedRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderPlacedService {

    @Autowired
    OrderPlacedRepository orderPlacedRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;

    public List<OrderPlaced> listOrderPlaced()
    {
        return orderPlacedRepository.findAll();
    }

    public void createOrderPlaced(OrderPlacedModel orderPlacedModel)
    {
        OrderPlaced orderPlaced=new OrderPlaced();
        Product product=productRepository.findByProductId(orderPlacedModel.getProductId());
        Customer customer =customerRepository.findByCustomerId(orderPlacedModel.getCustomerId());
        orderPlaced.setAmount(orderPlacedModel.getAmount());
        orderPlaced.setDate(orderPlacedModel.getDate());
        orderPlaced.setProduct(product);
        orderPlaced.setCustomer(customer);
        orderPlaced.setNumberofitem(orderPlacedModel.getAmt());

        orderPlacedRepository.save(orderPlaced);



    }
}
