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

	@Override
	@Transactional
	public Customer loginCustomer(String username) {
		Customer cust1 = new Customer();
		cust1=cdao.getCustomerByMail(username);
		return cust1;
	}

	@Override
	@Transactional
	public int ForgetPassword(String username, String newPassword) {
		/*
		 * Customer cust2 = new Customer(); cust2=cdao.updateCustomerPassword(username,
		 * newPassword);
		 */
		return cdao.updateCustomerPassword(username, newPassword);
	}
	
	
}
