package com.fm.www.dto;

import java.util.Date;

/**
 * @author jun123
 *
 */
public class Match {

	private int match_no;
	private Date match_date;
	private Date fight_date;
	private String match_ground;
	private String match_ground_yn;
	private int match_money;
	private String match_uniform;
	private String match_region;
	private String match_content;
	private int blueteam_no;
	private int purpleteam_no;
	private int user_no;
	private int blueteam_score;
	private int purpleteam_score;
	
	//조인용(team_tb테이블)
	private String team_mark;//팀마크
	private String team_name;//팀명
	private int team_etire;//전체
	private int team_win;//승수
	private int team_lose;//패배수
	private int team_tie;//무승부
	private int team_cnt;//팀원수
	private String team_region;//팀지역
	
	public Match() {
		
	}

	@Override
	public String toString() {
		return "Match [match_no=" + match_no + ", match_date=" + match_date + ", fight_date=" + fight_date
				+ ", match_ground=" + match_ground + ", match_ground_yn=" + match_ground_yn + ", match_money="
				+ match_money + ", match_uniform=" + match_uniform + ", match_region=" + match_region
				+ ", match_content=" + match_content + ", blueteam_no=" + blueteam_no + ", purpleteam_no="
				+ purpleteam_no + ", user_no=" + user_no + ", blueteam_score=" + blueteam_score + ", purpleteam_score="
				+ purpleteam_score + ", team_mark=" + team_mark + ", team_name=" + team_name + ", team_etire="
				+ team_etire + ", team_win=" + team_win + ", team_lose=" + team_lose + ", team_tie=" + team_tie
				+ ", team_cnt=" + team_cnt + ", team_region=" + team_region + "]";
	}

	public int getMatch_no() {
		return match_no;
	}

	public void setMatch_no(int match_no) {
		this.match_no = match_no;
	}

	public Date getMatch_date() {
		return match_date;
	}

	public void setMatch_date(Date match_date) {
		this.match_date = match_date;
	}

	public Date getFight_date() {
		return fight_date;
	}

	public void setFight_date(Date fight_date) {
		this.fight_date = fight_date;
	}

	public String getMatch_ground() {
		return match_ground;
	}

	public void setMatch_ground(String match_ground) {
		this.match_ground = match_ground;
	}

	public String getMatch_ground_yn() {
		return match_ground_yn;
	}

	public void setMatch_ground_yn(String match_ground_yn) {
		this.match_ground_yn = match_ground_yn;
	}

	public int getMatch_money() {
		return match_money;
	}

	public void setMatch_money(int match_money) {
		this.match_money = match_money;
	}

	public String getMatch_uniform() {
		return match_uniform;
	}

	public void setMatch_uniform(String match_uniform) {
		this.match_uniform = match_uniform;
	}

	public String getMatch_region() {
		return match_region;
	}

	public void setMatch_region(String match_region) {
		this.match_region = match_region;
	}

	public String getMatch_content() {
		return match_content;
	}

	public void setMatch_content(String match_content) {
		this.match_content = match_content;
	}

	public int getBlueteam_no() {
		return blueteam_no;
	}

	public void setBlueteam_no(int blueteam_no) {
		this.blueteam_no = blueteam_no;
	}

	public int getPurpleteam_no() {
		return purpleteam_no;
	}

	public void setPurpleteam_no(int purpleteam_no) {
		this.purpleteam_no = purpleteam_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getBlueteam_score() {
		return blueteam_score;
	}

	public void setBlueteam_score(int blueteam_score) {
		this.blueteam_score = blueteam_score;
	}

	public int getPurpleteam_score() {
		return purpleteam_score;
	}

	public void setPurpleteam_score(int purpleteam_score) {
		this.purpleteam_score = purpleteam_score;
	}

	public String getTeam_mark() {
		return team_mark;
	}

	public void setTeam_mark(String team_mark) {
		this.team_mark = team_mark;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public int getTeam_etire() {
		return team_etire;
	}

	public void setTeam_etire(int team_etire) {
		this.team_etire = team_etire;
	}

	public int getTeam_win() {
		return team_win;
	}

	public void setTeam_win(int team_win) {
		this.team_win = team_win;
	}

	public int getTeam_lose() {
		return team_lose;
	}

	public void setTeam_lose(int team_lose) {
		this.team_lose = team_lose;
	}

	public int getTeam_tie() {
		return team_tie;
	}

	public void setTeam_tie(int team_tie) {
		this.team_tie = team_tie;
	}

	public int getTeam_cnt() {
		return team_cnt;
	}

	public void setTeam_cnt(int team_cnt) {
		this.team_cnt = team_cnt;
	}

	public String getTeam_region() {
		return team_region;
	}

	public void setTeam_region(String team_region) {
		this.team_region = team_region;
	}


}