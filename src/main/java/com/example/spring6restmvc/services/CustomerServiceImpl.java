package com.example.spring6restmvc.services;

import com.example.spring6restmvc.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        CustomerDTO customer1 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("John Doe")
                .version(1)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        CustomerDTO customer2 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Jane Doe")
                .version(1)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        CustomerDTO customer3 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Pedro Rodiguez")
                .version(1)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public List<CustomerDTO> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        log.debug("Get Customer by Id - in Service. Id: " + id.toString());
        return Optional.of(customerMap.get(id));
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        CustomerDTO savedCustomer = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name(customer.getName())
                .version(1)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public Optional<CustomerDTO> updateCustomerById(UUID customerId, CustomerDTO customer) {
        CustomerDTO existingCustomer = customerMap.get(customerId);
        existingCustomer.setName(customer.getName());
        return Optional.of(existingCustomer);
    }

    @Override
    public Boolean deleteById(UUID customerId) {
        customerMap.remove(customerId);
        return true;
    }

    @Override
    public Optional<CustomerDTO> updateCustomerPatchById(UUID customerId, CustomerDTO customer) {
        CustomerDTO existingCustomer = customerMap.get(customerId);

        if (StringUtils.hasText(existingCustomer.getName())) {
            existingCustomer.setName(customer.getName());
        }
        return Optional.of(existingCustomer);
    }
}
