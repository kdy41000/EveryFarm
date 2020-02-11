package com.everyfarm.admin.dto;

import java.sql.Date;

public class MemDto {
//	ID			VARCHAR2(20)	PRIMARY KEY,
//	PW			VARCHAR2(20)	NOT NULL,
//	NAME		VARCHAR2(20)	NOT NULL,
//	EMAIL		VARCHAR2(30)	NOT NULL,
//	ZONECODE	VARCHAR2(10)	NOT NULL,
//	ADDRESS		VARCHAR2(100)	NOT NULL,
//	ADDRESSETC	VARCHAR2(100)	NOT NULL,
//	PHONE		VARCHAR2(13)	NOT NULL,
//	GRADE		NUMBER(3)		NOT NULL,
//	REGDATE		DATE			NOT NULL,
//	DROPOUT		VARCHAR2(2)		NOT NULL
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String zonecode;
	private String address;
	private String addressetc;
	private String phone;
	private int grade;
	private Date regdate;
	private String dropout;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZonecode() {
		return zonecode;
	}
	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressetc() {
		return addressetc;
	}
	public void setAddressetc(String addressetc) {
		this.addressetc = addressetc;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getDropout() {
		return dropout;
	}
	public void setDropout(String dropout) {
		this.dropout = dropout;
	}
	
}
