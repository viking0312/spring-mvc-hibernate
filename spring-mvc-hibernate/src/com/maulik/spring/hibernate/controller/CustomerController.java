package com.maulik.spring.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maulik.spring.hibernate.dao.CustomerDAO;
import com.maulik.spring.hibernate.entity.Customer;
import com.maulik.spring.hibernate.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> customers = customerService.getCustomers();
		
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showCustomerForm(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "add-customer-form";
		
	}
	
	
	  @PostMapping("/processForm") 
	  public String addCustomer(@ModelAttribute("customer") Customer theCustomer) {
		  
		  customerService.saveCustomer(theCustomer);
	  
		  return "redirect:/customer/list";
	  
	  }
	 
	
	  @GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
			
			Customer theCustomer = customerService.getCustomer(theId);
			
			theModel.addAttribute("customer", theCustomer);
			
			return "add-customer-form";
			
		}
	  
	  @GetMapping("/deleteCustomer") 
	  public String deleteCustomer(@RequestParam("customerId") int theId,Model theModel) {
		  
		  customerService.deleteCustomer(theId);
	  
		  return "redirect:/customer/list";
	  
	  }
}
