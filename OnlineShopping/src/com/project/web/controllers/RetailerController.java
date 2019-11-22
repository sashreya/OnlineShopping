package com.project.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.core.entities.Retailer;
import com.project.core.exception.OsException;
import com.project.core.services.RetailerService;

@Controller
public class RetailerController {
	
	@Autowired
	private RetailerService rservice;
	
	public RetailerController() {
		System.out.println("Loading RetailerController");
	}
	
	
	//private Retailer ret;
	
	///http://localhost:9090/OnlineShopping/cust.shop
	/*@RequestMapping("cust.shop")	
	public ModelAndView getRetailerList() throws OsException  {
		String jspName = "Cust";
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName(jspName);
		return mAndV;
	}*/

	//http://localhost:9090/OnlineShopping/retailerRegistration.shop
	@RequestMapping(value="retailerRegistration.shop", method=RequestMethod.GET)
	public String registerRetailerPage(){
		return "RetailerRegistration";
	}
	
	@RequestMapping(value="retailerRegistration.shop", method=RequestMethod.POST)
	public String addRetailer(@RequestParam("retailerId") int retailerId,@RequestParam("retailerName") String retailerName, @RequestParam("retailerPhoneNumber") long retailerPhoneNumber,@RequestParam("retailerAddress") String retailerAddress,@RequestParam("retailerPassword") String retailerPassword,@RequestParam("retailerStatus") int retailerStatus,@RequestParam("retailerMail") String retailerMail) throws OsException
	{
		Retailer ret= new Retailer();
		ret.setRetailerId(retailerId);
		ret.setRetailerName(retailerName);
		ret.setRetailerPhoneNumber(retailerPhoneNumber);
		ret.setRetailerAddress(retailerAddress);
		ret.setRetailerStatus(retailerStatus);
		ret.setRetailerMail(retailerMail);
		ret.setRetailerPassword(retailerPassword);
		
		boolean result = rservice.addRetailer(ret);
		if(result){
			//return "AddProduct";
			return "redirect:retaillogin.shop";
		}
		return "Error";
	}

	//http://localhost:9090/OnlineShopping/retaillogin.shop
	@RequestMapping(path="retaillogin.shop", method=RequestMethod.GET)
	public String LoginRetailerPage(){
		return "RetailLogin";
	}
	
	@RequestMapping(path="retaillogin.shop", method=RequestMethod.POST)
	public String Retailerlogin(@RequestParam("retailerMail")String retailerMail ,@RequestParam("retailerPassword")String retailerPassword)
	{
		Retailer ret= rservice.loginRetailer(retailerMail);
		if(ret.getRetailerMail().contentEquals(retailerMail)) {
			if(ret.getRetailerPassword().contentEquals(retailerPassword)) {
				return "AddProduct";
			}
			else {
				return "RetailLogin";
			}
		}
		else {
			return "RetailLogin";
		}
	}
}
