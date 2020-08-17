package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		Engineer weess = factory.getBean("weess",Engineer.class);
		System.out.println(weess);
		
		Developer honggd = factory.getBean("honggd",Developer.class);
		System.out.println(honggd);
	}
}
