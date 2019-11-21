package com.project.core.services;

import java.util.List;

import com.project.core.entities.Customer;
import com.project.core.entities.Product;
import com.project.core.exception.CustException;
import com.project.core.exception.OsException;

public interface CustomerService {
	public List<Customer> showAllCustomer() throws CustException;
	public boolean addCustomer(Customer cust) throws CustException;
	public Customer get(String username, String password);

}
