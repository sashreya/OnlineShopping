package com.project.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.core.entities.Employee;
import com.project.core.exception.EmpException;
import com.project.core.services.EmpService;



//http://localhost:8082/OnlineShopping/home.hr
@Controller
public class EmpController {
	
	@Autowired
	//todo please fix this error
	private EmpService service;
	

	@RequestMapping("home.shop")
	public ModelAndView getHomepage() {	//controller method
		String company="L and T Infotech";
		String jspName = "HomePage";
		
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("companyName", company);
		mAndV.setViewName(jspName);
		return mAndV;
	}
	
//http://localhost:9090/Spring080_MvcSpringJPA/empList.hr
	@RequestMapping("empList.shop")			//every method should have a different url
	public ModelAndView getEmpList() throws EmpException {
		List<Employee> empList = service.showAllEmps();		
		String jspName = "EmpList";
		
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("empList", empList);
		mAndV.setViewName(jspName);
		return mAndV;
	}
	
	
	  //http://localhost:9090/Spring080_MvcSpringJPA/empDetails.hr?id=120
	  
	  @RequestMapping("empDetails.shop") //every method should have a different url
	  public ModelAndView getEmpDetails(@RequestParam("id") int empId) throws
	  EmpException { System.out.println(empId); 
	  Employee emp =service.showEmployeeOnId(empId); String jspName = "EmpDetails";
	  
	  ModelAndView mAndV = new ModelAndView(); mAndV.addObject("emp", emp);
	  mAndV.setViewName(jspName);
	  
	  return mAndV; }
	 
}
