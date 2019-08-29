package com.hello.mvc03;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
	
	
	@RequestMapping(value = "/list.do", method = {RequestMethod.POST ,RequestMethod.GET})
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		return "boardlist";
	}
	@RequestMapping(value = "/insertform.do", method = RequestMethod.GET)
	public String inserForm() {
		
		return "insertform";
	}
	@RequestMapping(value = "/insertres.do", method = RequestMethod.POST)
	public String insertRes(Model model , CustomerDto dto) {
		
		int res = biz.insert(dto);
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "redirect:list.do";
		}else {
			return "insertform";
		}
	}
	@RequestMapping(value = "/selectone.do", method = {RequestMethod.POST ,RequestMethod.GET})
	public String selectOne(Model model , String id) {
		
		model.addAttribute("dto", biz.selectOne(id));
		
		return "selectone";
	}
	@RequestMapping(value = "/updateform.do", method = RequestMethod.GET)
	public String updateForm(Model model , String id) {
		
		model.addAttribute("dto" , biz.selectOne(id));
		return "updateform";
	}
	@RequestMapping(value = "/updateres.do", method = {RequestMethod.POST ,RequestMethod.GET})
	public String updateRes(Model model, CustomerDto dto) throws UnsupportedEncodingException {
		
		int res = biz.update(dto);
		String id = URLEncoder.encode(dto.getId(), "UTF-8");
		if(res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getId()));
			return "redirect:selectone.do?id="+id;
		}else {
			return "updateform";
		}
	}
	@RequestMapping(value = "/delete.do", method = {RequestMethod.POST ,RequestMethod.GET})
	public String delete(Model model , String id) {
		int res = biz.delete(id);
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "redirect:list.do";
		}else {
			model.addAttribute("dto", biz.selectOne(id));
			return "selectone";
		}
		
	}
	
}
