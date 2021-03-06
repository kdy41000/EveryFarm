package com.everyfarm.member.dto;

import java.util.Date;

public class MemberDto {
	//일반회원
	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private String mem_phone;
	private String mem_zonecode;
	private String mem_addr;
	private String mem_addretc;
	private String mem_email;
	private int mem_grade;
	private String mem_regdate;
	private String mem_drop;

	//농부
	private int farmer_status;
	private Date farmer_regdate;
	
	
	
	public MemberDto() {
	
	}
	public MemberDto(String mem_id, String mem_pw, String mem_name, String mem_phone, String mem_zonecode,
			String mem_addr, String mem_addretc, String mem_email, int mem_grade, String mem_regdate, String mem_drop) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_zonecode = mem_zonecode;
		this.mem_addr = mem_addr;
		this.mem_addretc = mem_addretc;
		this.mem_email = mem_email;
		this.mem_grade = mem_grade;
		this.mem_regdate = mem_regdate;
		this.mem_drop = mem_drop;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_zonecode() {
		return mem_zonecode;
	}
	public void setMem_zonecode(String mem_zonecode) {
		this.mem_zonecode = mem_zonecode;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public String getMem_addretc() {
		return mem_addretc;
	}
	public void setMem_addretc(String mem_addretc) {
		this.mem_addretc = mem_addretc;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public int getMem_grade() {
		return mem_grade;
	}
	public void setMem_grade(int mem_grade) {
		this.mem_grade = mem_grade;
	}
	public String getMem_regdate() {
		return mem_regdate;
	}
	public void setMem_regdate(String mem_regdate) {
		this.mem_regdate = mem_regdate;
	}
	public String getMem_drop() {
		return mem_drop;
	}
	public void setMem_drop(String mem_drop) {
		this.mem_drop = mem_drop;
	}


	public int getFarmer_status() {
		return farmer_status;
	}

	public void setFarmer_status(int farmer_status) {
		this.farmer_status = farmer_status;
	}

	public Date getFarmer_regdate() {
		return farmer_regdate;
	}

	public void setFarmer_regdate(Date farmer_regdate) {
		this.farmer_regdate = farmer_regdate;
	}

	
	
}
