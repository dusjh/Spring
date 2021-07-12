package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("===>>>> UserController() 객체 생성");
	}

	//요청방식 POST에 대한 처리
	//@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@PostMapping("/login.do") // 4.3 부터 추가됨
	public String login(UserVO vo) {
		System.out.println(">>>로그인 처리 - login()");
		System.out.println("vo : " + vo);
		
		UserVO user = userService.getUser(vo);
		if (user != null) {
			System.out.println("> 로그인 성공!!!");
			return "getBoardList.do";
		} else {
			System.out.println("> 로그인 실패~~~");
			return "login.jsp";
		}
	}
	
	/* @ModelAttribute : 모델의 속성값으로 저장(속성명 별도지정)
	별도의 명칭 부여 안하면 <데이터타입>의 첫글자 소문자로 작성된 명칭 사용
	@ModelAttribute UserVO --> 속성명 userVO 형태
	@ModelAttribute("user") UserVO --> 속성명 user 사용
	***********************/
	//요청방식 GET에 대한 처리
	//@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	@GetMapping("/login.do")
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println(">>> 로그인 화면이동 - loginView()");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">>> 로그아웃 처리");
		session.invalidate();
		return "login.jsp";
	}
	
}
