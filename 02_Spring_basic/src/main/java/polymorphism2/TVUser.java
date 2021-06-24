package polymorphism2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		System.out.println("----스프링 컨테이너 구동 전-----");
		//1. 스프링컨테이너 구동(스프링 설정파일 읽어서)
		GenericXmlApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("-----스프링 컨테이너 구동 후-----");
		
		//2. 스프링 컨테이너 사용
		System.out.println("---tv 요청 사용---");
		TV tv = (TV)factory.getBean("tv2Samsung2");
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
		System.out.println(tv);
		
		//3. 스프링 컨테이너 종료(close)
		System.out.println("----스프링 컨테이너 종료 처리-----");
		factory.close();

	}

}
