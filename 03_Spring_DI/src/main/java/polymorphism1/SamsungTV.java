package polymorphism1;

class SamsungTV implements TV {
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println(">> SamsungTV 객체 생성");
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


}
