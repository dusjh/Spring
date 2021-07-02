package com.spring.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtil;

// @Repository: DB연동작업 처리하는 클래스에 설정(xxxDAO, xxxDao)
// 		-@Component 상속받아 기능 확장된 어노테이션
@Repository("boardDAO")
public class BoardDAO {
	//JDBC 관련 변수(필드)-JDBC 연결
	private Connection conn;;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//Sql문(JDBC 방식)
	private final String BOARD_INSERT
		= "INSERT INTO BOARD(SEQ,TITLE,WRITER,CONTENT)"
			      +"VALUES((SELECT NVL (MAX(SEQ),0)+1 FROM BOARD),?,?,?)";
	private final String BOARD_UPDATE
		= "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ?";	
	private final String BOARD_DELETE
		= "DELETE FROM BOARD WHERE SEQ = ?";	
	private final String BOARD_GET
		= "SELECT * FROM BOARD WHERE SEQ = ?";	
	private final String BOARD_LIST
		= "SELECT * FROM BOARD ORDER BY SEQ DESC";	
	
	//기본생성자
	public BoardDAO() {
		System.out.println(">> BoardDAO 객체 생성");
	}
	
	//글 입력
	public void insertBoard(BoardVO vo) {
		System.out.println("---> JDBC로 insertBoard() 실행");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	} //3.여기서 insertBoard가 실행이 끝난 후 호출해 준 BoardServiceImpl로 복귀
	
	//글  수정
	public void updateBoard(BoardVO vo) {
		System.out.println("---> JDBC로 updateBoard() 실행");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}
	
	//글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("---> JDBC로 deleteBoard() 실행");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}

	//글 상세 조회(데이터 1개 조회)
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("---> JDBC로 getBoard() 실행");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			
			rs = stmt.executeQuery(); //select 문장에서는 -> executeQuery: 질문을 던져 결과를 받음
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getNString("TITLE"));
				board.setWriter(rs.getNString("WRITER"));
				board.setContent(rs.getNString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return board;
	}

	//게시글 전체 조회
	public List<BoardVO> getBoardList() {
		System.out.println("---> JDBC로 getBoardList() 실행");
		List<BoardVO> list = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			
			rs = stmt.executeQuery(); //select 문장에서는 -> executeQuery: 질문을 던져 결과를 받음
			list = new ArrayList<BoardVO>();
			
			while (rs.next()) { //while문으로 여러 개 반복처리
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getNString("TITLE"));
				board.setWriter(rs.getNString("WRITER"));
				board.setContent(rs.getNString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return list;
	}
}
