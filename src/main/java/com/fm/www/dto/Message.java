package com.fm.www.dto;

import java.util.Date;

public class Message {
	private int message_no; 				//메세지 시퀀스
	private int reciveruser_no; 			//보낸사람 번호
	private String reciveruser_id;			//보낸사람 아이디
	private String reciveruser_name;		//보낸사람 이름
	private int senduser_no; 				//받는사람 번호
	private String senduser_id; 			//받는사람 아이디
	private String senduser_name; 			//받는사람 이름
	private String message_content; 		//메세지 내용
	private Date message_date; 				//메세지 보낸 날짜
	private String message_YN;				//메세지 확인
	
	
	
	public String getReciveruser_id() {
		return reciveruser_id;
	}
	public void setReciveruser_id(String reciveruser_id) {
		this.reciveruser_id = reciveruser_id;
	}
	public String getReciveruser_name() {
		return reciveruser_name;
	}
	public void setReciveruser_name(String reciveruser_name) {
		this.reciveruser_name = reciveruser_name;
	}
	public String getSenduser_id() {
		return senduser_id;
	}
	public void setSenduser_id(String senduser_id) {
		this.senduser_id = senduser_id;
	}
	public String getSenduser_name() {
		return senduser_name;
	}
	public void setSenduser_name(String senduser_name) {
		this.senduser_name = senduser_name;
	}
	public int getMessage_no() {
		return message_no;
	}
	public void setMessage_no(int message_no) {
		this.message_no = message_no;
	}
	public int getReciveruser_no() {
		return reciveruser_no;
	}
	public void setReciveruser_no(int reciveruser_no) {
		this.reciveruser_no = reciveruser_no;
	}
	public int getSenduser_no() {
		return senduser_no;
	}
	public void setSenduser_no(int senduser_no) {
		this.senduser_no = senduser_no;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public Date getMessage_date() {
		return message_date;
	}
	public void setMessage_date(Date message_date) {
		this.message_date = message_date;
	}
	public String getMessage_YN() {
		return message_YN;
	}
	public void setMessage_YN(String message_YN) {
		this.message_YN = message_YN;
	}
	@Override
	public String toString() {
		return "Message [message_no=" + message_no + ", reciveruser_no=" + reciveruser_no + ", reciveruser_id="
				+ reciveruser_id + ", reciveruser_name=" + reciveruser_name + ", senduser_no=" + senduser_no
				+ ", senduser_id=" + senduser_id + ", senduser_name=" + senduser_name + ", message_content="
				+ message_content + ", message_date=" + message_date + ", message_YN=" + message_YN + "]";
	}
	
	
}
