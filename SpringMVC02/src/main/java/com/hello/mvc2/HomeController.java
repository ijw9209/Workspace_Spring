package com.hello.mvc2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc2.model.HelloBiz;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private HelloBiz biz;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
										// method = RequestMethod.GET get 으로 넘어왔을때 동작
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("/hello.do")
	public String hello(Model model) {
		
		//request.setAttribute("message , biz.getHello());
		model.addAttribute("message", biz.getHello());
		
		
		return "hello";
		
	}
	
	@RequestMapping(value="/bye.do" , method = RequestMethod.GET)
		public String getbye(String name,Model model) {
			//@RequestParam("name") name이란 같은 이름으로 넘어와서 자동으로 받아짐 같은이름으로 할때만 무조건
		model.addAttribute("message" , "bye , " + name);
		
		return "bye";
		}
}
