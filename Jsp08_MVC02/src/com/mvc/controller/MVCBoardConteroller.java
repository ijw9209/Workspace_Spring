package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.biz.MVCBoardBizImpl;
import com.mvc.dto.MVCBoardDto;

@Controller
public class MVCBoardConteroller {

	@Autowired
	private MVCBoardBizImpl biz;
	
	@RequestMapping("/boardlist.do")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "/WEB-INF/views/boardlist.jsp";
	}
	
	@RequestMapping("/selectone.do")
	public String selectone(@RequestParam("seq") int seq,Model model) {
		MVCBoardDto dto = biz.selectone(seq);
		model.addAttribute("dto" , dto);
		
		
		return "/WEB-INF/views/selectone.jsp";
	}
	
	@RequestMapping(value = "/insertform.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String insertForm() {
		return "/WEB-INF/views/insertform.jsp";
	}
	
	@RequestMapping(value= "/insertres.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String insertRes(@ModelAttribute MVCBoardDto dto , Model model) {
		
		int res = biz.insert(dto);
		
		if(res > 0) {
			model.addAttribute("list" , biz.selectList());
			return "/WEB-INF/views/boardlist.jsp";
		}else {
			return "/WEB-INF/views/insertform.jsp";
		}
	}
	
	@RequestMapping(value= "/updateform.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String updateFrom(Model model , String seq) {
		int no = Integer.parseInt(seq);
		
		model.addAttribute("dto" , biz.selectone(no));
		
		
		return "/WEB-INF/views/updateform.jsp";
		
	}
	
	@RequestMapping(value= "/updateres.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String updateRes(MVCBoardDto dto , Model model,String seq) {
		
		int no = Integer.parseInt(seq);
		int res = biz.update(dto);
		if(res > 0) {
			model.addAttribute("dto" , biz.selectone(no));
			return "/WEB-INF/views/selectone.jsp";
		}else {
			model.addAttribute("dto" , biz.selectone(no));
			return "/WEB-INF/views/updateform.jsp";
		}
		
	}
	@RequestMapping(value="/delete.do" , method = {RequestMethod.GET,RequestMethod.POST} )
	public String delete(Model model , String seq) {
		
		int no = Integer.parseInt(seq);
		int res = biz.delete(no);
		
		if(res > 0) {
			model.addAttribute("list" , biz.selectList());
			return "/WEB-INF/views/boardlist.jsp";
		}else {
			model.addAttribute("dto" , biz.selectone(no));
			return "/WEB-INF/views/selectone.jsp";
		}
		
		
	}
}
