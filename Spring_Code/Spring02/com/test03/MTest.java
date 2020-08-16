package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Address wee = (Address) factory.getBean("wee");
		System.out.println(wee);
		
		Address hong = (Address) factory.getBean("hong");
		System.out.println(hong);
		
		((ClassPathXmlApplicationContext)factory).close();
		// ApplicationContext에는 close 메소드가없음
		// ApplicationContext를 상속받은 ClassPathXmlApplicationContext에는 close 메소드가 존재해서
		// 형변환?해서 닫아준다.
	}

}
