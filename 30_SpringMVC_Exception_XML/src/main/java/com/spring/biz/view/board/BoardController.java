package com.spring.biz.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

@Controller
@SessionAttributes("board") //board 라는 이름의 Model 있으면 session에 저장
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	public BoardController() {
		System.out.println("===>> BoardController() 객체 생성");
	}

	// 메소드에 선언된 @ModelAttribute 는 리턴된 데이터를 View에 전달
	// @ModelAttribute 선언된 메소드는 @RequestMapping 메소드보다 먼저 실행
	// 뷰에 전달될 때 설정된 명칭(예: conditionMap)으로 전달
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		System.out.println("--->>> @ModelAttribute - Map searchConditionMap() 실행");
		// key: 제목, value: TITLE
		// key: 내용, value: CONTENT
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println(">>> 게시글 상세 보기");
		BoardVO board = boardService.getBoard(vo);
		System.out.println("getBoard DB board : " + board);
		model.addAttribute("board", board); //Model 객체사용 View로 데이터 전달
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println(">>> 게시글 전체 목록 보여주기");
		System.out.println("vo : " + vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}	
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		System.out.println(">>> 게시글 입력 - insertBoard()");
		System.out.println("vo : " + vo);
		/*
		 * 파일업로드 관련 처리
		 * MultipartFile 인터페이스 주요 메서드
		 * getOriginalFilename(): 업로드할 파일명 찾기
		 * transferTo(File dest): 업로드할 파일을 업로드 처리(저장 위치)
		 * boolean isEmpty(): 업로드 파일 존재 여부 (없으면 true 리턴)
		 * 같은 파일이면 덮어쓰기 처리됨
		 * 한글, 특수문자는 오류 발생위험이 높으니 영어소문자, 숫자, - 등으로만 파일명 지정할 것
		 */
		MultipartFile uploadFile = vo.getUploadFile();
		System.out.println(">> uploadFile: "+uploadFile);
		
		if(!uploadFile.isEmpty()) {  //uploadFile이 비어있지 않으면
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:\\MyStudy\\temp\\"+fileName));
		}
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}	
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println(">>> 게시글 수정");
		System.out.println("update vo : " + vo);
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}	
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println(">>> 게시글 삭제");
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}	
}









