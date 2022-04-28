package com.iu.boot3.product;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@GetMapping("detail")
	public ModelAndView getDetail(ProductVO productVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		//parameter는 productNum
		//모든 구매자가 보는 페이지
		mv.setViewName("product/detail");
		return mv;
	}
	
	@GetMapping("ManageDetail")
	public ModelAndView getManageDetail(ProductVO productVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		//parameter는 productNum
		//판매자가 보는 페이지
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
	public ModelAndView setAdd(ProductVO productVO, MultipartFile [] files,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		productVO.setId(memberVO.getId());
		for(MultipartFile f:files) {
			System.out.println(f.getOriginalFilename());
			System.out.println(f.getSize());
		}
		int result = productService.setAdd(productVO, files);
		//mv.setViewName("redirect:./list"); 동기방식
		mv.setViewName("common/result"); //Ajax
		mv.addObject("result", result);
		return mv;
	}
	
	
	@GetMapping("add")
	public ModelAndView setAdd()throws Exception{
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
}
