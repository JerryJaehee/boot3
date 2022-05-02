package com.iu.boot3.interceptor;

import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iu.boot3.member.MemberVO;
import com.iu.boot3.member.RoleVO;

@Component
public class SellerInterceptor implements HandlerInterceptor{
	
	@Value("${member.role.seller}")
	private String roleName;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean check = false;
		//로그인 한 사용자의 ROLE이 ROLE_SELLER 라면 통과 아니면 거절
		HttpSession session = request.getSession();
		//다형성 
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		
		if(memberVO != null) {
			for(RoleVO roleVO:memberVO.getRoleVOs()) {
				if(roleVO.getRoleName().equals(roleName)) {
					check = true;
				}
			}
		}
		
		// check -> false 면 거절 : servlet 코드 사용 
		// check -> true 면 통과
		if(!check) {
			
			// redirect : response.sendRedirect("url주소")
			
			//mv.addObject("key", value)
			request.setAttribute("msg", "권한이 없습니다.");
			request.setAttribute("path", "../");
			
			// foward 방식 == mv.setViewName("../WEB-INF/view/.jsp 파일경로");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/getResult.jsp");
			view.forward(request, response);
		}
		
		return check;
	}
}
