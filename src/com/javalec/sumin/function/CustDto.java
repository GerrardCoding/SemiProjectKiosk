package com.javalec.sumin.function;

public class CustDto {
	// Field
	String custid;
	String custpw;
	String custname;
	String phone;
	String address;
	String actdate;
	String dactdate;
	
	// Constructor
	public CustDto() {
		
	}

	// Method
	public CustDto(String custid, String custpw, String custname, String phone, String address, String actdate,
			String dactdate) {
		super();
		this.custid = custid;
		this.custpw = custpw;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.actdate = actdate;
		this.dactdate = dactdate;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getCustpw() {
		return custpw;
	}

	public void setCustpw(String custpw) {
		this.custpw = custpw;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getActdate() {
		return actdate;
	}

	public void setActdate(String actdate) {
		this.actdate = actdate;
	}

	public String getDactdate() {
		return dactdate;
	}

	public void setDactdate(String dactdate) {
		this.dactdate = dactdate;
	}

}
