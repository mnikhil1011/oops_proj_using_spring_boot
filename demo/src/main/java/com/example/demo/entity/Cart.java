package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id
    @SequenceGenerator(
            name="cart_sequence",
            sequenceName="cart_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="cart_sequence"
    )
    private long cartId;



    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name ="customer_id" ,
            referencedColumnName = "customerId"
    )
    private Customer customer;
    private int fortestin;

    @ManyToMany
    @JoinTable(
            name= "cart_product_map" ,
            joinColumns = @JoinColumn(
                    name = "cart_id",
                    referencedColumnName = "cartId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id",
                    referencedColumnName = "productId"
            )

    )
    private List<Product>products;




}
