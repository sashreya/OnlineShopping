package com.project.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.project.core.entities.Product;

import com.project.core.exception.OsException;
import com.project.core.services.OsService;

@Controller
public class ProductController {
	
@Autowired
private OsService service;

@Autowired
private Product product;


//http://localhost:9090/OnlineShopping/productList.shop
@RequestMapping("productList.shop")			//every method should have a different url
public ModelAndView getproductList() throws OsException  {
	List<Product> prodList = service.showAllProduct();
	String jspName = "ProductList";
	ModelAndView mAndV = new ModelAndView();
	mAndV.addObject("productList", prodList);
	mAndV.setViewName(jspName);
	return mAndV;
}

@RequestMapping(path="/")
public String homePage(){
	return "Home";
}
///http://localhost:9090/OnlineShopping/addProduct.shop
@RequestMapping(path="addProduct.shop", method=RequestMethod.GET)
public String addProductPage(){
	return "AddProduct";
}

@RequestMapping(path="addProduct.shop", method=RequestMethod.POST)
public String addProduct(@RequestParam("productId") int productId,@RequestParam("productName") String productName, @RequestParam("brand") String brand,@RequestParam("productPrice") long productPrice,@RequestParam("productDesc") String productDesc,@RequestParam("category") String category,@RequestParam("productStatus") String productStatus,@RequestParam("quantity") int quantity) throws OsException
{
	product.setProductId(productId);
	product.setProductName(productName);
	product.setBrand(brand);
	product.setProductPrice(productPrice);
	product.setProductDesc(productDesc);
	product.setCategory(category);
	product.setProductStatus(productStatus);
	product.setQuantity(quantity);
	
	boolean result = service.addProduct(product);
	if(result){
		return "redirect:productList.shop";
	}
	return "Error";
}

}
