package com.iu.boot3.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.boot3.util.Pager;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardVO> ar = boardService.getList(pager);
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@GetMapping("add")
	public ModelAndView setAdd() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setAdd(BoardVO boardVO, MultipartFile [] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardService.setAdd(boardVO, files);
		
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardVO = boardService.getDetail(boardVO);
		mv.addObject("vo",boardVO);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	@GetMapping("update")
	public String setUpdate(BoardVO boardVO, Model model) throws Exception {
		boardVO = boardService.getDetail(boardVO);
		model.addAttribute("vo",boardVO);
		
		return "board/update";
	}
	
	@PostMapping("update")
	public ModelAndView setUpdate(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardService.setUpdate(boardVO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@GetMapping("delete")
	public ModelAndView setDelete(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardService.setDelete(boardVO);
		mv.setViewName("redirect:./list");
		return mv;
		
	}
}
