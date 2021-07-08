package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@Controller
//User관련 controller
public class UserController {
	
	//로그인 - 요청방식 post 처리
	//@RequestMapping(value= "/login.do", method= RequestMethod.POST)  //컨텍스트 루트에서 login.do 요청이 들어오면 여기서 처리함
	@PostMapping("/login.do")  //스프링 4.3부터 추가됨
	public String login(UserVO vo, UserDAO userDAO) {  //UserVO, UserDAO의 객체 받아옴
      System.out.println(">> 로그인 처리 - login() ");
      
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
	/*
	 * @ModelAttribute(속성명): 모델의 속성값으로 저장(속성명 별도 지정)
	 * 별도의 명칭 부여 안하면 <데이터 타입>의 첫글자 소문자로 작성된 명칭 사용
	 * @ModelAttribute("user") ->속성명 user(login.jsp에서 사용)
	 */
	//로그인 - 화면 이동(요청 방식 get 처리)
	//@RequestMapping(value= "/login.do", method= RequestMethod.GET)
	@GetMapping("/login.do")	
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println(">> 로그인 화면이동 - loginView()");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	//로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">> 로그아웃 처리");
		session.invalidate();
		return "login.jsp";
	}
}
