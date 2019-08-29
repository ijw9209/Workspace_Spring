package com.hello.mvc03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hello.mvc03.model.biz.CustomerBiz;
import com.hello.mvc03.model.dto.CustomerDto;

@Controller
public class HomeController {
	
	@Autowired
	private CustomerBiz biz;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "boardlist";
	}
	
	@RequestMapping(value = "/selectone.do", method = RequestMethod.GET)
	public String selectOne(Model model,String id) {
		
		model.addAttribute("dto", biz.selectOne(id));
		
		return "selectone";
	}
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insertForm() {
		
		return "insertform";
		
	}
	@RequestMapping(value = "/insertres.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String insertRes(Model model, CustomerDto dto) {
		
		int res = biz.insert(dto);
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "redirect:list.do";
		}else {
			return "insertform";
		}
		
	}
	@RequestMapping(value = "/updateform.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String updateForm(Model model,String id) {
		
		model.addAttribute("dto", biz.selectOne(id));
		return "updateform";
	}
	@RequestMapping(value = "/updateres.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String updateRes(Model model,CustomerDto dto) {
		int res = biz.update(dto);
	
		if(res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getId()));
			return "redirect:selectone.do?id=" + dto.getId();
		}else {
			model.addAttribute("dto", biz.selectOne(dto.getId()));
			return "updateform";
		}
	}
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(Model model,String id) {
		int res = biz.delete(id);
		
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "redirect:list.do";
		}else {
			model.addAttribute("dto", biz.selectOne(id));
			return "redirect:selectone.do?id=" + id;
		}
	}
}
