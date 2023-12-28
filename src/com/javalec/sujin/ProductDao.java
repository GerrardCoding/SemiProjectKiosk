package com.javalec.sujin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.common.ShareVar;

public class ProductDao {
	
	// Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;
	
	int stoprice;
	int stoqty;
	int stosize;
	String modelnum;
	String brand;
	String modelname;
	String color;
	FileInputStream file;
	
	// Constructor
	public ProductDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	// Method
	
	public ProductDao(String modelnum) {
		super();
		this.modelnum = modelnum;
	}


	// 검색 결과를 Table로 보내자.
	public ArrayList<ProductDto> selectList(){
		ArrayList<ProductDto> dtoList = new ArrayList<ProductDto>();
		String whereDefault = "SELECT modelnum, brand, modelname, color, stosize, stoqty, stoprice FROM store";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			while(rs.next()) {	
				String wMdelnum = rs.getString(1);
				String wBrand = rs.getString(2);
				String wModelname = rs.getString(3);
				String wColor = rs.getString(4);
				int wStosize = rs.getInt(5);
				int wStoqty = rs.getInt(6);
				int wStoprice = rs.getInt(7);
				
				ProductDto productDto = new ProductDto(wMdelnum, wBrand, wModelname, wColor, wStosize, wStoqty, wStoprice);
				dtoList.add(productDto);
				
			}
			conn_mysql.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	
	// Table을 Click 하였을 경우
	public ProductDto tableClick() {
		ProductDto dto = null;
		String where1 = "SELECT modelnum, brand, modelname, color, stosize, stoqty, stoprice, file FROM store";
		String where2 = " where modelnum = '"+ modelnum + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where1+where2);
			if(rs.next()) {
				String wMdelnum = rs.getString(1);
				String wBrand = rs.getString(2);
				String wModelname = rs.getString(3);
				String wColor = rs.getString(4);
				int wStosize = rs.getInt(5);
				int wStoqty = rs.getInt(6);
				int wStoprice = rs.getInt(7);
				
				// File  그림 파일을 하나만들어준다.
				ShareVar.filename = ShareVar.filename +1 ;
				File file = new File(Integer.toString(ShareVar.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(8);
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0 ) {
					output.write(buffer);
				}
				
				dto = new ProductDto(wMdelnum, wBrand, wModelname, wColor, wStosize, wStoqty, wStoprice);
				
			}
			conn_mysql.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dto;
	}
}
