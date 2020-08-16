package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Address jiyoong = (Address) factory.getBean("jiyoong");
		// 클래스안에 전역변수들이 초기화가 된 Address클래스를 불러옴
		jiyoong.toString();
		// Address [name=" + name + ", addr=" + addr + ", phone=" + phone + "]
		System.out.println(jiyoong);
		
		
		Address jeongeun = (Address) factory.getBean("jeongeun");
		System.out.println(jeongeun);
	}
}
