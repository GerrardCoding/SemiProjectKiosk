package com.javalec.sumin.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.common.ShareVar;
import com.javalec.sujin.ProductDto;

public class AdminDao {
	// Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;
	
	int purnum;
	String custid;
	String stomodelnum;
	int purqty;
	int purprice; 
	String purdate;
	
	// Constructor
	public AdminDao() {
		
	}

	public AdminDao(String purdate) {
		super();
		this.purdate = purdate;
	}

	// Method
	// 오늘 매출 불러오기.
	public ArrayList<AdminDto> selectTodayList(){
		ArrayList<AdminDto> dtoList = new ArrayList<AdminDto>();
		String whereDefault = "SELECT purnum, custid, stomodelnum, purqty, purprice, purdate FROM purchase";
		String where = " WHERE purdate = '"+ purdate +"'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault+where);
			while(rs.next()) {	
				int wPurnum = rs.getInt(1);
				String wCustid = rs.getString(2);
				String wStomodelnum = rs.getString(3);
				int wPurqty = rs.getInt(4);
				int wPurprice = rs.getInt(5);
				String wPurdate = rs.getString(6);
				
				AdminDto adminDto = new AdminDto(wPurnum, wCustid, wStomodelnum, wPurqty, wPurprice, wPurdate);
				dtoList.add(adminDto);
				
			}
			conn_mysql.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return dtoList;
	}
}
