package com.iu.boot3.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public ModelAndView join() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		
		return mv;
	}
	
	@PostMapping("join")
	public ModelAndView join(MemberVO memberVO, MultipartFile proFile) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = memberService.join(memberVO, proFile);
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("login")
	public ModelAndView login(@CookieValue(value="remember",defaultValue ="", required = false)String rememberId) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/login");
		return mv;
	}
	
	@PostMapping("login")
	public String login(MemberVO memberVO, HttpSession session,String remember, Model model, HttpServletResponse response) throws Exception {
		System.out.println("Remember : "+remember);
		System.out.println("id :"+memberVO.getId());
		System.out.println("pw : "+memberVO.getPw());
		
		if(remember != null && remember.equals("1")) {
			//cookie 생성
			Cookie cookie = new Cookie("remember", memberVO.getId());
			//cookie.setPath("/");
			cookie.setMaxAge(-1);
			//응답
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		memberVO = memberService.login(memberVO);
		
//		String path="redirect:./login";
//		
//		if(memberDTO != null) {
//			session.setAttribute("member", memberDTO);
//			path = "redirect:../";
//		}
		
		String message="Login Fail";
		String p="./login";
		
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			message="Login Success";
			p="../";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", p);
		String path="common/result";
		return path;
	}
	
	@GetMapping("mypage")
	public ModelAndView mypage(HttpSession httpSession) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO)httpSession.getAttribute("member");
		memberService.mypage(memberVO);
		mv.addObject("memberVO",memberVO);
		mv.setViewName("member/mypage");
		return mv;
	}
}
