package com.project.core.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.core.daos.ProductDao;
import com.project.core.entities.Product;
import com.project.core.exception.OsException;
@Service("productService")
@Transactional
public class OsServiceImpl implements OsService {

	
	
	public OsServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Resource(name="productDao")
	private ProductDao dao;
	
	@Override
	@Transactional(propagation=Propagation.NEVER)
	public List<Product> showAllProduct() throws OsException {	
		return dao.getAllProducts();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addProduct(Product product) throws OsException {
		int result =dao.insertNewProduct(product);
		if(result==1)
		{
			return true;
		}
		else {
			return false;
		}
	}

}
