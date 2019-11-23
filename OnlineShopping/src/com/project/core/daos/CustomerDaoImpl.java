package com.project.core.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.project.core.entities.Customer;
import com.project.core.exception.CustException;

/**
 * 
 * @author SoleMates
 *
 */
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
	public Customer getCustomerByMail(String username) {
		Query qry2 = manager.createQuery("select c from customer c where c.customerMail= :user");
		qry2.setParameter("user", username);		
		return (Customer)(qry2.getSingleResult());
	}


	@Transactional
	@Override
	public int updateCustomerPassword(String username, String newPassword) {
		 Query query = manager.createQuery("update customer c set c.customerPassword=:newPass WHERE c.customerMail=:user");
		 query.setParameter("newPass", newPassword);
		 query.setParameter("user", username);
		 int rowsUpdated = query.executeUpdate();
		 return rowsUpdated;
	}






}
