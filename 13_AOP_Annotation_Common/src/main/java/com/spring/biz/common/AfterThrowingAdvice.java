package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
	//포인트컷 작성: 명칭은 메서드 명
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut() {}
		
	@Pointcut("execution(* com.spring.biz..*Impl.get*(..))")
	public void getPointcut() {}
		
	@AfterThrowing(pointcut = "allPointcut()", throwing = "exceptionObj")
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		System.out.println("[후처리-AfterThrowingAdvice.exceptionLog] 비즈니스 로직 수행 중 예외 발생시 로그"+exceptionObj);
	}
}
