package com.kirill.restAPI;

import com.kirill.restAPI.model.Customer;
import com.kirill.restAPI.repo.CustomerRepo;
import com.kirill.restAPI.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("/application-prod.properties")
public class DatabaseOperationsTest {

    @Autowired
    private CustomerRepo customerRepo;

    @Test
    public void TestGetCustomers(){

       assertNotNull(customerRepo.findAll());
    }

    @Test
    public void TestGetCustomersByLastName(){

        Customer customer = new Customer();

        customer.setFirstName("first_name");
        customer.setLastName("last_name");
        customer.setPhoneNumber("phone_number");
        customer.setEmail("email");

        customerRepo.save(customer);

        assertNotNull(customerRepo.findAllByLastName("last_name"));
    }

    @Test
    public void TestGetCustomer(){

        assertEquals(1, customerRepo.findById(1L).get().getId(), 1e-9);
    }

    @Test
    public void TestPostCustomer(){

        Customer customer = new Customer();

        customer.setFirstName("first_name");

        customerRepo.save(customer);

        assertEquals(customer.getFirstName(), customerRepo.findById(6L).get().getFirstName());


    }

    @Test
    public void TestUpdateCustomer(){

        Customer customer = new Customer();

        customer.setId(1L);
        customer.setFirstName("first_name");

        customerRepo.save(customer);

        assertEquals(customer.getFirstName(), customerRepo.findById(1L).get().getFirstName());

    }

    @Test
    public void TestDeleteCustomer(){

        customerRepo.deleteById(1L);

        assertNull(customerRepo.findById(1L).orElse(null));
    }
}
