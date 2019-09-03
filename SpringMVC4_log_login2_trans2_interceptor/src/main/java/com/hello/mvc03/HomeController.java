package com.hello.mvc03;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.mvc03.dto.CustomerDto;
import com.hello.mvc03.model.biz.CustomerBiz;

@Controller
public class HomeController {
	
	@Autowired
	private CustomerBiz biz;
	
	@RequestMapping(value = "/list.do" , method = RequestMethod.GET)
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		
		return "boardlist";
	}
	
	@RequestMapping(value="/insert.do" , method = RequestMethod.GET)
	public String insertform() {
		
		
		return "insertform";
	}
	@RequestMapping(value ="/insertres.do" , method = {RequestMethod.GET , RequestMethod.POST})
	public String insertRes(Model model , CustomerDto dto) {
		
		int res = biz.insert(dto);
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "redirect:list.do";
		}else {
			return "insertform";
		}
		
	}
	@RequestMapping(value ="/selectone.do" , method = {RequestMethod.GET , RequestMethod.POST})
	public String selectOne(Model model , String id) {
		
		model.addAttribute("dto", biz.selectOne(id));
		
		return "selectone";
		
	}
	@RequestMapping(value ="/updateform.do" , method = {RequestMethod.GET , RequestMethod.POST})
	public String updateform(Model model,String id) {
		
		model.addAttribute("dto", biz.selectOne(id));
		
		return "updateform";
	}
	@RequestMapping(value ="/updateres.do" , method = {RequestMethod.GET , RequestMethod.POST})
	public String updateRes(Model model , CustomerDto dto) {
		
		int res = biz.update(dto);
		if(res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getId()));
			return "redirect:selectone.do?id="+dto.getId();
		}else {
			return "updateform";
		}
		
	}
	@RequestMapping(value ="/delete.do" , method = {RequestMethod.GET , RequestMethod.POST})
	public String delete(Model model , String id) {
		
		int res = biz.delete(id);
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "redirect:list.do";
		}else {
			model.addAttribute("dto", biz.selectOne(id));
			return "redirect:selectone.do?id="+id;
		}
		
		
	}
	@RequestMapping(value="/loginform.do" , method = RequestMethod.GET)
	public String login() {
		
		
		return "login";
	}
	
	@RequestMapping(value="/loginajax.do")
	@ResponseBody
	public Map<String, Boolean> loginAjax(String id , String pw, HttpSession session) {
		//@ResponseBody : java 객체를 response 객체에 binding
		
		CustomerDto dto = biz.login(id, pw);
		boolean loginchk = false;
		
		
		if(dto != null) {
			session.setAttribute("dto", dto);
			loginchk = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("loginchk",loginchk);
		
		
		
		return map;
	}

	@RequestMapping("/test.do")
	public String test() {
		
		
		biz.test();
		
		return "redirect:/list.do";
	}
	
}
