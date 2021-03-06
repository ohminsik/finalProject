package com.fm.www.util;

public class Paging {

	private int curPage;

	private int totalCount;
	private int listCount;
	private int totalPage;

	private int pageCount;
	private int startPage;
	private int endPage;

	private int startNo;
	private int endNo;

	private String search;
	private String word;
	
	
	public Paging() {
		
	}
	
	
	// 총 게시글 수만 입력하는 생성자
	public Paging(int totalCount) {
		this.setTotalCount(totalCount);

		makePaging();
	}

	// 총 게시글 수, 현재 페이지 입력하는 생성자
	public Paging(int totalCount, int curPage) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);

		makePaging();
	}

	// 총 게시글 수, 현재 페이지, 페이지당 게시글 수 입력하는 생성자
	public Paging(int totalCount, int curPage, int listCount) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		this.setListCount(listCount);

		makePaging();
	}

	// 총 게시글 수, 현재 페이지, 페이지당 게시글 수, 페이지카운트 입력하는 생성자
	public Paging(int totalCount, int curPage, int listCount, int pageCount) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		this.setListCount(listCount);
		this.setPageCount(pageCount);

		makePaging();
	}

	private void makePaging() {
		if (totalCount == 0)
			return; // 게시글이 없는 경우 중단

		// 기본값 설정
		if (curPage == 0)
			setCurPage(1); // 첫페이지로 설정
		if (listCount == 0)
			setListCount(10); // 게시글 10개로 설정
		if (pageCount == 0)
			setPageCount(10); // 페이징 10개로 설정

		// 페이징 1단계
		// 총 페이징 수 계산
		totalPage = totalCount / listCount;
		if (totalCount % listCount > 0)
			totalPage++;

		// 추가작업
//			//현재 페이지가 첫 페이지보다 작게 입력되면 강제로 첫 페이지로 고정시키기
//			if( curPage < 1 ) curPage = 1;
		// 현재 페이지가 총 페이지보다 크게 입력되면 강제로 마지막 페이지로 고정시키기
		if (totalPage < curPage)
			curPage = totalPage;

		// 페이징 2단계
		// 화면에 보이는 시작 페이지 & 끝 페이지 번호 계산
		startPage = ((curPage - 1) / pageCount) * pageCount + 1;
		endPage = startPage + pageCount - 1;

		// 추가작업
		// 마지막으로 계산된 페이지가 totalPage보다 커질 경우
		// 강제로 최종 페이지까지만 보이도록 설정
		if (endPage > totalPage)
			endPage = totalPage;

		// 화면에 보이는 시작 게시글 & 긑 게시글 번호 계산
		startNo = (curPage - 1) * listCount + 1;
		endNo = curPage * listCount;

	}

	@Override
	public String toString() {
		return "Paging [curPage=" + curPage + ", totalCount=" + totalCount + ", listCount=" + listCount + ", totalPage="
				+ totalPage + ", pageCount=" + pageCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", startNo=" + startNo + ", endNo=" + endNo + ", search=" + search + ", word=" + word + "]";
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}




}
