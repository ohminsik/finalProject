package com.fm.www.dto;

public class User {

//	ctrl + shift + y
	private int user_no;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_nick;
	private String user_email;
	private String user_phone;
	private int user_year;
	private String user_region;
	private String user_sport;
	private String user_profile;
	private int team_no;
	
	@Override
	public String toString() {
		return "User [user_no=" + user_no + ", user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name
				+ ", user_nick=" + user_nick + ", user_email=" + user_email + ", user_phone=" + user_phone
				+ ", user_year=" + user_year + ", user_region=" + user_region + ", user_sport=" + user_sport
				+ ", user_profile=" + user_profile + ", team_no=" + team_no + "]";
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public int getUser_year() {
		return user_year;
	}
	public void setUser_year(int user_year) {
		this.user_year = user_year;
	}
	public String getUser_region() {
		return user_region;
	}
	public void setUser_region(String user_region) {
		this.user_region = user_region;
	}
	public String getUser_sport() {
		return user_sport;
	}
	public void setUser_sport(String user_sport) {
		this.user_sport = user_sport;
	}
	public String getUser_profile() {
		return user_profile;
	}
	public void setUser_profile(String user_profile) {
		this.user_profile = user_profile;
	}
	public int getTeam_no() {
		return team_no;
	}
	public void setTeam_no(int team_no) {
		this.team_no = team_no;
	}
	
	
}
