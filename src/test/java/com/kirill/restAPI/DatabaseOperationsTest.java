package com.kirill.restAPI;

import com.kirill.restAPI.model.Customer;
import com.kirill.restAPI.repo.CustomerRepo;
import com.kirill.restAPI.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("/application-prod.properties")
public class DatabaseOperationsTest {

    @Autowired
    private CustomerRepo customerRepo;

    @Test
    public void TestGetUsers(){

       assertNotNull(customerRepo.findAll());
    }

    @Test
    public void TestGetUser(){

        assertEquals(1, customerRepo.findById(1L).get().getId(), 1e-9);
    }

    @Test
    public void TestPostUser(){

        Customer customer = new Customer();

        customer.setFirstName("first_name");

        customerRepo.save(customer);

        assertEquals(customer.getFirstName(), customerRepo.findById(6L).get().getFirstName());


    }

    @Test
    public void TestUpdateUser(){

        Customer customer = new Customer();

        customer.setId(1L);
        customer.setFirstName("first_name");

        customerRepo.save(customer);

        assertEquals(customer.getFirstName(), customerRepo.findById(1L).get().getFirstName());

    }

    @Test
    public void TestDeleteUser(){

        customerRepo.deleteById(1L);

        assertNull(customerRepo.findById(1L).orElse(null));
    }
}
