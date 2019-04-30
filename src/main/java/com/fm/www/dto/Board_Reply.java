package com.fm.www.dto;

import java.util.Date;

public class Board_Reply {
	private int reply_no;
	private int board_fg;
	private int board_no;
	private int user_no;
	private String reply_content;
	private Date reply_date;
	private String reply_delete_yn;
	private String user_nick;
	@Override
	public String toString() {
		return "Board_Reply [reply_no=" + reply_no + ", board_fg=" + board_fg + ", board_no=" + board_no + ", user_no="
				+ user_no + ", reply_content=" + reply_content + ", reply_date=" + reply_date + ", reply_delete_yn="
				+ reply_delete_yn + ", user_nick=" + user_nick + "]";
	}
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public int getBoard_fg() {
		return board_fg;
	}
	public void setBoard_fg(int board_fg) {
		this.board_fg = board_fg;
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
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	public String getReply_delete_yn() {
		return reply_delete_yn;
	}
	public void setReply_delete_yn(String reply_delete_yn) {
		this.reply_delete_yn = reply_delete_yn;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	
	
	
	
}
