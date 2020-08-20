package com.kirill.restAPI.service;

import com.kirill.restAPI.model.Customer;
import com.kirill.restAPI.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer getById(Long id) {

        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepo.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepo.findAllByOrderByIdAsc();
    }

    @Override
    public List<Customer> getAllByLastName(String lastName) {
        return customerRepo.findAllByLastName(lastName);
    }
}
