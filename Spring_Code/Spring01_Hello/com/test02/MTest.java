package com.test02;

public class MTest {
// 약결합 인터페이스를 통해 Bean으로 연결
// 다른 언어 추가할때 아주 편함
	public static void main(String[] args) {
		MessageBean bean01 = new MessageBeanEn();
		bean01.sayHello("Spring");
		
		MessageBean bean02 = new MessageBeanKo();
		bean02.sayHello("스프링");
	}
}
