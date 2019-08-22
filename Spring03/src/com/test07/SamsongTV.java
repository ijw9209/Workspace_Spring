package com.test07;

public class SamsongTV implements TV {

    public SamsongTV() {
    	System.out.println("Samsong TV 생성!");
	}
	@Override
	public void powerOn() {
		System.out.println("Samsong TV power on");
	}

	@Override
	public void powerOff() {
		System.out.println("Samsong TV power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("Samsong TV Volume Up");
	}

	@Override
	public void volumeDown() {
		System.out.println("Samsong TV Volume Down");
	}

}
