package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedModel {

    int amount;
    Date date;
    Long customerId;
    Long productId;
    int amt;
}
