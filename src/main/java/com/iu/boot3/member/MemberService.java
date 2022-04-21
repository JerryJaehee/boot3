package com.iu.boot3.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.boot3.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FileManager fileManager;
	
	public int join(MemberVO memberVO, MultipartFile proFile) throws Exception {
		
		int result = memberMapper.join(memberVO);
		
		// 파일을 HDD에 저장
		String fileName = fileManager.fileSave(proFile, "resources/upload/member/");
		
		// 정보를 DB에 저장 (파일명)
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setId(memberVO.getId());
		memberFilesVO.setFileName(fileName);
		memberFilesVO.setOriName(proFile.getOriginalFilename());
		memberMapper.addFile(memberFilesVO);
		
		return result;
	}
	
	public MemberVO login(MemberVO memberVO) throws Exception {
		return memberMapper.login(memberVO);
	}
	
	public MemberVO mypage(MemberVO memberVO) throws Exception {
		return memberMapper.mypage(memberVO);
	}
}
