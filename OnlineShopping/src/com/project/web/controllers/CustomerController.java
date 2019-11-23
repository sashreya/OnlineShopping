package com.project.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.core.entities.Customer;
import com.project.core.exception.CustException;
import com.project.core.services.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService cservice;
	
	//@Autowired
	//private Customer cust;
	
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

	
	  @RequestMapping(path="/") public String homePage(){ return "Home"; }
	 
	//http://localhost:8756/OnlineShopping/registration.shop
	@RequestMapping(path="registration.shop", method=RequestMethod.GET)
	public String registerCustomerPage(){
		return "Registration";
	}
	
	@RequestMapping(path="registration.shop", method=RequestMethod.POST)
	public String addCustomer(@RequestParam("customerId") int customerId,@RequestParam("customerName") String customerName, @RequestParam("customerPhoneNumber") long customerPhoneNumber,@RequestParam("customerMail") String customerMail,@RequestParam("customerAddress") String customerAddress,@RequestParam("customerPassword") String customerPassword) throws CustException
	{
		Customer cust = new Customer();
		cust.setCustomerId(customerId);
		cust.setCustomerName(customerName);
		cust.setCustomerPhoneNumber(customerPhoneNumber);
		cust.setCustomerMail(customerMail);
		cust.setCustomerAddress(customerAddress);
		cust.setCustomerPassword(customerPassword);
		
		boolean result = cservice.addCustomer(cust);
		if(result){
			//return "redirect:cust.shop";
			return "redirect:login.shop";
		}
		return "record not inserted";
	}
	
	//`
	@RequestMapping(path="login.shop", method=RequestMethod.GET)
	public String LoginCustomerPage(){
		return "Login";
	}
	
	@RequestMapping(path="login.shop", method=RequestMethod.POST)
	public String login(@RequestParam("customerMail")String customerMail ,@RequestParam("customerPassword")String customerPassword,HttpSession session,HttpServletRequest request)
	{
		Customer cust = cservice.loginCustomer(customerMail);
		if(cust.getCustomerMail().contentEquals(customerMail)) {
			if(cust.getCustomerPassword().contentEquals(customerPassword)) {
				return "Home";
			}
			else {
				return "Login";
			}
		}
		else
		{
			return "username wrong";
		}		
	}
	@RequestMapping(path="forgetPass.shop", method = RequestMethod.GET)
	public String forgotPassword() {
		return "forgetPassword";
	}
	@RequestMapping(path="forgetPass.shop", method=RequestMethod.POST)
	public String forgetPass(@RequestParam("customerMail")String customerMail ,@RequestParam("customerPassword")String customerPassword)
	{		
		int result = cservice.ForgetPassword(customerMail, customerPassword);
		if(result>0){
			return "redirect:login.shop";
		}
		return "password not updated";
		
		
	}
}
