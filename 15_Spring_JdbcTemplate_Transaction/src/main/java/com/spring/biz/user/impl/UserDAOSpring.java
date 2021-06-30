package com.spring.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.biz.user.UserVO;

@Repository
public class UserDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Sql문
	private final String USER_GET
			= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
		
	//기본생성자
	public UserDAOSpring() {
			System.out.println(">> UserDAOSpring() 객체 생성");
		}
	
	public UserVO getUser(UserVO vo) {
		System.out.println("---> Spring JDBC로 getUser() 실행");
		Object[] args = {vo.getId(), vo.getPassword()};
		
		//queryForObject: 데이터 하나 가져올때
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}
		
}
