package com.longhoang.springallofmodule2.services.impl;

import com.longhoang.springallofmodule2.models.Customer;
import com.longhoang.springallofmodule2.repository.CustomerRepository;
import com.longhoang.springallofmodule2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findCustomerByFirstName(String name, Pageable pageable) {
        return customerRepository.findCustomerByFirstName(name, pageable);
    }


}
