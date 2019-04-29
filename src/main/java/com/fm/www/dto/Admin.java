package com.fm.www.dto;

public class Admin {

	private int admin_no;
	private String admin_id;
	private String admin_pw;
	
	
	
	@Override
	public String toString() {
		return "Admin [admin_no=" + admin_no + ", admin_id=" + admin_id + ", admin_pw=" + admin_pw + "]";
	}
	public int getAdmin_no() {
		return admin_no;
	}
	public void setAdmin_no(int admin_no) {
		this.admin_no = admin_no;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_pw() {
		return admin_pw;
	}
	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}
	
	
}
