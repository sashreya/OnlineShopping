package com.project.core.daos;

import java.util.List;

import com.project.core.entities.Product;
import com.project.core.exception.OsException;

public interface ProductDao {
	
	public List<Product> getAllProducts() throws OsException ;
	public int insertNewProduct(Product pro) throws OsException ;
	
	/*public Product getProductById(int productId);
	*/

}
