package com.iu.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.boot3.util.Pager;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(boardMapper.getTotalCount(pager));
		
		return boardMapper.getList(pager);
	}
	
	public int setAdd(BoardVO boardVO) throws Exception {
		return boardMapper.setAdd(boardVO);
	}
	
	public int setUpdate(BoardVO boardVO) throws Exception {
		return boardMapper.setUpdate(boardVO);
	}
	
	public int setDelete(BoardVO boardVO) throws Exception {
		return boardMapper.setDelete(boardVO);
	}
}
