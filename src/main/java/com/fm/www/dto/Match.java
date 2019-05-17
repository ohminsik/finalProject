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
	private int blueteam_no;//매치등록 팀
	private int purpleteam_no;//매치신청 팀
	private int user_no;
	private int blueteam_score;
	private int purpleteam_score;
	
	private int calendar;
	
	//조인용(team_tb테이블)
	private String team_mark;//팀마크
	private String team_name;//팀명
	private int team_etire;//전체
	private int team_win;//승수
	private int team_lose;//패배수
	private int team_tie;//무승부
	private int team_cnt;//팀원수
	private String team_region;//팀지역
	private String team_filed;//팀 활동구장
	
	//2019/05/07 user_tb 컬럼 추가
	private String user_name;//개설자
	private String user_phone;//개설자 연락처
	private String user_region;
	
	private String dateComment;
	private boolean curDateYn;//현재날짜 여부 판단
	private boolean pickYn;//신청한 매치인지 여부 
	
	//매치보드용
	private String blue_name;
	private String blue_mark;
	private int blue_etire;
	private int blue_win;
	private int blue_lose;
	private int blue_tie;
	private int blue_rating;
	
	private String purple_name;
	private String purple_mark;
	private int purple_etire;
	private int purple_win;
	private int purple_lose;
	private int purple_tie;
	private int purple_rating;
		
	public Match() {
		
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

	public String getTeam_filed() {
		return team_filed;
	}

	public void setTeam_filed(String team_filed) {
		this.team_filed = team_filed;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_region() {
		return user_region;
	}

	public void setUser_region(String user_region) {
		this.user_region = user_region;
	}

	public String getDateComment() {
		return dateComment;
	}

	public void setDateComment(String dateComment) {
		this.dateComment = dateComment;
	}

	public boolean isCurDateYn() {
		return curDateYn;
	}

	public void setCurDateYn(boolean curDateYn) {
		this.curDateYn = curDateYn;
	}

	public boolean isPickYn() {
		return pickYn;
	}

	public void setPickYn(boolean pickYn) {
		this.pickYn = pickYn;
	}

	public String getBlue_name() {
		return blue_name;
	}

	public void setBlue_name(String blue_name) {
		this.blue_name = blue_name;
	}

	public String getBlue_mark() {
		return blue_mark;
	}

	public void setBlue_mark(String blue_mark) {
		this.blue_mark = blue_mark;
	}

	public int getBlue_etire() {
		return blue_etire;
	}

	public void setBlue_etire(int blue_etire) {
		this.blue_etire = blue_etire;
	}

	public int getBlue_win() {
		return blue_win;
	}

	public void setBlue_win(int blue_win) {
		this.blue_win = blue_win;
	}

	public int getBlue_lose() {
		return blue_lose;
	}

	public void setBlue_lose(int blue_lose) {
		this.blue_lose = blue_lose;
	}

	public int getBlue_tie() {
		return blue_tie;
	}

	public void setBlue_tie(int blue_tie) {
		this.blue_tie = blue_tie;
	}

	public int getBlue_rating() {
		return blue_rating;
	}

	public void setBlue_rating(int blue_rating) {
		this.blue_rating = blue_rating;
	}

	public String getPurple_name() {
		return purple_name;
	}

	public void setPurple_name(String purple_name) {
		this.purple_name = purple_name;
	}

	public String getPurple_mark() {
		return purple_mark;
	}

	public void setPurple_mark(String purple_mark) {
		this.purple_mark = purple_mark;
	}

	public int getPurple_etire() {
		return purple_etire;
	}

	public void setPurple_etire(int purple_etire) {
		this.purple_etire = purple_etire;
	}

	public int getPurple_win() {
		return purple_win;
	}

	public void setPurple_win(int purple_win) {
		this.purple_win = purple_win;
	}

	public int getPurple_lose() {
		return purple_lose;
	}

	public void setPurple_lose(int purple_lose) {
		this.purple_lose = purple_lose;
	}

	public int getPurple_tie() {
		return purple_tie;
	}

	public void setPurple_tie(int purple_tie) {
		this.purple_tie = purple_tie;
	}

	public int getPurple_rating() {
		return purple_rating;
	}

	public void setPurple_rating(int purple_rating) {
		this.purple_rating = purple_rating;
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
				+ ", team_cnt=" + team_cnt + ", team_region=" + team_region + ", team_filed=" + team_filed
				+ ", user_name=" + user_name + ", user_phone=" + user_phone + ", user_region=" + user_region
				+ ", dateComment=" + dateComment + ", curDateYn=" + curDateYn + ", pickYn=" + pickYn + ", blue_name="
				+ blue_name + ", blue_mark=" + blue_mark + ", blue_etire=" + blue_etire + ", blue_win=" + blue_win
				+ ", blue_lose=" + blue_lose + ", blue_tie=" + blue_tie + ", blue_rating=" + blue_rating
				+ ", purple_name=" + purple_name + ", purple_mark=" + purple_mark + ", purple_etire=" + purple_etire
				+ ", purple_win=" + purple_win + ", purple_lose=" + purple_lose + ", purple_tie=" + purple_tie
				+ ", purple_rating=" + purple_rating + "]";
	}

	
	
}