package com.spring.biz.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

//@WebServlet("*.do") //web.xml에 있는 설정 사용(충돌되면 실행x)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	@Override
	public void init() throws ServletException {
		super.init();
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");  //위치경로
		viewResolver.setSufix(".jsp"); //파일타입(확장명)
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//요청처리 작업 진행
		System.out.println(">> DispatcherServlet.process(): *.do 요청에 대한 처리");
		
		//1. 클라이언트에서 어떤 작업을 요청했는지 확인하기
		String uri = request.getRequestURI();
		System.out.println("uri: "+uri);    //  /biz/login.do
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path: "+path);  //  /login.do
		
		//2. 클라이언트의 요청 path에 따라서 작업 처리
		Controller ctrl = handlerMapping.getController(path);
		System.out.println(">>ctrl: "+ctrl);
		
		//3. 검색된 컨트롤러 실행(컨트롤러 handleRequest 메서드 실행)
		String viewName = ctrl.handleRequest(request, response);
		System.out.println(">>viewName: "+viewName);
		
		//4. 이동할 view 이름 정보 작성하고 응답페이지 호출
		String view = null; //최종 요청 처리할 URL 값
		if(viewName.contains(".do")) {
			view = viewName;
		} else {
			view = viewResolver.getView(viewName);
		}
		
		//5. 재요청처리
		response.sendRedirect(view);
	}
}
