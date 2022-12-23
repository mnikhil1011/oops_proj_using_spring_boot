package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPlaced {

    @Id
    @SequenceGenerator(
            name="order_sequence",
            sequenceName="order_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="order_sequence"
    )
    private long orderId;
    private int amount;
    private int numberofitem;
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name ="customer_id" ,
            referencedColumnName = "customerId"
    )
    private Customer customer;


    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "productId"
    )

    private Product product;

    private Date date;


}
