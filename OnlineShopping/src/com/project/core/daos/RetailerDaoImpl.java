package com.project.core.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.project.core.entities.Retailer;
import com.project.core.exception.OsException;


@Repository("retailerDao")
@Scope("singleton")
public class RetailerDaoImpl implements RetailerDao {


	public RetailerDaoImpl() {
		super();
	}

	@PersistenceContext
	private EntityManager manager1;

	@Override
	public List<Retailer> getAllRetailer() throws OsException {
		Query qry1= manager1.createQuery("from retailer");
		List<Retailer> RetailerList = qry1.getResultList();
		return RetailerList;
	}

	@Override
	public int insertNewRetailer(Retailer ret) throws OsException {
		manager1.persist(ret);
		return 1;
	}

	@Override
	public Retailer getRetailerByMail(String username) {
		Query qry2 = manager1.createQuery("select r from retailer r where r.retailerMail= :user");
		qry2.setParameter("user", username);		
		return (Retailer)(qry2.getSingleResult());
	}
}