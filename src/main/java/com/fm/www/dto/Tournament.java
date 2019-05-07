package com.fm.www.dto;

import java.sql.Date;

public class Tournament {

	private int board_fg;
	private int board_no;
	private Date con_reg_dates;
	private Date con_con_dates;
	private Date con_reg_datee;
	private Date con_con_datee;
	private String con_region;
	private int board_div;
	private String board_title;
	private String board_content;
	@Override
	public String toString() {
		return "Tournament [board_fg=" + board_fg + ", board_no=" + board_no + ", con_reg_dates=" + con_reg_dates
				+ ", con_con_dates=" + con_con_dates + ", con_reg_datee=" + con_reg_datee + ", con_con_datee="
				+ con_con_datee + ", con_region=" + con_region + ", board_div=" + board_div + ", board_title="
				+ board_title + ", board_content=" + board_content + "]";
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
	public Date getCon_reg_dates() {
		return con_reg_dates;
	}
	public void setCon_reg_dates(Date con_reg_dates) {
		this.con_reg_dates = con_reg_dates;
	}
	public Date getCon_con_dates() {
		return con_con_dates;
	}
	public void setCon_con_dates(Date con_con_dates) {
		this.con_con_dates = con_con_dates;
	}
	public Date getCon_reg_datee() {
		return con_reg_datee;
	}
	public void setCon_reg_datee(Date con_reg_datee) {
		this.con_reg_datee = con_reg_datee;
	}
	public Date getCon_con_datee() {
		return con_con_datee;
	}
	public void setCon_con_datee(Date con_con_datee) {
		this.con_con_datee = con_con_datee;
	}
	public String getCon_region() {
		return con_region;
	}
	public void setCon_region(String con_region) {
		this.con_region = con_region;
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

	
	
}