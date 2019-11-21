package com.project.core.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.project.core.entities.Product;
import com.project.core.exception.OsException;

@Repository("productDao")
@Scope("singleton")
public class ProductDaoImpl implements ProductDao {
	
		public ProductDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
		@PersistenceContext
		private EntityManager manager;
		
		/*@Autowired
		private JdbcTemplate jTemp;*/

		/*@Override
		public int insertNewProduct(Product pro) throws OsException {
			String qry1 = "INSERT INTO Product(productId,productName,brand,productPrice,productDesc,category,productStatus,quantity) VALUES(?,?,?,?,?,?,?,?)";
			Object[] params = {pro.getProductId(),pro.getProductName(),pro.getBrand(),pro.getProductPrice(),pro.getProductDesc(),pro.getCategory(),pro.getProductStatus(),pro.getQuantity()};
			int returnVal = jTemp.update(qry1,params);
			return returnVal;
		}*/

		/*@Override
		public Product getProductById(int productId) {
			Product pro = manager.find(Product.class, productId);
			return pro;
		}*/

		@Override
		public List<Product> getAllProducts() throws OsException {
			Query qry1= manager.createQuery("from prods");
			List<Product> productList = qry1.getResultList();
			return productList;
		}

		@Override
		public int insertNewProduct(Product pro) throws OsException {
		
			manager.persist(pro);
		
			return 1;
		}
		
		
		/*class RowMapperFactory implements RowMapper<Product>{ //to retrieve all the records from the table	 
		@Override 
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException { 
			
			int productId = rs.getInt("productId"); 
			String productName =rs.getString("productName"); 
			String brand = rs.getString("brand");
			long productPrice = rs.getLong("productPrice");  
			String productDesc = rs.getString("productDesc"); 
			String category = rs.getString("category");
			String productStatus = rs.getString("productStatus");
			int quantity = rs.getInt("quantity");
			   
			Product prod = new Product();
			prod.setProductId(productId);
			prod.setProductName(productName);
			prod.setBrand(brand);
			prod.setProductPrice(productPrice);
			prod.setProductDesc(productDesc);
			prod.setCategory(category);
			prod.setProductStatus(productStatus);
			prod.setQuantity(quantity);
			return prod; 
		}
		}*/
}
			



