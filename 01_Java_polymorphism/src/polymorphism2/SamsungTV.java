package polymorphism2;

class SamsungTV implements TV { 
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
