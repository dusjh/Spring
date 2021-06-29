package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

//(실습) AOP관련 어노테이션 설정
@Service
@Aspect
public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		//핵심 메서드 실행 전
		System.out.println("[Around BEFORE] 비즈니스 로직 실행 전 처리");
		
		Object returnObj = pjp.proceed();  //호출 지연
		
		//핵심 메서드 실행 후
		System.out.println("[Around AFTER] 비즈니스 로직 실행 후 처리");
		
		return returnObj;
	}
}
