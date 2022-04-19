package com.iu.boot3.board;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.intThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.boot3.util.Pager;

@SpringBootTest
class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	void test() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(109L);
		boardVO = boardMapper.getDetail(boardVO);
		
		System.out.println(boardVO.toString());
		assertNotNull(boardVO);
	}

	//@Test
	public void getListTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
//		pager.setPn(1);
//		pager.setPerPage(10);
		List<BoardVO> ar = boardMapper.getList(pager);
		System.out.println(ar.get(0).toString());
		assertEquals(10, ar.size());
	}
	
	//@Test
	public void setUpdateTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(3L);
		boardVO.setTitle("title update");
		boardVO.setContents("contents update");
		int result = boardMapper.setUpdate(boardVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void setDelete() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(3L);
		int result = boardMapper.setDelete(boardVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void setAddTest() throws Exception{
		for(int i=0;i<100;i++) {
			
		if(i%10 == 0) {
			Thread.sleep(1000);
		}
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("addTitle"+i);
		boardVO.setContents("addContents"+i);
		boardVO.setWriter("addWriter"+i);
		
	//	int result = boardMapper.setAdd(boardVO);
		}
		System.out.println("finish");
		//assertEquals(1, result);
	}
	
	//@Test
	public void setFileAddTest() throws Exception {
		
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setNum(4L);
		boardFilesVO.setFileName("fileName");
		boardFilesVO.setOriName("oriName");
		
		int result = boardMapper.setFileAdd(boardFilesVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void setFileDetail() throws Exception {
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setFileNum(3L);
		boardFilesVO = boardMapper.getFileDetail(boardFilesVO);
		
		assertNotNull(boardFilesVO);
	}
	
//	//@Test
//	public void getFileList() throws Exception {
//		List<BoardFilesVO> ar = boardMapper.getFileList();
//		assertNotEquals(0, ar.size());
//	}
	
	//@Test
	public void setFileDelete() throws Exception {
		BoardFilesVO boardFilesVO = new BoardFilesVO();
		boardFilesVO.setFileNum(4L);
		
		int result = boardMapper.setFileDelete(boardFilesVO);
		assertEquals(1, result);
	}
	

}
