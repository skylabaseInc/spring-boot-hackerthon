package com.example.demo.controller;
import  com.example.demo.model.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService _customerService;
	
	@RequestMapping("/save")
	public String process() {
		_customerService.save(new Customer("jack","Smith"));
		_customerService.save(new Customer("Adam", "Johnson"));
		_customerService.save(new Customer("Kim", "Smith"));
		_customerService.save(new Customer("David", "Williams"));
		_customerService.save(new Customer("Peter", "Davis"));
		
		return "done";
	}
	
	
	@RequestMapping("/findall")
	public String findAll() {
		String result ="<html>";
		for(Customer customer :_customerService.findAllCustomer()) {
			result+= customer.toString()+"<br/>";
		}
		return result +"</html>";
		
	}
	
	@RequestMapping(value ="/customer", method=RequestMethod.GET)
	public String viewCustomer(@RequestParam(name="page",defaultValue="1") int pageNumber) {
		List<Customer> customers = _customerService.getPage(pageNumber);
		String result ="<html>";
		for(Customer customer : customers) {
			result += customer.toString() + "<br/>";
		}
		return result+"<html>";
	}
}
