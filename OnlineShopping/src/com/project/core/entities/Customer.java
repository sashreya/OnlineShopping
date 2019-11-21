package com.project.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
@Entity(name="customer")
public class Customer {
	@Id
	@Column(name="CUSTOMERID")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	@Column(name="CUSTOMERNAME")
	private String customerName;
	@Column(name="CUSTOMERPHONENUMBER")
	private long customerPhoneNumber;
	@Column(name="CUSTOMERMAIL")
	private String customerMail;
	@Column(name="CUSTOMERADDRESS")
	private String customerAddress;
	@Column(name="CUSTOMERPASSWORD")
	private String customerPassword;

	public Customer() {
		super();
	}
	
	
	public Customer(int customerId, String customerName, long customerPhoneNumber, String customerMail,
			String customerAddress, String customerPassword) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerMail = customerMail;
		this.customerAddress = customerAddress;
		this.customerPassword = customerPassword;
	}
	
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(long customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public String getCustomerMail() {
		return customerMail;
	}
	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPhoneNumber="
				+ customerPhoneNumber + ", customerMail=" + customerMail + ", customerAddress=" + customerAddress
				+ ", customerPassword=" + customerPassword + "]";
	}
}
