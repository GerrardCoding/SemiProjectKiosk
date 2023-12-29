package com.javalec.daegeun;

public class AdminDto {

	// Filed
	String adminid;
	String adminpw;
	String adminname;

	// Constructor
	public AdminDto() {
		// TODO Auto-generated constructor stub
	}

	public AdminDto(String adminid, String adminpw) {
		super();
		this.adminid = adminid;
		this.adminpw = adminpw;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAdminpw() {
		return adminpw;
	}

	public void setAdminpw(String adminpw) {
		this.adminpw = adminpw;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	
	
	
	
	
}
