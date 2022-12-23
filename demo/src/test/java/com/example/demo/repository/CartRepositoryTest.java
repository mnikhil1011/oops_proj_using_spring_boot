package com.example.demo.repository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void saveCart()
    {


        Customer customer=Customer.builder()
                .emailId("niktest1@ok.com")
                .firstName("niktry1")

                .build();
        Cart cart= Cart.builder()
                .fortestin(80)
                .customer(customer)
                .build();

        cartRepository.save(cart);

    }

}