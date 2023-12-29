package com.javalec.sumin.function;

public class AdminDto {
	// Field
	int purnum;
	String custid;
	String stomodelnum;
	int purqty;
	int purprice; 
	String purdate;
	
	// Constructor
	public AdminDto() {
		
	}
	
	public AdminDto(int purnum, String custid, String stomodelnum, int purqty, int purprice, String purdate) {
		super();
		this.purnum = purnum;
		this.custid = custid;
		this.stomodelnum = stomodelnum;
		this.purqty = purqty;
		this.purprice = purprice;
		this.purdate = purdate;
	}

	// Method
	public int getPurnum() {
		return purnum;
	}

	public void setPurnum(int purnum) {
		this.purnum = purnum;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getStomodelnum() {
		return stomodelnum;
	}

	public void setStomodelnum(String stomodelnum) {
		this.stomodelnum = stomodelnum;
	}

	public int getPurqty() {
		return purqty;
	}

	public void setPurqty(int purqty) {
		this.purqty = purqty;
	}

	public int getPurprice() {
		return purprice;
	}

	public void setPurprice(int purprice) {
		this.purprice = purprice;
	}

	public String getPurdate() {
		return purdate;
	}

	public void setPurdate(String purdate) {
		this.purdate = purdate;
	}
	
	
}
