package com.fm.www.dto;

public class Photo {
	private int photo_no;
	private String photo_origin;
	private String photo_stored;
	private int board_fg;
	private int board_no;
	private String photo_delete_yn;
	@Override
	public String toString() {
		return "Photo [photo_no=" + photo_no + ", photo_origin=" + photo_origin + ", photo_stored=" + photo_stored
				+ ", board_fg=" + board_fg + ", board_no=" + board_no + ", photo_delete_yn=" + photo_delete_yn
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public int getPhoto_no() {
		return photo_no;
	}
	public void setPhoto_no(int photo_no) {
		this.photo_no = photo_no;
	}
	public String getPhoto_origin() {
		return photo_origin;
	}
	public void setPhoto_origin(String photo_origin) {
		this.photo_origin = photo_origin;
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
	public String getPhoto_delete_yn() {
		return photo_delete_yn;
	}
	public void setPhoto_delete_yn(String photo_delete_yn) {
		this.photo_delete_yn = photo_delete_yn;
	}
	
}
