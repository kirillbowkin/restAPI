package com.kirill.restAPI.repo;

import com.kirill.restAPI.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    List<Customer> findAllByOrderByIdAsc();;
}
