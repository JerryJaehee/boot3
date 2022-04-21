package com.iu.boot3.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface MemberMapper {
	public int addFile(MemberFilesVO memberFilesVO) throws Exception;
	
	public int join(MemberVO memberVO) throws Exception;
	
	public MemberVO login(MemberVO memberVO) throws Exception;
	
	public int infoUpdate(MemberVO memberVO) throws Exception;
	
	public MemberVO mypage(MemberVO memberVO) throws Exception;
	
	public int infoDelete(MemberVO memberVO) throws Exception;
	
}
