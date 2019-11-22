package com.project.core.daos;

import java.util.List;
import com.project.core.entities.Retailer;
import com.project.core.exception.OsException;

public interface RetailerDao {
	public List<Retailer> getAllRetailer() throws OsException ;
	public int insertNewRetailer(Retailer ret) throws OsException;
	public Retailer getRetailerByMail(String username);
}

