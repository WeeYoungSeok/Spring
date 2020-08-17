package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Emp jiyoong = factory.getBean("jiyoong",Emp.class);
		System.out.println(jiyoong);
		
		Emp jeongeun = factory.getBean("jeongeun",Emp.class);
		System.out.println(jeongeun);
	}
}
