package com.iu.boot3.product;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.boot3.member.MemberVO;
import com.iu.boot3.util.Pager;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "product";
	}
	
	@PostMapping("fileDelete")
	public ModelAndView setFileDelete(ProductFilesVO productFilesVO) throws Exception {
		ModelAndView mv = new ModelAndView();

		int result = productService.setFileDelete(productFilesVO);
		
		mv.setViewName("common/result");
		mv.addObject("result",result);
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView setUpdate(ProductVO productVO, MultipartFile [] files) throws Exception {
		ModelAndView mv = new ModelAndView();

		int result = productService.setUpdate(productVO, files);
		if(result>0) {
			mv.setViewName("redirect:./manage");
		}else {
			mv.setViewName("common/getResult.jsp");
			mv.addObject("msg", "수정 실패했습니다.");
			mv.addObject("path","./manageDetail?productNum="+productVO.getProductNum());
		}
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setUpdate(ProductVO productVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		productVO = productService.getDetail(productVO);
		mv.addObject("vo", productVO);
		mv.setViewName("product/update");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getDetail(ProductVO productVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		//parameter는 productNum
		//모든 구매자가 보는 페이지
		productVO = productService.getDetail(productVO);
		mv.addObject("vo",productVO);
		mv.setViewName("product/detail");
		return mv;
	}
	
	@GetMapping("manageDetail")
	public ModelAndView getManageDetail(ProductVO productVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		//parameter는 productNum
		//판매자가 보는 페이지
		productVO = productService.getDetail(productVO);
		mv.addObject("vo",productVO);
		mv.setViewName("product/manageDetail");
		return mv;
	}
	
	@GetMapping("manage")
	public ModelAndView manage(Pager pager,HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		pager.setId(memberVO.getId());
		List<ProductVO> ar = productService.getList(pager);
		mv.addObject("list",ar);
		mv.setViewName("product/manage");
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setAdd(@Valid ProductVO productVO, BindingResult bindingResult, MultipartFile [] files,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mv.setViewName("product/add");
			return mv;
		}
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		productVO.setId(memberVO.getId());

		int result = productService.setAdd(productVO, files);
		//mv.setViewName("redirect:./list"); 동기방식
		mv.setViewName("common/result"); //Ajax
		mv.addObject("result", result);
		return mv;
	}
	
	
	@GetMapping("add")
	public ModelAndView setAdd(@ModelAttribute ProductVO productVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("product/add");
		return mv;
	}
	
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<ProductVO> list = productService.getList(pager);
		mv.addObject("list", list);
		mv.addObject("pager", pager);
		mv.setViewName("product/list");
		
		return mv;
	}
	
	@GetMapping("ajaxList")
	public ModelAndView ajaxList(Pager pager, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		pager.setId(memberVO.getId());
		List<ProductVO> ar = productService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager",pager);
		mv.setViewName("common/productList");
		return mv;
	}
	
//	//예외처리 메서드
//	@ExceptionHandler(BindException.class)
//	public ModelAndView ex1() {
//		ModelAndView mv = new ModelAndView();
//			System.out.println("예외 발생 처리");
//			mv.setViewName("error/error");
//		return mv;
//	}
//	
//	@ExceptionHandler(NullPointerException.class)
//	public ModelAndView ex2() {
//		ModelAndView mv = new ModelAndView();
//			System.out.println("Nullpointer 예외 발생 처리");
//			mv.setViewName("error/error");
//		return mv;
//	}
//	
//	@ExceptionHandler(Exception.class)
//	public ModelAndView ex3() {
//		ModelAndView mv = new ModelAndView();
//			System.out.println("Exception 예외 발생 처리");
//			mv.setViewName("error/error");
//		return mv;
//	}
//	
//	@ExceptionHandler(Throwable.class)
//	public ModelAndView ex4() {
//		ModelAndView mv = new ModelAndView();
//			System.out.println("Throwable 예외 발생 처리");
//			mv.setViewName("error/error");
//		return mv;
//	}
}
