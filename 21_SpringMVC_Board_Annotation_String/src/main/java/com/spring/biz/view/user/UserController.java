package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@Controller
//User관련 controller
public class UserController {
	
	//로그인
	@RequestMapping("/login.do")  //컨텍스트 루트에서 login.do 요청이 들어오면 여기서 처리함
	public String login(UserVO vo, UserDAO userDAO) {  //UserVO, UserDAO의 객체 받아옴
      System.out.println(">> 로그인 처리 ");
      
      // 1. 사용자가 입력한 데이터(정보) 확인(추출)
      System.out.println("vo: "+vo);
      
      UserVO user = userDAO.getUser(vo);
      
      if(user != null) { // 사용자 정보가 있는 경우 
         System.out.println(">> 로그인 성공 ^ㅇ^!!");
         return "getBoardList.do";
      } else {
         System.out.println(">> 로그인 실패 ㅠ.ㅠ~~");
         return "login.jsp";
      }
   }
	
	//로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">> 로그아웃 처리");
		session.invalidate();
		return "login.jsp";
	}
}
