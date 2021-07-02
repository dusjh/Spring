//UserController에 몰빵

//package com.spring.biz.view.user;
//
//import com.spring.biz.user.UserVO;
//import com.spring.biz.user.impl.UserDAO;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
////@Controller: DispatcherServlet에서 인식할 수 있는 컨트롤러 객체 생성
//@Controller
//public class LoginController{
//
//	/*
//	 * @RequestMapping: 요청과 처리(Controller) 연결(HandlerMapping 역할 대체)
//	 * command 객체 사용: 파라미터로 전달되는 값을 Command객체에 설정
//	 * 1. UserVO 타입 객체 생성
//	 * 2. UserVO 타입 객체에 전달받은 파라미터 값을 설정(이름 일치하는 경우)
//	 * 3. UserVO 타입 객체를 메서드의 파라미터 값으로 전달
//	 */
//	@RequestMapping("/login.do")  //컨텍스트 루트에서 login.do 요청이 들어오면 여기서 처리함
//	public String login(UserVO vo, UserDAO userDAO) {  //UserVO, UserDAO의 객체 받아옴
//      System.out.println(">> 로그인 처리 ");
//      
//      // 1. 사용자가 입력한 데이터(정보) 확인(추출)
//      System.out.println("vo: "+vo);
//      
//      UserVO user = userDAO.getUser(vo);
//      
//      if(user != null) { // 사용자 정보가 있는 경우 
//         System.out.println(">> 로그인 성공 ^ㅇ^!!");
//         return "getBoardList.do";
//      } else {
//         System.out.println(">> 로그인 실패 ㅠ.ㅠ~~");
//         return "login.jsp";
//      }
//   }
//}