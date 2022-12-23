package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerModel {




    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String matchingPassword;


}
