package com.spring.biz.user;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.board.impl.BoardServiceImpl;

public class UserServiceClient {

	public static void main(String[] args) {
		System.out.println("----- 스프링 컨테이너 구동전 ------");
		//1. 스프링컨테이너 구동(스프링 설정 파일 읽어서)
		GenericXmlApplicationContext container 
				= new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("----- 스프링 컨테이너 구동후 ------");
				
		//2. 스프링컨테이너 사용
		UserService userService = (UserService) container.getBean("userService");
		
		//2-1. 입력
		UserVO vo = new UserVO();
		vo.setId("user1");
		vo.setPassword("user1");
		
		//사용자 조회
		UserVO user = userService.getUser(vo);
		System.out.println("user : " + user);
		
		//3. 스프링컨테이너 종료(close)
		System.out.println("----- 스프링 컨테이너 종료처리 ------");
		container.close();

	}

}
