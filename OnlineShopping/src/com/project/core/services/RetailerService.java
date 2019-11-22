package com.project.core.services;

import java.util.List;
import com.project.core.entities.Retailer;
import com.project.core.exception.OsException;

public interface RetailerService {
	public List<Retailer> showAllRetailer() throws OsException;
	public boolean addRetailer(Retailer ret) throws OsException;
	public Retailer loginRetailer(String username);
}
