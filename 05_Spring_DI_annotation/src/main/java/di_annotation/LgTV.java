package di_annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//객체 생성을 요청하는 어노테이션
@Component // lgTV 명칭으로 객체 생성(클래스명 첫글자 소문자)
class LgTV implements TV {
	//@Autowired
	@Resource(name="apple")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println(">> LgTV 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원 ON");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원 OFF");
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV - 소리크게~~");
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리작게~~");
		speaker.volumeDown();
	}
	
}

