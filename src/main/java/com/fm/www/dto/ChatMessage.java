package com.fm.www.dto;

public class ChatMessage {
	private int cnt;// 접속자수
	private String message ;// 메시지
	private String name;// 접속한 아이디
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ChatMessage [cnt=" + cnt + ", message=" + message + ", name=" + name + "]";
	}
	
	
}
