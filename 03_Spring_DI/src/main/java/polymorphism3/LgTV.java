package polymorphism3;

public class LgTV implements TV {

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
		
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리 작게");
		
	}
}
