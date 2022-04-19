package com.iu.boot3.util;

import lombok.Data;

@Data
public class Pager {
	
	// 한 페이지 조회시 DB에서 몇 개씩 조회할지 (파라미터의 값 가능)
	private Integer perPage;
	
	// DB에서 조회할 시작 인덱스 번호
	private Integer startRow;
	
	// 페이지 번호(파라미터의 값)
	private Integer pn;
	
	//-----------검색 사용 변수(파라미터의 값) -----------
	private String kind;
	private String search;
	
	//-----------jsp 사용 변수 ------------
	private Long startNum;
	private Long lastNum;
	
	private boolean pre;
	private boolean next;
	
	public void makeNum(Long totalCount) {
		// 1. 전체 row의 갯수 구하기 - 매개변수로 받아오기
		
		// 2. 전체 page의 갯수 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		
		// 3. 블럭당 갯수
		Long perBlock = 5L; 
		
		// 4. 전체 block의 갯수 구하기
		Long totalBlock = totalPage / perBlock;
		if(totalPage % perBlock != 0) {
			totalBlock++;
		}
		
		// 5. page 번호로 현재 몇 번째 Block인지 계산
		// 1번 : 1 - 10
		// 2번 : 11 -20
		
		// page		Block
		//  1		  1
		//  2		  1
		//  ...
		//  11  	  2
		//  20 		  2
		//  21 		  3
		Long curBlock = this.getPn() / perBlock;
		if(this.getPn()%perBlock != 0)
			curBlock++;
		
		// 6. curBlock 로 startNum, lastNum 구하기
		// curBlock		startNum	lastNum
		//	  1				1		   10
		//	  2				11		   20
		this.startNum = (curBlock-1)*perBlock+1;
		this.lastNum = curBlock * perBlock;
		
		// 7. 이전, 다음 블럭 유무 검사
		this.pre = false;
		if(curBlock > 1) {
			this.pre = true;
		}
		
		this.next = false;
		if(totalBlock > curBlock) {
			this.next = true;
		}
		
		// 8. 현재 블럭이 마지막 블럭번호와 같다면
		if(curBlock == totalBlock)
			this.lastNum= totalPage;
		
		// 9. 검색결과가 없어서 Total이 0일때
		if(totalCount == 0)
			this.lastNum = 1L;
	}
	
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
