package com.kirill.restAPI.service;

import com.kirill.restAPI.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(Long id);

    void save(Customer customer);

    void delete(Long id);

    List<Customer> getAll();

    List<Customer> getAllByLastName(String lastName);

}
