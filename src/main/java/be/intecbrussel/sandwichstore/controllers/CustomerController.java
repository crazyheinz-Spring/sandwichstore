package be.intecbrussel.sandwichstore.controllers;

import be.intecbrussel.sandwichstore.repositories.CustomerRepository;

public class CustomerController {

   private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


}
