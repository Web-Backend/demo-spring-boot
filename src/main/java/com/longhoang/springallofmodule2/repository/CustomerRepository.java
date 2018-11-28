package com.longhoang.springallofmodule2.repository;

import com.longhoang.springallofmodule2.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Page<Customer> findCustomerByFirstName(String name, Pageable pageable);
}
