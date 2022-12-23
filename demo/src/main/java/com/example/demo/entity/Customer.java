package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name="tbl_customer"
)
public class Customer {

    @Id
    @SequenceGenerator(
            name="customer_sequence",
            sequenceName="customer_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="customer_sequence"
    )
    private long customerId;
    private String firstName;
    private String lastName;

    private String emailId;

    @OneToOne(
            mappedBy = "customer"
    )
   private Wallet wallet;

    @Column(length = 60)
    private String password;

    private String address;

    @OneToOne(
            mappedBy = "customer"
    )
    private Cart cart;

    @OneToOne(
            mappedBy = "customer"
    )
    private OrderPlaced orderPlaced;





}
