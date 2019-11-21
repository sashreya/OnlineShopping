package com.project.core.daos;

import java.util.List;

import com.project.core.entities.Customer;
import com.project.core.entities.Product;
import com.project.core.exception.CustException;
import com.project.core.exception.OsException;


public interface CustomerDao {
	public List<Customer> getAllCustomers() throws CustException ;
	public int insertNewCustomer(Customer cust) throws CustException;
	public Customer validateCustomer(String username, String password);
}
