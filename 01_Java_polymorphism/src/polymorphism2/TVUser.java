package polymorphism2;

public class TVUser {
	public static void main(String[] args) {
		//삼성티비 사용
		TV tv = new SamsungTV();

		//엘지티비 사용형태로 변경
//		TV tv = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}
