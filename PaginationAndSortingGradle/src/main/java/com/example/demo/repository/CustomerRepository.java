package com.example.demo.repository;
import com.example.demo.model.Customer;


import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}
