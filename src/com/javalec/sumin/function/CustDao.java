package com.javalec.sumin.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.common.ShareVar;

public class CustDao {
	// Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;
	
	String custid;
	String custpw;
	String custname;
	String phone;
	String address;
	String actdate;
	String dactdate;
	
	// Constructor
	public CustDao() {
		
	}

	// 회원정보 불러오기.
	public ArrayList<CustDto> selectCustList(int index, String val){
		String where = "";
		ArrayList<CustDto> dtoList = new ArrayList<CustDto>();
		String whereDefault = "SELECT custid, custpw, custname, phone, address, actdate, dactdate FROM customer ";
		switch (index) {	
			case 0 : where = "WHERE custname like '%" + val + "%'";	break;	//"이름"
			case 1 : where = "WHERE phone like '%" + val + "%'"; 		break;	//"전화번호" 	
			case 2 : where = "WHERE custid like '%" + val + "%'"; 		break;	//"회원아이디"
			default : break;
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault+where);
			while(rs.next()) {	
				String wCustid = rs.getString(1);
				String wCustpw = rs.getString(2);
				String wCustname = rs.getString(3);
				String wPhone = rs.getString(4);
				String wAddress = rs.getString(5);
				String wActdate = rs.getString(6);
				String wDactdate = rs.getString(7);
				
				CustDto custDto = new CustDto(wCustid, wCustpw, wCustname, wPhone, wAddress, wActdate, wDactdate);
				dtoList.add(custDto);
				
			}
			conn_mysql.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return dtoList;
	}
}
