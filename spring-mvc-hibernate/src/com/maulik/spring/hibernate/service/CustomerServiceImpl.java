package com.maulik.spring.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maulik.spring.hibernate.dao.CustomerDAO;
import com.maulik.spring.hibernate.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
		
	}
	
	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		Customer customer = customerDAO.getCustomer(theId);
		
		return customer;
	}
	
	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
		
	}

}
