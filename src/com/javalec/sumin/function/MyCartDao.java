package com.javalec.sumin.function;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.common.ShareVar;

public class MyCartDao {
	
	//Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;
	
	int cartseqno;
	int stoprice; 
	String color; 
	String modelnum;
	int stosize;
	int cartqty;
	FileInputStream file;

	
	public MyCartDao() {
		// TODO Auto-generated constructor stub
	}



	//Constructor

	public MyCartDao(int cartseqno, int stoprice, String color, String modelnum, int stosize, int cartqty) {
		super();
		this.cartseqno = cartseqno;
		this.stoprice = stoprice;
		this.color = color;
		this.modelnum = modelnum;
		this.stosize = stosize;
		this.cartqty = cartqty;
	}



	public MyCartDao(int cartseqno) {
		super();
		this.cartseqno = cartseqno;
	}


	
	public MyCartDao(String modelnum) {
		super();
		this.modelnum = modelnum;
	}


	//Method
	
	
	
		//검색 결과를 Table 로 보내자 

		public ArrayList<MyCartDto> selectList() {
		ArrayList<MyCartDto> dtoList = new ArrayList<MyCartDto>(); 
		String where1 = "select c.cartseqno, s.modelnum, s.stosize, c.cartqty, s.stoprice, s.color  from cart c, store s where c.stomodelnum = s.modelnum ";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			ResultSet rs = stmt_mysql.executeQuery(where1);
			
			
			while(rs.next()) {
				int cartseqno = rs.getInt(1);
				String modelnum = rs.getString(2); 
				int stosize = rs.getInt(3);
				int cartqty = rs.getInt(4);
				int stoprice = rs.getInt(5); 
				String color = rs.getString(6);
	
				
				
				MyCartDto myCartDto =  new MyCartDto (cartseqno, modelnum, stosize, cartqty, stoprice, color);
				dtoList.add(myCartDto); 
						
			}
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dtoList; 				
	}
		

		//Table 을 Click 하였을 경우 
			
		public MyCartDto tableClick() {
			MyCartDto myCartDto = null; 
			String where = "SELECT c.cartseqno, s.modelnum, s.stosize, c.cartqty, s.stoprice, s.color, s.file  FROM cart c, store s WHERE c.stomodelnum = s.modelnum ";
			String where1 = " and s.modelnum = '"+ modelnum + "'";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement(); 
				
				ResultSet rs = stmt_mysql.executeQuery(where+where1); 
				if(rs.next()) {
					int cartseqno = rs.getInt(1);
					String modelnum = rs.getString(2); 
					int stosize = rs.getInt(3);
					int cartqty = rs.getInt(4);
					int stoprice = rs.getInt(5); 
					String color = rs.getString(6);
					
				// File  그림 파일을 하나만들어준다.
					ShareVar.filename = ShareVar.filename +1 ;
					File file = new File(Integer.toString(ShareVar.filename));
					FileOutputStream output = new FileOutputStream(file);
					InputStream input = rs.getBinaryStream(7);
					byte[] buffer = new byte[1024];
					while(input.read(buffer) > 0 ) {
						output.write(buffer);
					}
		
					myCartDto = new MyCartDto(cartseqno, modelnum, stosize, cartqty, stoprice, color);
					
				}
				conn_mysql.close();
		
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		
			return myCartDto; 						
		}
	
		
		//삭제할 경우 
		
		public boolean deleteAction() {
			PreparedStatement ps = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement(); 
				
				String A = "delete from cart ";
				String B = " where cartseqno = ?";
				
				
				ps = conn_mysql.prepareStatement(A+B);
				ps.setInt(1, cartseqno);
				ps.executeUpdate(); 
				
				conn_mysql.close();
				
				
				
			}catch(Exception e) {
				return false; 
			}
			
			return true; 		
		}
	
		
		//결제할 경우 해당 아이탬 삭제 
		
		public boolean deleteCart() {
			PreparedStatement ps = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement(); 
				
				String A = "delete from cart ";
								
				ps = conn_mysql.prepareStatement(A);
				ps.executeUpdate(); 
				
				conn_mysql.close();
				
			}catch(Exception e) {
				return false; 
			}
			
			return true; 
			
		}

		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	

}
