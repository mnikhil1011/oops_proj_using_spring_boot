package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Wallet;
import com.example.demo.model.CustomerModel;
import com.example.demo.model.WalletModel;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Transactional
    public String registerCustomer(CustomerModel customerModel)
    {
        if(Objects.nonNull(customerRepository.findByEmailId(customerModel.getEmailId())))
            return "user already present";



        Customer customer = new Customer();

        customer.setEmailId(customerModel.getEmailId());

        customer.setFirstName(customerModel.getFirstName());
        customer.setLastName(customerModel.getLastName());
        customer.setPassword(customerModel.getPassword());


        customerRepository.save(customer);
        return "op";


    }

    public String loginCustomer(CustomerModel customerModel)
    {
        Customer customer=customerRepository.findByEmailId(customerModel.getEmailId());

        if (Objects.isNull(customer)) {
            return "user is not valid";
        }


        if(!customer.getPassword().equals( customerModel.getPassword()))
        {
            return"user password is not valid";
        }

        return "logged in";
    }

    public String registerWallet(WalletModel walletModel, String id)
    {
        Customer customer = customerRepository.findByCustomerId(id);
        Wallet wallet =new Wallet();
        wallet.setCustomer(customer);
        wallet.setCreditno(walletModel.getCard());
        wallet.setBalance(wallet.getBalance()+ walletModel.getAmt());
        walletRepository.save(wallet);
          return "ok";
    }
}
