package com.fm.www.dto;

public class Ground {

	private int board_fg;
	private int board_no;
	private String ground_addr;
	private String ground_name;
	private String photo_stored;
	
	@Override
	public String toString() {
		return "Ground [board_fg=" + board_fg + ", board_no=" + board_no + ", ground_addr=" + ground_addr
				+ ", ground_name=" + ground_name + ", photo_stored=" + photo_stored + "]";
	}
	public String getPhoto_stored() {
		return photo_stored;
	}
	public void setPhoto_stored(String photo_stored) {
		this.photo_stored = photo_stored;
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
	public String getGround_addr() {
		return ground_addr;
	}
	public void setGround_addr(String ground_addr) {
		this.ground_addr = ground_addr;
	}
	public String getGround_name() {
		return ground_name;
	}
	public void setGround_name(String ground_name) {
		this.ground_name = ground_name;
	}
	
	
	
	
	
}
