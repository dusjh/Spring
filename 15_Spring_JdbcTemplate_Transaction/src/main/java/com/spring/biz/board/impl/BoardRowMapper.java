package com.spring.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.biz.board.BoardVO;
import com.spring.biz.user.UserVO;

public class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getNString("TITLE"));
		board.setWriter(rs.getNString("WRITER"));
		board.setContent(rs.getNString("CONTENT"));
		board.setRegdate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		
		return board;
	}

}
