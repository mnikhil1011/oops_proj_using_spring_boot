package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveCustomer()
    {




        Customer customer=Customer.builder()
                .emailId("niktest1@ok.com")
                .firstName("niktry1")
                .build();
        customerRepository.save(customer);

    }

    @Test
    public void updateCustomerNameByEmailIdTest()
        {
        customerRepository.updateCustomerNameByEmailId("nikhilupdate","niktest1@ok.com");
    }
    @Test
    public void printCustomers()
    {
        List<Customer> customers=customerRepository.findAll();
        System.out.println("customers "+ customers);
    }
}