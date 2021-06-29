package com.spring.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service //객체(인스턴스) 생성
@Aspect //포인트컷-어드바이스 연결
public class BeforeAdvice {

	//어드바이스 동작시점 설정 + 포인트컷 지정
	@Before("PointcutCommon.allPointcut()") 
	public void beforeLog() {  //어드바이스 메서드
		System.out.println("[사전처리-BeforeAdvice.beforeLog] 비즈니스 로직 수행 전 로그");
	}
}
