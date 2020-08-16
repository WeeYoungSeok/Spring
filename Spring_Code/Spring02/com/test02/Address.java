package com.test02;

public class Address {

	private String name;
	private String addr;
	private String phone;

	
	public Address() {
		
	}
	
	public Address(String name, String addr, String phone) {
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	

	public String toString() {
		return "이름 : " + name + " \t 주소 : " + addr + " \t 전화번호 : " + phone;
		// 이름 : 한지용 주소 : 의왕 전화번호 : 010-0000-0000
	}
	
	
}
