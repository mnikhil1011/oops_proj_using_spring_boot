package com.example.demo.controller;

import com.example.demo.model.CustomerModel;
import com.example.demo.model.WalletModel;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RegisterationController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/register")
    public String registerCustomer(@RequestBody CustomerModel customerModel)
    {

//        return customerService.registerCustomer(customerModel);
        return "register";

    }
    @PostMapping("/addmoney1")
    public  String registerWallet(@RequestBody WalletModel walletModel,  @RequestParam String id)
    {
        return customerService.registerWallet(walletModel , id);
    }

    @PostMapping("/login")
    public String loginCustomer(@RequestBody CustomerModel customerModel)
    {
       return customerService.loginCustomer(customerModel);

    }


}
