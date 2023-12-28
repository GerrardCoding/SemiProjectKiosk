package com.javalec.sumin.function;

public class MyOrdersDto {
	
	//Field
	
	int stgseqno;
	String stomodelnum;
	int stgsize;
	int stgqty;
	String stgdate; 
	
	
	
	

	public MyOrdersDto(int stgseqno, String stomodelnum, int stgsize, int stgqty, String stgdate) {
		super();
		this.stgseqno = stgseqno;
		this.stomodelnum = stomodelnum;
		this.stgsize = stgsize;
		this.stgqty = stgqty;
		this.stgdate = stgdate;
	}

	public int getStgseqno() {
		return stgseqno;
	}

	public void setStgseqno(int stgseqno) {
		this.stgseqno = stgseqno;
	}

	public String getStomodelnum() {
		return stomodelnum;
	}

	public void setStomodelnum(String stomodelnum) {
		this.stomodelnum = stomodelnum;
	}

	public int getStgsize() {
		return stgsize;
	}

	public void setStgsize(int stgsize) {
		this.stgsize = stgsize;
	}

	public int getStgqty() {
		return stgqty;
	}

	public void setStgqty(int stgqty) {
		this.stgqty = stgqty;
	}

	public String getStgdate() {
		return stgdate;
	}

	public void setStgdate(String stgdate) {
		this.stgdate = stgdate;
	}
	
	
	
	
	
	

}
