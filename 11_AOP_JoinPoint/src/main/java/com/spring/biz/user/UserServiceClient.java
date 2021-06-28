package com.spring.biz.user;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
	 System.out.println("------ 스프링 컨테이너 구동 전 ------");
      //1. 스프링컨테이너 구동(스프링 설정 파일 읽어서)
      GenericXmlApplicationContext container 
            = new GenericXmlApplicationContext("applicationContext_after-returning.xml");
      
      System.out.println("------ 스프링 컨테이너 구동 후 ------");
      
      //2. 스프링컨테이너 사용
      UserService userService = (UserService)container.getBean("userService");
      
      //2-1. 입력
      UserVO vo = new UserVO();
//      vo.setId("test");
//      vo.setPassword("test");
      if(vo != null) {
    	  vo.setId("test");
    	  vo.setPassword("test");  	  
      } 
      //2-2. 사용자 조회
      UserVO uvo = userService.getUser(vo);
      System.out.println("uvo : " +uvo); //데이터가 없으면 null로 나옴
      
	//3. 스프링컨테이너 종료(close)
    System.out.println("------ 스프링 컨테이너 종료 처리 ------");
    container.close();
	}
}
