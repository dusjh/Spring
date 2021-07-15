package com.spring.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public BoardDAOMybatis() {
		System.out.println("BoardDAOMybatis() 객체 생성");
	}
	
	//글입력
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring Mybatis로 insertBoard() 실행");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	//글수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring Mybatis로 updateBoard() 실행");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	//글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring Mybatis로 deleteBoard() 실행");
		mybatis.delete("BoardDAO.updateBoard", vo);
	}

	//글상세조회(데이터 하나 조회)
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring Mybatis로 getBoard() 실행");
		return mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	//글 전체 조회1
	public List<BoardVO> getBoardList() {
		System.out.println("===> Spring Mybatis로 getBoardList() 실행");
		return null;
	}
	//글 전체 조회2
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring Mybatis로 getBoardList(vo) 실행");
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}	
}
	

