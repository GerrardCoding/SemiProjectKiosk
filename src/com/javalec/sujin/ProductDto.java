package com.javalec.sujin;

import java.io.FileInputStream;

public class ProductDto {
	// Field
	String modelnum;
	String brand;
	String modelname;
	String color;
	int stosize;
	int stoqty;
	int stoprice;
	FileInputStream file;

	// Constructor
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}



	public ProductDto(String modelnum, String brand, String modelname, String color, int stosize, int stoqty,
			int stoprice) {
		super();
		this.modelnum = modelnum;
		this.brand = brand;
		this.modelname = modelname;
		this.color = color;
		this.stosize = stosize;
		this.stoqty = stoqty;
		this.stoprice = stoprice;
	}

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

	public int getStosize() {
		return stosize;
	}

	public void setStosize(int stosize) {
		this.stosize = stosize;
	}

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

	public FileInputStream getFile() {
		return file;
	}

	public void setFile(FileInputStream file) {
		this.file = file;
	}
	
	// Method
	
}
