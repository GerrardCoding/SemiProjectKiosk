package com.javalec.sumin.function;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	public MyOrdersDao(int purnum, String custid, String stomodelnum, int purqty, int purprice) {
		super();
		this.purnum = purnum;
		this.custid = custid;
		this.stomodelnum = stomodelnum;
		this.purqty = purqty;
		this.purprice = purprice;
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

		
		public int getMaxPurnum() {
			int maxpurnum = 0;
			String whereDefault = "SELECT MAX(purnum) FROM purchase";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement(); 
				
				ResultSet rs = stmt_mysql.executeQuery(whereDefault);
				
				
				while(rs.next()) {
					maxpurnum = rs.getInt(1);
				}
				conn_mysql.close();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return maxpurnum;
		}

		//결제했을 경우 결제한 값이 PURCHASE data 로 이동한다
		
		
		public boolean insertAction() { 
			PreparedStatement ps = null; 
			
			try { 
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement(); 
				
				String A = "insert into purchase (purnum, custid, stomodelnum, purqty, purprice, purdate";
				String B = ") values (?,?,?,?,?,sysdate())";
				
				
				ps = conn_mysql.prepareStatement(A+B); 
				ps.setInt(1, purnum);
				ps.setString(2, custid);
				ps.setString(3, stomodelnum);
				ps.setInt(4,  purqty);
				ps.setInt(5,  purprice);	
				ps.executeUpdate();
				
				conn_mysql.close();
	
			
			}catch(Exception e) {
				e.printStackTrace(); 
				return false;
			}
				return true; 
		
		}

	
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
