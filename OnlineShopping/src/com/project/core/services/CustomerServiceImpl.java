package com.project.core.services;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.core.daos.CustomerDao;
import com.project.core.entities.Customer;
import com.project.core.exception.CustException;

@Service("productCustomer")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
		
	public CustomerServiceImpl() {
		super();
	}

	@Resource(name="customerDao")
	private CustomerDao cdao;
	
	@Override
	@Transactional(propagation = Propagation.NEVER)
	public List<Customer> showAllCustomer() throws CustException {
		return cdao.getAllCustomers();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addCustomer(Customer cust) throws CustException {
		int result =cdao.insertNewCustomer(cust);
		if(result==1)
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	/*
	 * @Override public Boolean loginCustomer(String username, String password) {
	 * Customer cust1 = new Customer(); cust1=cdao.getCustomerByMail(username);
	 * //String user = cust1.getCustomerMail(); String pass =
	 * cust1.getCustomerPassword(); if(pass.contentEquals(password)) { return true;
	 * } else { return false; } }
	 * 
	 */

	@Override
	public Customer loginCustomer(String username) {
		Customer cust1 = new Customer();
		cust1=cdao.getCustomerByMail(username);
		return cust1;
	}
	
	
}
