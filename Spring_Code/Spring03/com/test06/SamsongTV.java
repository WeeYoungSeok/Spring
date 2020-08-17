package com.test06;

public class SamsongTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("samsong tv power on");
	}

	@Override
	public void powerOff() {
		System.out.println("samsong tv power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("samsong tv power volumeup");
	}

	@Override
	public void volumeDown() {
		System.out.println("samsong tv power volumedown");
	}

}
