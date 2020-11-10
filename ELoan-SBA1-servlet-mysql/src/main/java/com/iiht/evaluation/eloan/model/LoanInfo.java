package com.iiht.evaluation.eloan.model;

public class LoanInfo {
	private String ApplicationNumber;
	 private   String LoanName;
	 private   String LoanAmount;
	 private   String ApplicationDate;
	 private   String BusinessStructure;
	 private   String BillingIndicator;
	 private   String TaxPayer;
	 private   String ContactAddress;
	 private   String ContactNumber;
	 private  String Email;
	 private String LoanNumber;
	public String getLoanNumber() {
		return LoanNumber;
	}
	public void setLoanNumber(String loanNumber) {
		LoanNumber = loanNumber;
	}
	// private static String status;
	 public LoanInfo() 
	 {
		 
	 }
	public   String getApplicationNumber() {
		return ApplicationNumber;
	}
	public   void setApplicationNumber(String applicationNumber) {
		ApplicationNumber = applicationNumber;
	}
	public   String getLoanName() {
		return LoanName;
	}
	public   void setLoanName(String loanName) {
		LoanName = loanName;
	}
	public   String getLoanAmount() {
		return LoanAmount;
	}
	public   void setLoanAmount(String loanAmount) {
		LoanAmount = loanAmount;
	}
	public   String getApplicationDate() {
		return ApplicationDate;
	}
	public   void setApplicationDate(String applicationDate) {
		ApplicationDate = applicationDate;
	}
	public   String getBusinessStructure() {
		return BusinessStructure;
	}
	public   void setBusinessStructure(String businessStructure) {
		BusinessStructure = businessStructure;
	}
	public   String getBillingIndicator() {
		return BillingIndicator;
	}
	public   void setBillingIndicator(String billingIndicator) {
		BillingIndicator = billingIndicator;
	}
	public   String getTaxPayer() {
		return TaxPayer;
	}
	public   void setTaxPayer(String taxPayer) {
		TaxPayer = taxPayer;
	}
	public   String getContactAddress() {
		return ContactAddress;
	}
	public   void setContactAddress(String contactAddress) {
		ContactAddress = contactAddress;
	}
	public   String getContactNumber() {
		return ContactNumber;
	}
	public   void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	 
	public LoanInfo(String ApplicationNumber, String LoanName, String LoanAmount,String ApplicationDate, 
			String BusinessStructure, String BillingIndicator, String TaxPayer, String ContactAddress, String ContactNumber, String Email, String LoanNumber) {
		super();
		this.ApplicationNumber = ApplicationNumber;
		this.LoanName = LoanName;
		this.LoanAmount = LoanAmount;
		this.ApplicationDate = ApplicationDate;
		this.BusinessStructure = BusinessStructure;
		this.BillingIndicator = BillingIndicator;
		this.TaxPayer = TaxPayer;
		this.ContactAddress = ContactAddress;
		this.ContactNumber = ContactNumber;
		this.Email = Email;
		this.LoanNumber = LoanNumber;
	}
	 

	
	
	

}
