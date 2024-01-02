package com.javalec.daegeun;

import com.javalec.common.ShareVar;

public class AccountDto {

	// Field
	String custid;
	String custpw;
	String custname;
	String phone;
	String address;
	String deactivate;
	
	// Constructor
	private void AccouuntDto() {
		// TODO Auto-generated method stub

	}

	public AccountDto(String custid, String custpw, String custname, String phone, String address, String deactivate) {
		super();
		this.custid = custid;
		this.custpw = custpw;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.deactivate = deactivate;
	}
	
	
	public AccountDto(String custid, String custname, String phone, String address, String deactivate) {
		super();
		this.custid = custid;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.deactivate = deactivate;
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

	public String getDeactivate() {
		return deactivate;
	}

	public void setDeactivate(String deactivate) {
		this.deactivate = deactivate;
	}
	
	
}
