package com.javalec.daegeun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.common.ShareVar;

public class AccountDao {

	// Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;

	String custid;
	String custpw;
	String custname;
	String phone;
	String address;
	String deactivate;
	
	// Constructor
	public AccountDao() {
		// TODO Auto-generated constructor stub
	}

	public AccountDao(String custid, String custpw, String custname, String phone, String address, String deactivate) {
		super();
		this.custid = custid;
		this.custpw = custpw;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.deactivate = deactivate;
	}
	
	public AccountDao(String custid, String custname, String phone, String address, String deactivate) {
		super();
		this.custid = custid;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.deactivate = deactivate;
	}

	// Method
	// 검색 결과를 Table로 보내자
		public ArrayList<AccountDto> selectList() {
			ArrayList<AccountDto> dtoList = new ArrayList<AccountDto>();
			String whereDefault = "select custid, custname, phone, address, deactivate from customer";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
				
				ResultSet rs = stmt_mysql.executeQuery(whereDefault);
				
				while(rs.next()) {
					String wkCustid = rs.getString(1);
					String wkCustname = rs.getString(2);
					String wkPhone = rs.getString(3);
					String wkAddress = rs.getString(4);
					String wkDeactive = rs.getString(5);
					
					AccountDto AccountDto = new AccountDto(wkCustid, wkCustname, wkPhone, wkAddress, wkDeactive);
					dtoList.add(AccountDto);
				}
				conn_mysql.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return dtoList;
		}
	
	
	
}
