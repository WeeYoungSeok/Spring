package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Emp emp = (Emp)factory.getBean("emp");
		emp.setName("위영석");
		emp.setSalary(10000);
		System.out.println(emp);
		
		//Emp jeongeun = factory.getBean("jeongeun", Emp.class);
		// 뒤에 괄호에서도 형변환 가능!
		//System.out.println(jeongeun);
	}
}
