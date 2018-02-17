package com.example.demo.service;
import com.example.demo.model.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	private final static int PAGESIZE=3;
	
	@Autowired
	private CustomerRepository _customer;
	
	public void save(Customer customer ) {
		_customer.save(customer);	
	}
	
	public Iterable<Customer> findAllCustomer(){
		return _customer.findAll();
	}

	public List<Customer> getPage(int pageNumber){
		PageRequest request= new PageRequest(pageNumber -1,PAGESIZE, Sort.Direction.ASC,"id");
		return _customer.findAll(request).getContent();
	}
}
