package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

// @Service: @Component 상속 확장 어노테이션
//		-비즈니스 로직 처리 서비스 영역에 사용
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired  //타입이 일치하는 객체(인스턴스) 주입
	//private BoardDAO boardDAO; jdbc 방식으로 실행됨
	private BoardDAOSpring boardDAO; 	//스프링 방식으로 실행
	
	
	public BoardServiceImpl() {
		System.out.println(">> BoardServiceImpl() 객체 생성");
	}

	@Override
	public void insertBoard(BoardVO vo) {
		//똑같은 숫자가 들어가면 unique constraint violated -> 둘다 RollBack 됨
		//트랜잭션 처리하면 둘다 디비에 반영x(두개를 한 덩어리로 처리, 하나씩 처리x)
		vo.setSeq(111);
		boardDAO.insertBoard(vo);
		vo.setSeq(111);
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
		
	}

}
