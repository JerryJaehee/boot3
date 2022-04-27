package com.iu.boot3.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface MemberMapper {
	//파일 detail
	public MemberFilesVO getFileDetail(MemberVO memberVO)throws Exception;
	
	
	//파일 추가
	public int setFileAdd(MemberFilesVO memberFilesVO)throws Exception;
	
	//회원 탈퇴
	public int setDelete(MemberVO memberVO)throws Exception;
	
	//회원 수정
	public int setUpdate(MemberVO memberVO)throws Exception;
	
	//myPage
	public MemberVO getDetail(MemberVO memberVO)throws Exception;
	
	//로그인
	public MemberVO getLogin(MemberVO memberVO)throws Exception;
	
	//회원가입
	public int setAdd(MemberVO memberVO)throws Exception;

}
