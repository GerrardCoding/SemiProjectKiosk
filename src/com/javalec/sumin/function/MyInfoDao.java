package com.javalec.sumin.function;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.common.ShareVar;

public class MyInfoDao {
	
	//FIELD
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;
	
	
	
	String custid; 
	String custpw;
	String custname;
	String phone;
	String address;
	
	

	public MyInfoDao() {
		// TODO Auto-generated constructor stub
	}



	
	//CONSTRUCTOR
	
	public MyInfoDao(String custid) {
		super();
		this.custid = custid;
	}




	public MyInfoDao(String custid, String custpw, String custname, String phone, String address) {
		super();
		this.custid = custid;
		this.custpw = custpw;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
	}
	

	
	//METHOD
	
	//고객 정보를 보내자 
	
	public MyInfoDto selectList() {
		MyInfoDto myInfoDto = null; 
		String where ="select custid, custpw, custname, phone, address from customer";
		String where1 = " WHERE custid = '"+ custid + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			ResultSet rs = stmt_mysql.executeQuery(where+where1); 
			if(rs.next()) {
				String custid = rs.getString(1); 
				String custpw = rs.getString(2); 
				String custname = rs.getString(3); 
				String phone = rs.getString(4); 
				String address = rs.getString(5); 
				
				
	
				myInfoDto = new MyInfoDto(custid, custpw, custname, phone, address);
				
						
			}
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return myInfoDto;
		
		
	}
	
	
	

	//고객 정보 수정
	public boolean updateAction() {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			String A = "update customer set custpw = ?, custname = ?, phone = ?, address = ? ";
			String B = " where custid = ?";
				
			
			ps = conn_mysql.prepareStatement(A+B);
			
			ps.setString(1, custpw);
			ps.setString(2, custname);
			ps.setString(3, phone);
			ps.setString(4, address);
			ps.setString(5, custid);
			ps.executeUpdate();
			
			conn_mysql.close();
			
		}catch(Exception e) {
			return false;
		}
		
		return true;	
	}


	
	//회원 탈퇴 
	public boolean deactivate() {
		PreparedStatement ps = null;
		System.out.println(custid);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			String A = "delete from customer";
			String B = " where custid = ?";
			
			
			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, custpw);
			
			ps.executeUpdate();
			
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
