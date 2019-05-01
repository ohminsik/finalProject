package com.fm.www.dto;

public class Movie {
	private int movie_no;
	private int board_fg;
	private int board_no;
	private String movie_address;
	@Override
	public String toString() {
		return "Movie [movie_no=" + movie_no + ", board_fg=" + board_fg + ", board_no=" + board_no + ", movie_address="
				+ movie_address + "]";
	}
	public int getMovie_no() {
		return movie_no;
	}
	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
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
	public String getMovie_address() {
		return movie_address;
	}
	public void setMovie_address(String movie_address) {
		this.movie_address = movie_address;
	}
	
}
