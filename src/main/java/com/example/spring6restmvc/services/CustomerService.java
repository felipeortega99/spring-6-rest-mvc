package com.example.spring6restmvc.services;


import com.example.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> listCustomers();

    Customer getCustomerById(UUID id);

    Customer saveNewCustomer(Customer customer);

    void updateCustomerById(UUID customerId, Customer customer);

    void deleteById(UUID customerId);

    void updateCustomerPatchById(UUID customerId, Customer customer);
}
