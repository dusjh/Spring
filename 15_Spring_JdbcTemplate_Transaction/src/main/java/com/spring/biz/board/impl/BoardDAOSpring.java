package com.spring.biz.board.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtil;

//jdbc형식->스프링
@Repository
public class BoardDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//BoardDAO에 있던 거 그대로
	//Sql문(JDBC 방식)
		private final String BOARD_INSERT
			= "INSERT INTO BOARD(SEQ,TITLE,WRITER,CONTENT)"
				      +"VALUES(?,?,?,?)";
		private final String BOARD_UPDATE
			= "UPDATE BOARD SET TITLE = ?, CONTENT = ?, WHERE SEQ = ?";	
		private final String BOARD_DELETE
			= "DELETE FROM BOARD WHERE SEQ = ?";	
		private final String BOARD_GET
			= "SELECT * FROM BOARD WHERE SEQ = ?";	
		private final String BOARD_LIST
			= "SELECT * FROM BOARD ORDER BY SEQ DESC";	
		
	public BoardDAOSpring() {
		System.out.println(">> BoardDAOSpring() 객체 생성");
			
	}
	//글 입력
		public void insertBoard(BoardVO vo) {
			System.out.println("---> Spring JDBC로 insertBoard() 실행");
			
			//Object[]사용
			Object[] args = {vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent()};
			jdbcTemplate.update(BOARD_INSERT, args);
			
			//이 방법도 가능
			//jdbcTemplate.update(BOARD_INSERT, 
			//				vo.getTitle(), vo.getWriter(), vo.getContent());
		}
		
		//글  수정
		public void updateBoard(BoardVO vo) {
			System.out.println("---> Spring JDBC로 updateBoard() 실행");
			
			Object[] args = {vo.getTitle(), vo.getContent(), vo.getSeq()};
			jdbcTemplate.update(BOARD_UPDATE, args);
		}
		
		//글 삭제
		public void deleteBoard(BoardVO vo) {
			System.out.println("---> Spring JDBC로 deleteBoard() 실행");
			
			jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
		}

		//글 상세 조회(데이터 1개 조회)
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("---> Spring JDBC로 getBoard() 실행");
			
			Object[] args = {vo.getSeq()};
			BoardVO board = jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
			
			return board;
			//또는 return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper()); 이렇게도 가능
		}

		//게시글 전체 조회
		public List<BoardVO> getBoardList() {
			System.out.println("---> Spring JDBC로 getBoardList() 실행");
			return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		}
	
}
