package polymorphism1;

class SamsungTV implements TV { 
	
	public SamsungTV() {
		System.out.println(">>samsungTV 객체 생성");
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
	}
	public void volumeDown()  {
		System.out.println("SamsungTV - 볼륨다운");
	}
}
