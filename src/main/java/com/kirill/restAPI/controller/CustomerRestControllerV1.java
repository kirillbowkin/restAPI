package com.kirill.restAPI.controller;

import com.kirill.restAPI.model.Customer;
import com.kirill.restAPI.service.CustomerService;
import com.kirill.restAPI.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerRestControllerV1 {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId){
        if(customerId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer customer = this.customerService.getById(customerId);


        if(customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> saveCustomer(@RequestBody @Validated Customer customer){
        if(customer == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.customerService.save(customer);

        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Validated Customer customer){
        if(customer == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(customer.getId() == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.customerService.save(customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long customerId){
        Customer customer = this.customerService.getById(customerId);

        if(customer == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.delete(customerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAll();

        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
