package com.kirill.restAPI.controller;

import com.kirill.restAPI.model.Customer;
import com.kirill.restAPI.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class GreetingController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String greet(Model model){

        Customer customer = customerService.getById(1L);

        if(customer.getId() == 1L){

            log.info("API is working");

            model.addAttribute("info", "RESTful API is online");
            model.addAttribute("online", true);

            return "greet";

        }else{
            log.warn("API is unavailable");

            model.addAttribute("info", "RESTful API is unavailable");
            model.addAttribute("online", false);

            return "greet";
        }

    }
}
