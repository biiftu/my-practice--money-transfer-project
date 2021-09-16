package com.practice.moneytransferapp.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="name cannot be blank")
    @Column(nullable=false)
    @Size(max = 15, min = 4)
    private String first_name;

    @NotBlank(message="middle name cannot be blank")
    @Column(nullable=false)
    @Size(max = 15, min = 4)
    private String middle_name;

    @NotBlank(message="last name cannot be blank")
    @Column(nullable=false)
    @Size(max = 15, min = 4)
    private String last_name;

    @NotBlank(message="email cannot be blank")
    @Column(nullable=false, unique = true)
    private String email;

    @NotBlank(message="phone number cannot be blank")
    @Column(nullable=false, unique = true)
    private String phone_number;

    @NotBlank(message="phone number cannot be blank")
    @Column(nullable=false)
    private LocalDate birth_date;

    @NotNull(message="pin cannot be blank")
    @Column(nullable=false)
    private Integer pin;

    private Boolean isVerified = Boolean.TRUE;
    
    private Double balance = 0.0;
}