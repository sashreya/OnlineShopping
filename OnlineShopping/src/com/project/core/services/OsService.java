package com.project.core.services;

import java.util.List;

import com.project.core.entities.Product;
import com.project.core.exception.OsException;

public interface OsService {
	public List<Product> showAllProduct() throws OsException;
	public boolean addProduct(Product product) throws OsException;
	
}
