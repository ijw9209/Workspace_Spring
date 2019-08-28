package com.mvc.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.board.model.MVCBIZImpl;
import com.mvc.board.model.MVCDto;


@Controller
public class MVCController {
	
	@Autowired
	private MVCBIZImpl biz;
	
	@RequestMapping(value = "/boardlist.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String selectList(Model model){
		
		model.addAttribute("list" , biz.selectList());
		
		
		return "boardlist";
	}
	
	@RequestMapping(value = "/selectone.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String selectone(int seq, Model model) {
		model.addAttribute("dto" , biz.selectone(seq));
		
		
		return "selectone";
	}
	
	@RequestMapping(value="/insertform.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String insertForm() {
		
		
		return "insertform";
		
	}
	@RequestMapping(value="/insertres.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String insertRes(@ModelAttribute MVCDto dto , Model model) {
		
		int res = biz.insert(dto);
		if(res > 0) {
			model.addAttribute("list" , biz.selectList());
			return "boardlist";
		}else {
			return "insertform";
		}
	}
	
	@RequestMapping(value= "/updateform.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String updateFrom(Model model , String seq) {
		int no = Integer.parseInt(seq);
		
		model.addAttribute("dto" , biz.selectone(no));
		
		
		return "updateform";
	}
	@RequestMapping(value= "/updateres.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String updateRes(MVCDto dto , Model model,String seq) {
		
		int no = Integer.parseInt(seq);
		int res = biz.update(dto);
		if(res > 0) {
			model.addAttribute("dto" , biz.selectone(no));
			return "selectone";
		}else {
			model.addAttribute("dto" , biz.selectone(no));
			return "updateform";
		}
		
	}
	@RequestMapping(value="/delete.do" , method = {RequestMethod.GET,RequestMethod.POST} )
	public String delete(Model model , String seq) {
		
		int no = Integer.parseInt(seq);
		int res = biz.delete(no);
		
		if(res > 0) {
			model.addAttribute("list" , biz.selectList());
			return "boardlist";
		}else {
			model.addAttribute("dto" , biz.selectone(no));
			return "selectone";
		}
		
		
	}
	
}
