package com.project.core.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.project.core.entities.Customer;
import com.project.core.exception.CustException;


@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	
	
	public CustomerDaoImpl() {
		super();
	}

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Customer> getAllCustomers() throws CustException {
		Query qry1= manager.createQuery("from customer");
		List<Customer> CustomerList = qry1.getResultList();
		return CustomerList;
	}

	
	@Override
	public int insertNewCustomer(Customer cust) throws CustException {
		// TODO Auto-generated method stub
		manager.persist(cust);
		return 1;
	}


	@Override
	public Customer validateCustomer(String username, String password) {
		Query qry2 = manager.createQuery("select c from customer c where c.customerMail= :user and c.customerPassword= :pass");
		qry2.setParameter("user", username);
		qry2.setParameter("pass", password);
		return (Customer)qry2.getSingleResult();
	}





	
}
