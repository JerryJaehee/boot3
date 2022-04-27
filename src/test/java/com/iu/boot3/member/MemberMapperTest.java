package com.iu.boot3.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	//@Test
//	public void joinTest() throws Exception {
//		MemberVO memberVO = new MemberVO();
//		memberVO.setId("id1234");
//		memberVO.setPw("1234");
//		memberVO.setName("name");
//		memberVO.setEmail("email");
//		memberVO.setPhone("010-1111-1111");
//		int result = memberMapper.join(memberVO);
//		
//		assertEquals(1, result);
//	}
//	
//	//@Test
//	public void loginTest() throws Exception {
//		MemberVO memberVO = new MemberVO();
//		memberVO.setId("id1234");
//		memberVO.setPw("1234");
//		memberVO = memberMapper.login(memberVO);
//		System.out.println(memberVO);
//	}
//	
//	//@Test
//	public void mypageTest() throws Exception {
//		MemberVO memberVO = new MemberVO();
//		memberVO.setId("id1234");
//		memberVO = memberMapper.mypage(memberVO);
//		System.out.println(memberVO);
//		
//		assertNotNull(memberVO);
//	}
//	
//	//@Test
//	public void infoUpdate() throws Exception {
//		MemberVO memberVO = new MemberVO();
//		memberVO.setId("id1234");
//		memberVO.setPw("1234");
//		memberVO.setName("nameUpdate");
//		memberVO.setEmail("emailUpdate");
//		memberVO.setPhone("010-2222-2222");
//		int result = memberMapper.infoUpdate(memberVO);
//		
//		assertEquals(1, result);
//		
//	}
//	
//	@Test
//	public void infoDelete() throws Exception {
//		MemberVO memberVO = new MemberVO();
//		memberVO.setId("id1234");
//		memberVO.setPw("1234");
//		
//		int result = memberMapper.infoDelete(memberVO);
//		assertEquals(1, result);
//	}

}
