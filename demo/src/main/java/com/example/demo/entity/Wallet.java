package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wallet {

    @Id
    @SequenceGenerator(
            name="wallet_sequence",
            sequenceName="wallet_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="wallet_sequence"
    )
    private long walletId;
    private long balance=0;
    private long creditno;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name ="customer_id" ,
            referencedColumnName = "customerId"
    )
    private Customer customer;
}


