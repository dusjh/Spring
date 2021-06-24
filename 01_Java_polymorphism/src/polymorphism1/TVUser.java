package polymorphism1;

public class TVUser {
	public static void main(String[] args) {
		//삼성티비 사용
//		SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		//엘지티비 사용
		LgTV tv = new LgTV();
		tv.on();
		tv.soundDown();
		tv.soundUp();
		tv.off();
	}
}
