package com.everyfarm.fundproduct.dto;

public class FundPayDto {
	
	private int order_no;
	private int stock_no;
	private String mem_id;
	private int orderinfo_kg;

	
	
	public FundPayDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FundPayDto(int order_no, int stock_no, String mem_id, int orderinfo_kg) {
		super();
		this.order_no = order_no;
		this.stock_no = stock_no;
		this.mem_id = mem_id;
		this.orderinfo_kg = orderinfo_kg;
	}



	public int getOrderinfo_kg() {
		return orderinfo_kg;
	}



	public void setOrderinfo_kg(int orderinfo_kg) {
		this.orderinfo_kg = orderinfo_kg;
	}



	public int getOrder_no() {
		return order_no;
	}



	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}



	public int getStock_no() {
		return stock_no;
	}



	public void setStock_no(int stock_no) {
		this.stock_no = stock_no;
	}



	public String getMem_id() {
		return mem_id;
	}



	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	
	

}
