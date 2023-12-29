package com.javalec.sumin.function;

import java.io.FileInputStream;

public class MyCartDto {
	
	//Field
	int cartseqno;
	String modelnum;
	int stosize;
	int cartqty;
	int stoprice; 
	String color; 
	FileInputStream file;
	
	//CONSTRUCTOR
	public MyCartDto() {
		// TODO Auto-generated constructor stub
	}
	



	public MyCartDto(int cartseqno) {
		super();
		this.cartseqno = cartseqno;
	}





	public MyCartDto(int cartseqno, String modelnum, int stosize, int cartqty, int stoprice, String color) {
		super();
		this.cartseqno = cartseqno;
		this.modelnum = modelnum;
		this.stosize = stosize;
		this.cartqty = cartqty;
		this.stoprice = stoprice;
		this.color = color;
	}




	public int getCartseqno() {
		return cartseqno;
	}




	public void setCartseqno(int cartseqno) {
		this.cartseqno = cartseqno;
	}




	public String getModelnum() {
		return modelnum;
	}




	public void setModelnum(String modelnum) {
		this.modelnum = modelnum;
	}




	public int getStosize() {
		return stosize;
	}




	public void setStosize(int stosize) {
		this.stosize = stosize;
	}




	public int getCartqty() {
		return cartqty;
	}




	public void setCartqty(int cartqty) {
		this.cartqty = cartqty;
	}




	public int getStoprice() {
		return stoprice;
	}




	public void setStoprice(int stoprice) {
		this.stoprice = stoprice;
	}




	public String getColor() {
		return color;
	}




	public void setColor(String color) {
		this.color = color;
	}




	public FileInputStream getFile() {
		return file;
	}




	public void setFile(FileInputStream file) {
		this.file = file;
	}







	







	
	
	


	
	
	
	

}
