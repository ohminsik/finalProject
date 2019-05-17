package com.fm.www.dto;

import java.util.Date;

public class Board_tb {
	
	private int board_no;			//게시판글번호
	private int user_no;			//유저번호
	private String user_nick;		//유저닉네임
	private int board_div;			//게시판구분
	private String board_title;		//게시글제목
	private String board_content;	//게시글내용
	private Date board_date;		//게시글등록날짜
	private int board_cnt;			//게시글조회수
	private String delete_yn;		//게시글 삭제여부
	private int board_reply_cnt;	//게시글 댓글갯수
	private int admin_no; 			//관리자 번호
	
	private String photo_stored;    //사진 변경명
	
	public String getPhoto_stored() {
		return photo_stored;
	}
	public void setPhoto_stored(String photo_stored) {
		this.photo_stored = photo_stored;
	}
	@Override
	public String toString() {
		return "Board_tb [board_no=" + board_no + ", user_no=" + user_no + ", user_nick=" + user_nick + ", board_div="
				+ board_div + ", board_title=" + board_title + ", board_content=" + board_content + ", board_date="
				+ board_date + ", board_cnt=" + board_cnt + ", delete_yn=" + delete_yn + ", board_reply_cnt="
				+ board_reply_cnt + ", admin_no=" + admin_no + ", photo_stored=" + photo_stored + "]";
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
	public int getBoard_reply_cnt() {
		return board_reply_cnt;
	}
	public void setBoard_reply_cnt(int board_reply_cnt) {
		this.board_reply_cnt = board_reply_cnt;
	}
	public int getAdmin_no() {
		return admin_no;
	}
	public void setAdmin_no(int admin_no) {
		this.admin_no = admin_no;
	}
	
	
	

}
