package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
		
		System.out.println("Spring Bean Container 생성!");
		
		// TV로도 형변환 가능
		// Spring Bean Container 생성! 보다 기본생성자의 시소문이 2개 먼저 찍히는이유는
		// applicationContext를 들려서 객체 생성하면서 기본생성자를 호출하였기때문에
		
		TV tv1 = factory.getBean("samsong", SamsongTV.class);
		tv1.powerOn();
		tv1.powerOff();
		tv1.volumeUp();
		tv1.volumeDown();
		
		System.out.println();
		
		 TV tv = factory.getBean("ig", TV.class); tv.powerOn(); tv.powerOff();
		 tv.volumeUp(); tv.volumeDown();
		 
		
		
	}
}
