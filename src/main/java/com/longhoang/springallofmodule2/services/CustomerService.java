package com.longhoang.springallofmodule2.services;

import com.longhoang.springallofmodule2.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void delete(Long id);

    Page<Customer> findCustomerByFirstName(String name, Pageable pageable);
}
