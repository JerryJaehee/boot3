package com.iu.boot3.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@ModelAttribute("board")
	public String getBoard() {
		return "admin";
	}
	
	@GetMapping("manage")
	public ModelAndView manage() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/manage");
		return mv;
	}
}
