package com.spring.biz.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
//	public void beforeLog() {
//		System.out.println("[사전처리-BeforeAdvice.beforeLog] 비즈니스 로직 수행 전 로그");
//	}

	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("args: "+Arrays.toString(args));
				
		System.out.println("[사전처리]"+methodName+"() 메소드 , args 정보: "+args[0]+" - 비즈니스 로직 수행 전 로그");
	}
}
