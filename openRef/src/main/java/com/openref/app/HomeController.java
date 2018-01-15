package com.openref.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/main.do", method=RequestMethod.GET)
	   public String main(@RequestParam("id") String id, @RequestParam("name") String nickname , @RequestParam("image") 
	   String profile_image) {
	      
	      System.out.println(id);
	   
	      return "main";
	   }
	@RequestMapping(value = "/login.do")
	public String login() {
		
		return "login";
	}
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
	
		session.invalidate();
		return "redirect:/login.do";
	}
	@RequestMapping(value = "/ref/mainRef.do")
	public String mainRef() {
		
		return "/ref/mainRef";
	}
	@RequestMapping(value = "/ref/selectRef.do")
	public String selectRef() {
	
		return "/ref/selectRef";
	}
	
}
