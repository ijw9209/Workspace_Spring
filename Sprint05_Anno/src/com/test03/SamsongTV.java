package com.test03;

import org.springframework.stereotype.Component;

@Component("samsong")
public class SamsongTV implements TV {

	public SamsongTV() {
		System.out.println("Samsong tv 생성!!");
	}
	
	@Override
	public void powerOn() {
		System.out.println("Samsong tv powerOn!!");

	}

	@Override
	public void powerOff() {
		System.out.println("Samsong tv powerOff!!");

	}

	@Override
	public void volumeUp() {
		System.out.println("Samsong tv volumeUp!!");

	}

	@Override
	public void volumeDown() {
		System.out.println("Samsong tv volumeDown!!");

	}

}
