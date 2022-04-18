package com.iu.boot3.util;

import lombok.Data;

@Data
public class Pager {
	
	// 한 페이지 조회시 DB에서 몇 개씩 조회할지 
	private Integer perPage;
	
	// DB에서 조회할 시작 인덱스 번호
	private Integer startRow;
	
	// 페이지 번호(파라미터의 값)
	private Integer pn;
	
	//-----------검색 사용 변수 -----------
	private String search;
	private String kind;
	
	// startRow 계산
	public void makeRow() {
		// pn : 1, perPage : 10 => startRow : 0
		// pn : 2, perPage : 10 => startRow : 10
		// pn : 3, perPage : 10 => startRow : 20
		this.startRow = (this.getPn()-1)*this.getPerPage();
	}
	
	// pn 값이 null 이거나, 0 이하의 숫자일 경우 1으로 기본값 셋팅
	public Integer getPn() {
		if(this.pn == null || this.pn < 1) {
			this.pn = 1;
		}
		return this.pn;
	}
	
	// perPage 값이 안들어오거나, 0이하의 숫자일 경우 10으로 기본값 셋팅
	public Integer getPerPage() {
		if(this.perPage == null || this.perPage < 1) {
			this.perPage = 10;
		}
		return this.perPage;
	}
	
	public String getSearch() {
		//검색어가 없으면 search=null
		if(this.search == null) {
			this.search = "";
		}
		//this.search = "%"+this.search+"%";
		
		return search;
	}
}
