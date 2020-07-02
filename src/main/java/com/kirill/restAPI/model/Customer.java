package com.kirill.restAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Customer {

    @Id
    @SequenceGenerator(name = "jpa_serial", sequenceName = "serial", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_serial")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

}
