package di_annotation;

import org.springframework.stereotype.Component;

@Component("sony")  //이름 부여
public class SonySpeaker implements Speaker {

	public SonySpeaker() {
		System.out.println(">> SonySpeaker 생성");
	}
	
	public void volumeUp() {
		System.out.println(">> SonySpeaker 소리 크게");
	}
	
	public void volumeDown() {
		System.out.println(">> SonySpeaker 소리 작게");
	}
}
