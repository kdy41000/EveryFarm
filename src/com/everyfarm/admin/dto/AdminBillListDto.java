package com.everyfarm.admin.dto;

import java.sql.Date;

public class AdminBillListDto {
	
	// 상품
	private int stock_no;
	private String mem_id;
	private String stock_name;
	private String stock_detail;
	private int stock_kg;
	private int stock_price;
	private String stock_image;
	private String stock_location;
	private int stock_kind;
	
	//주문
	private int order_no;
	//private int stock_no;
	//private String mem_id;

	//주문 상세
	private int orderinfo_no;
	//private int order_no;
	private int orderInfo_kg;
	private int orderInfo_status;
	private Date orderInfo_date;
	private int orderInfo_kind;


}
