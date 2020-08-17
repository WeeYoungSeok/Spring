package com.test06;

public class IgTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("ig tv power on");
	}

	@Override
	public void powerOff() {
		System.out.println("ig tv power off");
	}

	@Override
	public void volumeUp() {
		System.out.println("ig tv power volumeup");
	}

	@Override
	public void volumeDown() {
		System.out.println("ig tv power volumedown");
	}

}
