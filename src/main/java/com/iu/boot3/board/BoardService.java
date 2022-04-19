package com.iu.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.boot3.util.FileManager;
import com.iu.boot3.util.Pager;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private FileManager fileManager;
	
	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		return boardMapper.getDetail(boardVO);
	}
	
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(boardMapper.getTotalCount(pager));
		
		return boardMapper.getList(pager);
	}
	
	public int setAdd(BoardVO boardVO, MultipartFile [] files) throws Exception {
		System.out.println("Insert 전 : "+boardVO.getNum());
		int result = boardMapper.setAdd(boardVO);
		System.out.println("Insert 후 : "+boardVO.getNum());
		
		for(MultipartFile mf : files) {
			// 첨부파일이 없을 경우
			if(mf.isEmpty()) {
				continue;
			}
			
			// 1. file을 HDD에 저장
			String fileName = fileManager.fileSave(mf, "resources/upload/board/");
			System.out.println(fileName);
			
			// 2. 저장된 정보를 DB에 저장
			BoardFilesVO boardFilesVO = new BoardFilesVO();
			boardFilesVO.setNum(boardVO.getNum());
			boardFilesVO.setFileName(fileName);
			boardFilesVO.setOriName(mf.getOriginalFilename());
			boardMapper.setFileAdd(boardFilesVO);
		}
		return result;// boardMapper.setAdd(boardVO, files);
	}
	
	public int setUpdate(BoardVO boardVO) throws Exception {
		return boardMapper.setUpdate(boardVO);
	}
	
	public int setDelete(BoardVO boardVO) throws Exception {
		List<BoardFilesVO> ar = boardMapper.getFileList(boardVO);
		int result = boardMapper.setDelete(boardVO);

		if(result > 0) {
//			for(int i=0;i<ar.size();i++) {
//				ar.get(i);
//			}
			//for(Collection에서 꺼낼타입명 변수명: Collection의변수명){}
			for(BoardFilesVO vo:ar) {
				//check가 true면 삭제 성공 false면 삭제 실패
				boolean check= fileManager.remove("resources/upload/board/", vo.getFileName());
				
			}
		}
		return result;
	}
}
