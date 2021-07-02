package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">> 로그아웃 처리");
		session.invalidate();
		return "login.jsp";
	}
	
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		//1. 세션 초기화(세션 객체 무효화)
//		request.getSession().invalidate();
//		
//		//2. 화면 네비게이션(로그인 페이지)
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("login.jsp");
//		return mav;
//	}

}
