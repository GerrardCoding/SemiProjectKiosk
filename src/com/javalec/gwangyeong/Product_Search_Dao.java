package com.javalec.gwangyeong;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Product_Search_Dao {
	
	// Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;
	
	String modelnum;
	String brand;
	String modelname;
	String color;
	int stosize;
	
//	String filename;
//	
//	FileInputStream file;
	
	String searchName;
	String searchText;
	DefaultTableModel table;
	
	
	// Constructor
	public Product_Search_Dao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Product_Search_Dao(String modelnum) {
		super();
		this.modelnum = modelnum;
	}
	
	
	public Product_Search_Dao(String searchName, String searchText, DefaultTableModel table) {
		super();
		this.searchName = searchName;
		this.searchText = searchText;
		this.table = table;
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------------------
	
	// Method
	
	// 검색 결과를 Talbe로 보내자.
	public ArrayList<Product_Search_Dto> selectList() {
		
		ArrayList<Product_Search_Dto> dtoList = new ArrayList<Product_Search_Dto>();
		String where1 = "select modelnum, brand, modelname, color, stosize from store ";
		String where2 = "order by modelnum asc";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where1 + where2);
			
			while(rs.next()) {
				
				String wkModelnum = rs.getString(1);
				String wkBrand = rs.getString(2);
				String wkModelname = rs.getString(3);
				String wkColor = rs.getString(4);
				int wkStosize = rs.getInt(5);
//				String wkFilename = rs.getString(6);
				
//				// File
//				File file = new File("./" + wkFilename);
//				FileOutputStream output = new FileOutputStream(file);
//				InputStream input = rs.getBinaryStream(1);
//				
//				byte[] buffer = new byte[1024];
//				
//				while(input.read(buffer) > 0) {
//					output.write(buffer);
//				}
				
				Product_Search_Dto dto = new Product_Search_Dto(wkModelnum, wkBrand, wkModelname, wkColor, wkStosize);
				dtoList.add(dto);
				
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
		
		
	}
	
	
	// Table 내 조건별 Data를 검색한다.
	public void conditionSearchAction() {
		
		String query1 = "select modelnum, brand, modelname, color, stosize from store where " + searchName;
		String query2 = " like '%" + searchText + "%'";
		String query3 = " order by " + searchName + " asc;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			
			ResultSet rs = stmt_mysql.executeQuery(query1 + query2 + query3);
			while(rs.next()) {
				String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), Integer.toString(rs.getInt(5))};
				table.addRow(qTxt);
			}
			
			
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return;
		
		
	}
	
	
	// Table을 Click 하였을 경우
	public Product_Search_Dto tableClick() {
		
		Product_Search_Dto dto = null;
		
		String where1 = "select modelname, stoprice, modelnum, brand, color, stosize, stoqty from store";
		String where2 = " where modelnum = '" + modelnum + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where1 + where2);
			
			if(rs.next()) {
				String wkModelname = rs.getString(1);
				int wkStoprice = rs.getInt(2);
				String wkModelnum = rs.getString(3);
				String wkBrand = rs.getString(4);
				String wkColor = rs.getString(5);
				int wkStosize = rs.getInt(6);
				int wkStoqty = rs.getInt(7);
				
				dto = new Product_Search_Dto(wkModelnum, wkBrand, wkModelname, wkColor, wkStosize, wkStoprice, wkStoqty);
				
			}
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
		
		
	}
	
	
	
}
