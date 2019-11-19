package com.maulik.spring.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maulik.spring.hibernate.entity.Customer;

@Repository
public class CustomerDAOIMpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}
	
	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
		
	}
	
	@Override
	public Customer getCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//alternative option
		//Customer customer = currentSession.get(Customer.class,theId);
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer where Id = " + theId, Customer.class);
		
		Customer customer = theQuery.getResultList().get(0);
		
		return customer;
	}
	
	@Override
	public void deleteCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate(); 
		
	}

}
