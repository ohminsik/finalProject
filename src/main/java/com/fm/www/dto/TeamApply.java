package com.fm.www.dto;

import java.util.Date;

public class TeamApply {

	private int apply_no;
	private int user_no;
	private int team_no;
	private Date apply_date;
	
	private String user_name;
	private String user_id;
	private String user_position;
	private String user_region;
	private String user_birth;
	
	
	
	public String getUser_region() {
		return user_region;
	}
	public void setUser_region(String user_region) {
		this.user_region = user_region;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	public Date getApply_date() {
		return apply_date;
	}
	public void setApply_date(Date apply_date) {
		this.apply_date = apply_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_position() {
		return user_position;
	}
	public void setUser_position(String user_position) {
		this.user_position = user_position;
	}
	public int getApply_no() {
		return apply_no;
	}
	public void setApply_no(int apply_no) {
		this.apply_no = apply_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getTeam_no() {
		return team_no;
	}
	public void setTeam_no(int team_no) {
		this.team_no = team_no;
	}
	
	@Override
	public String toString() {
		return "TeamApply [apply_no=" + apply_no + ", user_no=" + user_no + ", team_no=" + team_no + ", apply_date="
				+ apply_date + ", user_name=" + user_name + ", user_id=" + user_id + ", user_position=" + user_position
				+ ", user_region=" + user_region + ", user_birth=" + user_birth + "]";
	}	
}
