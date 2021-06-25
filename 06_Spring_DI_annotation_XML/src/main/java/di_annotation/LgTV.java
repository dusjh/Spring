package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//객체 생성을 요청하는 어노테이션
@Component  //명칭 안주면 lgTV로 자동 객체 생성(클래스명 첫 글자 소문자)
public class LgTV implements TV {
	//@Autowired
	private Speaker speaker;
	
	public LgTV() {
		System.out.println(">>LgTV 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원 On");
		
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원 Off");
		
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV - 소리 크게");
		speaker.volumeUp();
		
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리 작게");
		speaker.volumeDown();
	}
}
