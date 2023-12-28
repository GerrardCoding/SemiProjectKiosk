package com.javalec.daegeun;

public class SignLoginDto {

	// Filed
	String custid;
	String custpw;
	String custname;
	String phone;
	String address;
	
	// Constructor
	public SignLoginDto() {
		// TODO Auto-generated constructor stub
	}

	public SignLoginDto(String custid) {
		super();
		this.custid = custid;
	}

	public SignLoginDto(String custid, String custpw) {
		super();
		this.custid = custid;
		this.custpw = custpw;
	}

	public SignLoginDto(String custid, String custpw, String custname, String phone, String address) {
		super();
		this.custid = custid;
		this.custpw = custpw;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
	}


	// Method
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
	
	
}
