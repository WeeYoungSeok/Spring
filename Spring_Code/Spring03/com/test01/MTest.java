package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		AbstractTest today = (AbstractTest) factory.getBean("singleton");
		System.out.println("오늘은 " + today.dayInfo());
		// 부모타입으로 객체생성했지만 
		// 알아서 형변환이 일어나서 자식의 dayInfo가 가져와짐
	}
}

/*
 	싱글톤 레스트리
 	- 스프링이 직접 싱글톤 형태의 오브젝트를 만들고 관리하는 기능을 제공
 	(스프링 빈 오브젝트는 내부적으로 싱글톤 레지스트리를 만들어서 연동)
 */ 
