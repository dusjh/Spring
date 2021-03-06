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
		/*
		 * URI는 식별하고, URL은 위치를 가르킨다. 실세계에 빗대어 예시를 들어보자면 다음과 같다. 
		 * “Charles” 는 내 이름이며 식별자(Identifier)다. 
		 * 이는 URI와 비슷하지만 내 위치나 연락처에 대한 정보가 없으므로 URL은 될 수 없다.
		 */
		String uri = request.getRequestURI();
		System.out.println("uri: "+uri);    //  /biz/login.do
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path: "+path);  //  /login.do
		
		//2. 클라이언트의 요청 형태에 따른 작업 처리
		if ("/login.do".equals(path)) {
			System.out.println(">> 로그인 처리");
			//1. 사용자 입력한 데이터(정보) 확인(추출)
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. DB연동 작업(id, password 유무 확인)
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			//3. 화면 네비게이션 (화면이동)
			//로그인 성공: 게시글 목록 보여주기
			//로그인 실패: 로그인 화면으로 이동
			if(user != null) { //사용자 정보가 있는 경우
				System.out.println("> 로그인 성공!");
				response.sendRedirect("getBoardList.do");
			} else {
				System.out.println("> 로그인 실패ㅠ");
				response.sendRedirect("login.jsp");
			}		
		} else if ("/logout.do".equals(path)) {
			System.out.println(">> 로그아웃 처리");
			//1. 세션 초기화(세션 객체 무효화)
			request.getSession().invalidate();
			
			//2. 화면 네비게이션(로그인 페이지)
			response.sendRedirect("login.jsp");
		} else if("/getBoardList.do".equals(path)) {
			System.out.println(">>> 게시글 전체 목록 보여주기");
			//1. 게시글 목록 조회(SELECT)
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList();
			
			//2. 검색결과를 세션에 저장(목록 화면으로 이동)
			request.getSession().setAttribute("boardList",boardList);
			
			//3. 화면 이동
			response.sendRedirect("getBoardList.jsp");
		} else if ("/getBoard.do".equals(path)) {
			System.out.println(">> 게시글 상세보기");

			//1. 전달받은 데이터 추출(확인)
			String seq = request.getParameter("seq");
			
			//2. DB연동 처리(글 하나 조회)
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			//3. 검색 결과를 세션에 저장(뷰에서 사용토록)
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			//4. 상세보기 화면으로 이동
			response.sendRedirect("getBoard.jsp");
			
		} else if("/insertBoard.do".equals(path)) {
            System.out.println(">>> 게시글 입력");
            //1. 전달받은 데이터 추출(확인)
            String title = request.getParameter("title");
            String writer = request.getParameter("writer");
            String content = request.getParameter("content");
            
            //2. DB연동 처리(데이터 입력)
            BoardVO vo = new BoardVO();
            vo.setTitle(title);
            vo.setWriter(writer);
            vo.setContent(content);
            
            BoardDAO boardDAO = new BoardDAO();
            boardDAO.insertBoard(vo);
            
            //3. 화면 네비게이션(목록페이지로 이동)
            response.sendRedirect("getBoardList.do");
            
		} else if("/updateBoard.do".equals(path)) {
            System.out.println(">>> 게시글 수정");
            //1. 전달받은 데이터 추출(확인)
            String seq = request.getParameter("seq");
            String title = request.getParameter("title");
            String writer = request.getParameter("writer");
            String content = request.getParameter("content");
            
            //2. DB연동 처리(데이터 입력)
            BoardVO vo = new BoardVO();
            vo.setSeq(Integer.parseInt(seq));
            vo.setTitle(title);
            vo.setWriter(writer);
            vo.setContent(content);
            
            BoardDAO boardDAO = new BoardDAO();
            boardDAO.updateBoard(vo);
            
            //3. 화면 네비게이션(목록페이지로 이동)
            response.sendRedirect("getBoardList.do");
		
		} else if("/deleteBoard.do".equals(path)) {
            System.out.println(">>> 게시글 삭제");
            //1. 전달받은 데이터 추출(확인)
            String seq = request.getParameter("seq");
            
            //2. DB연동 처리(데이터 입력)
            BoardVO vo = new BoardVO();
            vo.setSeq(Integer.parseInt(seq));
            
            BoardDAO boardDAO = new BoardDAO();
            boardDAO.deleteBoard(vo);
            
            //3. 화면 네비게이션(목록페이지로 이동)
            response.sendRedirect("getBoardList.do");
		} 
	}
}
