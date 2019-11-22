package com.project.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.ScrollableResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.core.entities.Customer;
import com.project.core.entities.Product;
import com.project.core.exception.CustException;
import com.project.core.exception.OsException;
import com.project.core.services.CustomerService;

import oracle.net.ano.Service;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService cservice;
	
	@Autowired
	private Customer cust;
	
	//http://localhost:9090/OnlineShopping/cust.shop
	@RequestMapping("cust.shop")	
	public ModelAndView getCustomerList() throws CustException  {
		//List<Customer> custList = cservice.showAllCustomer();
		String jspName = "Cust";
		ModelAndView mAndV = new ModelAndView();
		//mAndV.addObject("customerList", custList);
		mAndV.setViewName(jspName);
		return mAndV;
	}

	@RequestMapping(path="/")
	public String homePage(){
		return "Home";
	}
	
	//http://localhost:9090/OnlineShopping/registration.shop
	@RequestMapping(path="registration.shop", method=RequestMethod.GET)
	public String registerCustomerPage(){
		return "Registration";
	}
	
	@RequestMapping(path="registration.shop", method=RequestMethod.POST)
	public String addCustomer(@RequestParam("customerId") int customerId,@RequestParam("customerName") String customerName, @RequestParam("customerPhoneNumber") long customerPhoneNumber,@RequestParam("customerMail") String customerMail,@RequestParam("customerAddress") String customerAddress,@RequestParam("customerPassword") String customerPassword) throws CustException
	{
		cust = new Customer();
		cust.setCustomerId(customerId);
		cust.setCustomerName(customerName);
		cust.setCustomerPhoneNumber(customerPhoneNumber);
		cust.setCustomerMail(customerMail);
		cust.setCustomerAddress(customerAddress);
		cust.setCustomerPassword(customerPassword);
		
		boolean result = cservice.addCustomer(cust);
		if(result){
			return "redirect:cust.shop";
		}
		return "Error";
	}
	/*
	 * private static int queryTatalCountByScrollableResults(Query query) {
	 * ScrollableResults scrollableResults = query.scroll();
	 * scrollableResults.last(); return scrollableResults.getRowNumber() + 1; }
	 */

	//http://localhost:9090/OnlineShopping/login.shop
	@RequestMapping(path="login.shop", method=RequestMethod.GET)
	public String LoginCustomerPage(){
		return "Login";
	}
	
	@RequestMapping(path="login.shop", method=RequestMethod.POST)
	public String login(@RequestParam("customerMail")String customerMail ,@RequestParam("customerPassword")String customerPassword,HttpSession session,HttpServletRequest request)
	{
		//Customer cust2 = new Customer();
		//cust2.setCustomerMail(customerMail);
		//cust2.setCustomerPassword(customerPassword);
		Customer cust = cservice.loginCustomer(customerMail);
		if(cust.getCustomerPassword().contentEquals(customerPassword)) {
			return "Login Sussessful";
		}
		else {
			return "Login Unsussful";
		}
		/*model.put(key, value)("cus",register);
		String user=register.getCustomerMail();
		String pass=register.getCustomerPassword();
		 Boolean var=cservice.loginCustomer(customerMail, customerPassword);
		
		
		for(int i=0; i<)
		if(user.equals(anObject))
		return password;*/
	}

}
