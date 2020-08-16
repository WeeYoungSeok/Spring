package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/apllicationContext.xml");
		
		MessageBean apple = (MessageBean) factory.getBean("apple");
		apple.sayHello();
		
		MessageBean watermelon = (MessageBean) factory.getBean("watermelon");
		watermelon.sayHello();
		
		MessageBean melon = (MessageBean) factory.getBean("melon");
		melon.sayHello();
		
	}
}
