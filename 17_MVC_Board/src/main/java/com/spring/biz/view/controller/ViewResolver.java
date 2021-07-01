package com.spring.biz.view.controller;

/*
 * ViewResolver 클래스는 Controller가 리턴한 String(뷰 이름)에 
 * 접두어(prefix ./)와 접미어(sufix .jsp)를 결합해서 
 * 재요청(응답할) 페이지의 경로와 파일명을 완성해서 리턴
 * DispatcherServlet의 init() 호출 시  생성
 */
public class ViewResolver {
	private String prefix; 	// ./
	private String sufix;	// .jsp
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSufix(String sufix) {
		this.sufix = sufix;
	}
	
	//login.jsp 응답처리 -> 전달되는 viewName은 login
	//리턴값: "./" + "login" + ".jsp" ==> ./login.jsp 이런 형식으로 리턴
	public String getView(String viewName) {
		return prefix + viewName + sufix;
	}
}
