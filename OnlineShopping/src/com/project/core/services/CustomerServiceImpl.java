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
	public Customer get(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
