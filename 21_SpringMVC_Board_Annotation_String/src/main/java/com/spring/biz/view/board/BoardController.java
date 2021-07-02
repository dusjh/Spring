package com.spring.biz.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
//Board관련 controller
public class BoardController {

	//리턴타입 ModelAndView -> String으로 변경
	//전달할 데이터 저장했던 ModelAndView -> Model 타입으로 변경
	//상세화면
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println(">> 게시글 상세보기");
		BoardVO board = boardDAO.getBoard(vo);
//		mav.addObject("board", board);
//		mav.setViewName("getBoard.jsp");
		
		model.addAttribute("board", board); //Model 객체 사용하여 View로 데이터 전달
		return "getBoard.jsp";
	}
	
	//select
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDAO boardDAO, Model model) {
		System.out.println(">>> 게시글 전체 목록 보여주기");

		List<BoardVO> boardList = boardDAO.getBoardList();		
//		mav.addObject("boardList",boardList);
//		mav.setViewName("getBoardList.jsp");
		
		model.addAttribute("boardList",boardList);
		return "getBoardList.jsp";
	}
	
	//insert
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 입력");
		System.out.println("vo: "+vo);
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	//update
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 수정");
		System.out.println("vo: "+vo);
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	//delete
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 삭제");
		System.out.println("vo: "+vo);
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
	}
}
