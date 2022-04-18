package com.iu.boot3.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iu.boot3.util.Pager;

@Mapper
public interface BoardMapper {
	
	//insert : setFileAdd
	public int setFileAdd(BoardFilesVO boardFilesVO) throws Exception;
	
	//delete : setFileDelete
	public int setFileDelete(BoardFilesVO boardFilesVO) throws Exception;
	
	//detail : getFileDetail
	public BoardFilesVO getFileDetail(BoardFilesVO boardFilesVO) throws Exception;
	
	//list : getFileList
	public List<BoardFilesVO> getFileList() throws Exception;
	
	//detail
	public BoardVO getDetail(BoardVO boardVO) throws Exception;

	//getList
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	//setAdd
	public int setAdd(BoardVO boardVO) throws Exception;

	//setUpdate
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	//setDelete
	public int setDelete(BoardVO boardVO) throws Exception;
	
}
