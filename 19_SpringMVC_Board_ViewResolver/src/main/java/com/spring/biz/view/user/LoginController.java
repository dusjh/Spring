package com.spring.biz.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

import org.springframework.web.servlet.ModelAndView;
//import com.spring.biz.view.controller.Controller;  //내가 만든거
import org.springframework.web.servlet.mvc.Controller; //스프링에서 제공


public class LoginController implements Controller {

	@Override
	  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception  {
      System.out.println(">> 로그인 처리 ");

      // 1. 사용자가 입력한 데이터(정보) 확인(추출)
      String id = request.getParameter("id");
      String password = request.getParameter("password");
      
      // 2. DB연동작업(id, password 유저 확인)
      UserVO vo = new UserVO();
      vo.setId(id);
      vo.setPassword(password);
      
      UserDAO userDAO = new UserDAO();
      UserVO user = userDAO.getUser(vo);
      
      // 3. 화면 네비게이션 
      // 로그인 성공 : 게시글 목록 보여주기
      // 로그인 실패 : 로그인 화면으로 이동
      ModelAndView mav = new ModelAndView();
      if(user != null) { // 사용자 정보가 있는 경우 
         System.out.println(">> 로그인 성공 ^ㅇ^");
         //returnStr = "getBoardList.do";
         mav.setViewName("redirect:getBoardList.do"); //viewResolver 적용안함
      } else {
         System.out.println(">> 로그인 실패 ㅠ.ㅜ");
         //returnStr = "login";
         mav.setViewName("redirect:login.jsp");  //viewResolver 적용안함
      }
      //return returnStr;
      return mav;
   }

   
}