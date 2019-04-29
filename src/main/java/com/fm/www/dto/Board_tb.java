package com.fm.www.dto;

import java.util.Date;

public class Board_tb {
	
	private int board_no;
	private int user_no;
	private String user_nick;
	private int board_div;
	private String board_title;
	private String board_content;
	private Date board_date;
	private int board_cnt;
	private String delete_yn;
	@Override
	public String toString() {
		return "Board_tb [board_no=" + board_no + ", user_no=" + user_no + ", user_nick=" + user_nick + ", board_div="
				+ board_div + ", board_title=" + board_title + ", board_content=" + board_content + ", board_date="
				+ board_date + ", board_cnt=" + board_cnt + ", delete_yn=" + delete_yn + "]";
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public int getBoard_div() {
		return board_div;
	}
	public void setBoard_div(int board_div) {
		this.board_div = board_div;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public int getBoard_cnt() {
		return board_cnt;
	}
	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
	}
	public String getDelete_yn() {
		return delete_yn;
	}
	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}

}
