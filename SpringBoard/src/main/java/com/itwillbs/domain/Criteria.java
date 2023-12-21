package com.itwillbs.domain;

/*
 * 페이징 처리용
 * 페이지 번호, 페이지 사이즈 저장
 * 
 */

public class Criteria {
	
	private int page;
	private int pageSize;
//	private int startPage; 변수 선언없이 get 메서드만 구현
	
	public Criteria() {
		this.page = 1;
		this.pageSize = 10;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page=1;
			return;
		}
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize <= 0 || pageSize > 100) {
			this.pageSize = 10;
			return;
		}
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
	public int getStartPage() {
		// 전달받은 페이지 정보(값)을 쿼리에 사용되는 값으로 변경
		return (this.page-1)*pageSize;
	}
	
}
