package com.javalec.sumin.function;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.common.ShareVar;


public class MyOrdersDao {
	//Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;
	
	int purnum;
	String custid;
	String stomodelnum;
	int purqty;
	int purprice;
	String purdate;
	
	
	
	public MyOrdersDao() {
		// TODO Auto-generated constructor stub
	}



	//Constructor

	public MyOrdersDao(int purnum, String custid, String stomodelnum, int purqty, int purprice, String purdate) {
		super();
		this.purnum = purnum;
		this.custid = custid;
		this.stomodelnum = stomodelnum;
		this.purqty = purqty;
		this.purprice = purprice;
		this.purdate = purdate;
	}
	
	

	
	//Method 
	
	//검색 결과를 Table 로 보내자 
		public ArrayList<MyOrdersDto> selectList() {
			ArrayList<MyOrdersDto> dtoList = new ArrayList<MyOrdersDto>(); 
			String whereDefault = "select purnum, custid, stomodelnum, purqty, purprice, purdate from purchase";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement(); 
				
				ResultSet rs = stmt_mysql.executeQuery(whereDefault);
				
				
				while(rs.next()) {
					int purnum = rs.getInt(1);
					String custid = rs.getString(2);
					String stomodelnum = rs.getString(3);
					int purqty = rs.getInt(4);
					int purprice = rs.getInt(5);
					String purdate = rs.getString(6);
					
					MyOrdersDto myPageDto =  new MyOrdersDto(purnum, custid, stomodelnum, purqty, purprice, purdate);
					dtoList.add(myPageDto); 
							
				}
				conn_mysql.close();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return dtoList; 
			
			
		}




	
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
