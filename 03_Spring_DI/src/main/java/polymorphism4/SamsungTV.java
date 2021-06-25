package polymorphism4;

class SamsungTV implements TV {
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

