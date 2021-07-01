package com.spring.biz.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.view.controller.Controller;

public class GetBoardListController implements Controller {

	//getBoardList.do 요청이 들어왔을때 여기서 처리
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>> 게시글 전체 목록 보여주기");
		//1. 게시글 목록 조회(SELECT)
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		//2. 검색결과를 세션에 저장(목록 화면으로 이동)
		request.getSession().setAttribute("boardList",boardList);
		
		//3. 화면 이동
		//response.sendRedirect("getBoardList.jsp");
		return "getBoardList";
	}

}
