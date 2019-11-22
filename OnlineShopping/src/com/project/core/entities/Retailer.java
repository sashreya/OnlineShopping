package com.project.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="retailer")
@Table(name="retailer")
public class Retailer {
	@Id
	@Column(name="RETAILERID")
	private int retailerId;
	@Column(name="RETAILERNAME")
	private String retailerName;
	@Column(name="RETAILERPHONENUMBER")
	private long retailerPhoneNumber;
	@Column(name="RETAILERADDRESS")
	private String retailerAddress;

	@Column(name="RETAILERSTATUS")
	private int retailerStatus;
	@Column(name="RETAILERMAIL")
	private String retailerMail;
	@Column(name="RETAILERPASSWORD")
	private String retailerPassword;

	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	public String getRetailerName() {
		return retailerName;
	}
	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}
	public long getRetailerPhoneNumber() {
		return retailerPhoneNumber;
	}
	public void setRetailerPhoneNumber(long retailerPhoneNumber) {
		this.retailerPhoneNumber = retailerPhoneNumber;
	}
	public String getRetailerAddress() {
		return retailerAddress;
	}
	public void setRetailerAddress(String retailerAddress) {
		this.retailerAddress = retailerAddress;
	}
	public String getRetailerPassword() {
		return retailerPassword;
	}
	public void setRetailerPassword(String retailerPassword) {
		this.retailerPassword = retailerPassword;
	}
	public int getRetailerStatus() {
		return retailerStatus;
	}
	public void setRetailerStatus(int retailerStatus) {
		this.retailerStatus = retailerStatus;
	}
	
	public String getRetailerMail() {
		return retailerMail;
	}
	public void setRetailerMail(String retailerMail) {
		this.retailerMail = retailerMail;
	}
	public Retailer() {
		super();
	}
		
	public Retailer(int retailerId, String retailerName, long retailerPhoneNumber, String retailerAddress,
			String retailerPassword, int retailerStatus) {
		super();
		this.retailerId = retailerId;
		this.retailerName = retailerName;
		this.retailerPhoneNumber = retailerPhoneNumber;
		this.retailerAddress = retailerAddress;
		this.retailerPassword = retailerPassword;
		this.retailerStatus = retailerStatus;
		this.retailerMail=retailerMail;
	}
	@Override
	public String toString() {
		return "Retailer [retailerId=" + retailerId + ", retailerName=" + retailerName + ", retailerPhoneNumber="
				+ retailerPhoneNumber + ", retailerAddress=" + retailerAddress + ", retailerStatus=" + retailerStatus
				+ ", retailerMail=" + retailerMail + ", retailerPassword=" + retailerPassword + "]";
	}
	
	
	

	
}
