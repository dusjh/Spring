package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component: 객체 생성
//@Component: 명칭 생략시 클래스명(SamsungTV)이 소문자(samsungTV)인 명칭이 사용된다.
@Component("tv")  //tv라는 명칭으로 객체 생성(저장, 관리)
class SamsungTV implements TV {
	@Autowired //동일한 데이터 타입을 찾아서 주입-동일한 데이터타입이 여러개 있을 때 오류 발생
	@Qualifier("apple") //명칭이 apple으로 관리되는 것만 찾아서 주입
	private Speaker speaker;
	private int price;
	private int width;
	private int height;	
	
	public SamsungTV() {
		System.out.println(">>samsungTV 객체 생성");
		
	}
	public SamsungTV(Speaker speaker) {
		System.out.println(">> SamsungTV 객체 생성");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker, int price) {
		System.out.println(">> SamsungTV 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	public SamsungTV(Speaker speaker, int width, int height) {
		System.out.println(">> SamsungTV 객체 생성");
		this.speaker = speaker;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void powerOn()  {
		System.out.println("SamsungTV - 전원 On");
	}
	public void powerOff()  {
		System.out.println("SamsungTV - 전원 Off");
	}
	public void volumeUp()  {
		System.out.println("SamsungTV - 볼륨업");
		speaker.volumeUp();
	}
	public void volumeDown()  {
		System.out.println("SamsungTV - 볼륨다운");
		speaker.volumeDown();
	}
	@Override
	public String toString() {
		return "SamsungTV [speaker=" + speaker + ", price=" + price + ", width=" + width + ", height=" + height + "]";
	}
	
	//-----------getter, setter 메서드 생성-------------
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	
}

