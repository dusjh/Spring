package com.spring.biz.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

@Controller
@RestController
public class BoardAjaxController {
   @Autowired
   private BoardService boardService;
   
   @RequestMapping("/getJsonBoardList.do")
   //@ResponseBody //뷰페이지x response 객체의 몸체(body)에 데이터 전달
   public List<BoardVO> getAjaxBoardList(){
      List<BoardVO> boardList = boardService.getBoardList();
      System.out.println("boardList : "+boardList);
      
      return boardList;
   }
   
   @RequestMapping(value="/getJsonBoard.do", method=RequestMethod.POST, 
		   		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
   //@ResponseBody
   public BoardVO getAjaxBoard(@RequestBody BoardVO vo) {
	   System.out.println("vo: "+vo);
	   BoardVO board = boardService.getBoard(vo);
	   System.out.println("board: "+board);
	   return board;
   }
}