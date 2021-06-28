package com.spring.biz.common;

public class AfterRetrunningAdvice {
	public void afterReturnLog() {
		System.out.println("[후처리-AfterRetrunningAdvice.afterReturnLog] 비즈니스 로직 수행 후 로그(정상 실행시)");
	}
}
