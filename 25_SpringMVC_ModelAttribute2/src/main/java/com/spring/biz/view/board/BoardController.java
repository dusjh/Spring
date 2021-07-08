package com.spring.biz.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
//Board관련 controller
public class BoardController {

	//메서드에 선언된 @ModelAttribute는 리턴된 데이터를 View에 전달
	//@ModelAttribute 선언된 메서드는 @RequestMapping 메서드 보다 먼저 실행
	//View에 전달될 때 설정된 명칭 ("conditionMap")으로 전달된다.
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		System.out.println(">> @ModelAttribute - Map searchConditionMap() 실행");
		//key: 제목, value: TITLE
		//key: 내용, value: CONTENT
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
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
	public String getBoardList(BoardVO vo,	BoardDAO boardDAO, Model model) {
		System.out.println(">>> 게시글 전체 목록 보여주기");
		System.out.println("vo: "+vo);

		List<BoardVO> boardList = boardDAO.getBoardList(vo);		
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
