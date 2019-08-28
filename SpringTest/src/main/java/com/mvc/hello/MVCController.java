package com.mvc.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.hello.dto.MVCBoardDto;
import com.mvc.hello.model.MVCBizImpl;

@Controller
public class MVCController {
	
	@Autowired
	private MVCBizImpl biz;
	
	@RequestMapping("boardlist.do")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "boardlist";
	}
	
	@RequestMapping("insertform.do")
	public String insertFrom() {
		
		return "insertform";
	}
	
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "insertres.do")
	public String insertRes(Model model , MVCBoardDto dto) {
	
		int res = biz.insert(dto);
		if(res > 0) {
			model.addAttribute("list" , biz.selectList());
			return "redirect:boardlist.do";
		}else {
			return "insertform";
		}
	}
	@RequestMapping("selectone.do")
	public String selectOne(Model model , int seq) {
		
		model.addAttribute("dto", biz.selectone(seq));
		
		return "selectone";
	}
	
	@RequestMapping("updateform.do")
	public String updateForm(Model model, int seq) {
		
		model.addAttribute("dto", biz.selectone(seq));
		
		return "updateform";
	}
	
	@RequestMapping("updateres.do")
	public String updateRest(Model model , MVCBoardDto dto,int seq) {
		
		int res = biz.update(dto);
		if(res > 0) {
			model.addAttribute("dto" , biz.selectone(seq));
			return "selectone";
		}else {
			model.addAttribute("dto", biz.selectone(seq));
			return "updateform";
		}
		
	}
	@RequestMapping("delete.do")
	public String deleteRes(Model model , int seq) {
		int res = biz.delete(seq);
		if(res > 0) {
			model.addAttribute("list" , biz.selectList());
			return "redirect:boardlist.do";
		}else {
			model.addAttribute("dto" , biz.selectone(seq));
			return "selectone";
		}
	}
	
}
