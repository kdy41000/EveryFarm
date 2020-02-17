package com.everyfarm.fundproduct.dto;

public class FundPayInputDto {
	
	private int pay_no;
	private int order_no;
	private int pay_price;
	
	public FundPayInputDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FundPayInputDto(int pay_no, int order_no, int pay_price) {
		super();
		this.pay_no = pay_no;
		this.order_no = order_no;
		this.pay_price = pay_price;
	}

	public int getPay_no() {
		return pay_no;
	}

	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public int getPay_price() {
		return pay_price;
	}

	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}
	

}
