package com.itwillbs.domain;
/*
 * 	페이징 처리에 필요한 정보 저장 (페이징 블록)
 * 		=> 데이터(글)의 총 갯수, 시작 페이지 번호, 끝 페이지 번호, / 이전(boolean), 다음(boolean)링크 / 블럭의 크기
 * 			+ Cri(페이지번호, 페이지사이즈)
 * 
 * 		총 갯수(totalCount) : DB조회
 * 		끝 페이지(endPage) : 올림(페이지번호/블럭의 사이즈) * 블럭의 사이즈 
 * 		시작 페이지(start Page) : (endPage - 블럭의 사이즈) + 1
 * 		이전 버튼 : prev(boolean) => startPage != 1
 * 		다음 버튼 : next(boolean) => endPage * 페이지 사이즈 < totalCount
 */

public class PageVO {

	private int totalCount;
	private int startPage;
	private int endPage;
	
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10; // 페이지 블럭의 크기
	
	private Criteria cri;
	
	// 페이지 번호, 페이지 사이즈 저장
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	// 
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		// 페이징 처리에 필요한 정보 계산
		calcData();
	}
	
	private void calcData() {
		// 페이징 처리에 필요한 정보 계산 시작
		
			// endPage 계산 
			endPage = (int) (Math.ceil((cri.getPage() / (double)displayPageNum))) * displayPageNum;
			startPage = (endPage-displayPageNum)+1;
			// 끝 페이지 번호체크 (글이 없는 경우)
			int tmpEndPage = (int)(Math.ceil((double)(totalCount) / cri.getPageSize()));
			if(endPage > tmpEndPage) {
				endPage = tmpEndPage;
			}
			
			// 이전 링크
			prev = startPage != 1;
			// 다음 링크
			next = endPage*cri.getPageSize() < totalCount;
			
		// 페이징 처리에 필요한 정보 계산 끝
	}

	public int getTotalCount() {
		return totalCount;
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

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	@Override
	public String toString() {
		return "PageVO [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
	
}
