package com.openref.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	// home 무시 
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value ="/main.do" ,method = RequestMethod.POST)
	public String main(@RequestBody JSONObject data) {
		
		String name =data.get("id").toString();
		System.out.println(name);
		
		return "main";
	}
	@RequestMapping(value = "/login.do")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value = "/loginCheck.do", method = RequestMethod.GET)
	public String loginCheck(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("=============로그인 체크=================");
		
		String returnURL ="";
		String request_nickname = request.getParameter("name");
		
		if(request_nickname!=null) { // 카카오톡이나 네이버에서 세션 값이 넘어오면, 메인으로
			
			returnURL ="main";
			
		}else { // 없으면 로그인 페이지로
			
			returnURL ="login";
		}
		
		return returnURL;
	}
	
	
	
}
