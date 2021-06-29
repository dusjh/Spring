package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterRetrunningAdvice {
	
	//어드바이스 동작시점 설정 + 포인트컷 지정
	@AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning ="returnObj")
	public void afterReturnLog(JoinPoint jp, Object returnObj) {
		System.out.println("[후처리-AfterRetrunningAdvice.afterReturnLog] 비즈니스 로직 수행 후 로그(정상 실행시) - "+returnObj);
	}
}
