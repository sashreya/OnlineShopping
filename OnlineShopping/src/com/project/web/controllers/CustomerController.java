package com.project.web.controllers;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@Autowired 
	JavaMailSender sender;	
	String emailSender="<SoleMates47@gmail.com>";
	
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

	
	//===========================================================================
	
	@RequestMapping(value="validate.shop", method=RequestMethod.GET)
	public String validateOtp( @RequestParam("otp2")String otp2,@RequestParam("customerPassword")String customerPassword, HttpSession session) {
		Object obj= session.getAttribute("otp");
		String mail = (String)session.getAttribute("customerMail");
		String otp=null;
		if(obj!=null) {
			 otp = obj.toString();
		}		
		if(otp.contentEquals(otp2))
		{
			int result = cservice.ForgetPassword(mail, customerPassword);
			if(result>0){
				return "redirect:login.shop";
			}
			else {
			return "password not updated";
			}
		}
		else
		{
			return "redirect:mail.shop";
		}
	}
	
	//===========================================================================
	//===========================================================================
	//http://localhost:8756/OnlineShopping/mail.shop
	
	  @RequestMapping(value="mail.shop", method = RequestMethod.GET) 
	  public String genOtp() 
	  { 
		  return "Otp"; 
	  }
	 
		
		@RequestMapping(value="mailotp.shop", method=RequestMethod.POST)
		public String sentOtp(Model model, @RequestParam("emailToRecipient") String emailToRecipient, HttpSession session ) {
			 
			int randomPin   =(int) (Math.random()*9000)+1000; 
		     String otp1  = String.valueOf(randomPin); 
		     
	        // Logging The Email Form Parameters For Debugging Purpose
	        //System.out.println("\nReceipient?= " + emailToRecipient + ", Subject?= " + emailSubject + ", Message?= " + emailMessage + "\n");
	 
	        sender.send(new MimeMessagePreparator() {
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	 
	                MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");             
	                mimeMsgHelperObj.setTo(emailToRecipient);
	                mimeMsgHelperObj.setFrom(emailSender);               
	                mimeMsgHelperObj.setText(otp1);
	                mimeMsgHelperObj.setSubject("Your OTP is: ");             
	            }
	        });
	        session.setAttribute("otp", otp1);
	        session.setAttribute("customerMail", emailToRecipient);
	        System.out.println("\nMessage Send Successfully.... Hurrey!\n");
	        model.addAttribute("msg","Mail Sent!");
	       return "forgetPassword";
		}
	//=================================================================================
}
