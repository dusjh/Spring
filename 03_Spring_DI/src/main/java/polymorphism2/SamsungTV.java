package polymorphism2;

class SamsungTV implements TV {
	private SonySpeaker speaker;
	private int price;
	private int width;
	private int height;	
	
	public SamsungTV() {
		System.out.println(">>samsungTV 객체 생성");
		//필드 SonySpeaker에 객체 주입
		speaker = new SonySpeaker();
	}
	public SamsungTV(SonySpeaker speaker) {
		System.out.println(">> SamsungTV 객체 생성");
		this.speaker = speaker;
	}
	public SamsungTV(SonySpeaker speaker, int price) {
		System.out.println(">> SamsungTV 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	public SamsungTV(SonySpeaker speaker, int width, int height) {
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
}
