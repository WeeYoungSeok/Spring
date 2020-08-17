package com.test06;

public class MTest {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		// 디자인 패턴중에 팩토리 패턴이 존재한다(스프링에는 여러가지 디자인패턴이있음)
		// 팩토리패턴은 객체를 만들어주는곳이 따로있다
		// 여기서 생성하고 사용하는곳은 MTest이다.
		TV tv = (TV) factory.getBean("samsong");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
	}
}
