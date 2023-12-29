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
	
	
	int stgseqno;
	String stomodelnum;
	int stgsize;
	int stgqty;
	String stgdate; 

	
	
	
	public MyOrdersDao() {
		// TODO Auto-generated constructor stub
	}



	//Constructor
	
	public MyOrdersDao(int stgseqno, String stomodelnum, int stgsize, int stgqty, String stgdate) {
		super();
		this.stgseqno = stgseqno;
		this.stomodelnum = stomodelnum;
		this.stgsize = stgsize;
		this.stgqty = stgqty;
		this.stgdate = stgdate;
		
	}
	

	
	//Method 
	
	//검색 결과를 Table 로 보내자 
		public ArrayList<MyOrdersDto> selectList() {
			ArrayList<MyOrdersDto> dtoList = new ArrayList<MyOrdersDto>(); 
			String whereDefault = "select stgseqno, stomodelnum, stgsize, stgqty, stgdate from orders";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement(); 
				
				ResultSet rs = stmt_mysql.executeQuery(whereDefault);
				
				
				while(rs.next()) {
					int stgseqno = rs.getInt(1);
					String stomodelnum = rs.getString(2);
					int stgsize = rs.getInt(3);
					int stgqty = rs.getInt(4);
					String stgdate = rs.getString(5);
					
					MyOrdersDto myPageDto =  new MyOrdersDto(stgseqno, stomodelnum, stgsize, stgqty, stgdate);
					dtoList.add(myPageDto); 
							
				}
				conn_mysql.close();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return dtoList; 
			
			
		}
	

	
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
