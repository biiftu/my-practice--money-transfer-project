package com.practice.moneytransferapp.domains;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    private String middle_name;

    private String last_name;

    private String email;

    private String phone_number;

    private Integer pin;

    private Boolean isVerified;

    private Double balance;
}
