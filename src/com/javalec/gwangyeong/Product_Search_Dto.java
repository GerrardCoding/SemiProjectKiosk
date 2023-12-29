package com.javalec.gwangyeong;

public class Product_Search_Dto {
	
	String modelnum;
	String brand;
	String modelname;
	String color;
	String filename;
	
	int stosize;
	int stoprice;
	int stoqty;
	
	//--------------------------------------------------------------------------------------------------------------------------------
	
	public Product_Search_Dto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Product_Search_Dto(String brand, String modelname, String color, String filename, int stosize) {
		super();
		this.brand = brand;
		this.modelname = modelname;
		this.color = color;
		this.filename = filename;
		this.stosize = stosize;
	}
	
	
	public Product_Search_Dto(String modelnum, String brand, String modelname, String color, String filename,
			int stosize, int stoprice, int stoqty) {
		super();
		this.modelnum = modelnum;
		this.brand = brand;
		this.modelname = modelname;
		this.color = color;
		this.filename = filename;
		this.stosize = stosize;
		this.stoprice = stoprice;
		this.stoqty = stoqty;
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------------------
	
	// 생성자를 Dao Class로 보내주기 위하여 Getter, Setter 사용한다.
	public String getModelnum() {
		return modelnum;
	}
	
	public void setModelnum(String modelnum) {
		this.modelnum = modelnum;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModelname() {
		return modelname;
	}
	
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getStosize() {
		return stosize;
	}
	
	public void setStosize(int stosize) {
		this.stosize = stosize;
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------------------
	
	public int getStoprice() {
		return stoprice;
	}
	
	public void setStoprice(int stoprice) {
		this.stoprice = stoprice;
	}
	
	public int getStoqty() {
		return stoqty;
	}
	
	public void setStoqty(int stoqty) {
		this.stoqty = stoqty;
	}
	
	
	
}
