package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		// 기존방식
		// 1.
		// Resource res = new FileSystemResource("src/com/test03/beans.xml);
		// 2.
		// Resource res = new ClassPathResource("com/test03/beans.xml");
		// BeanFactory factory = new XmlBeanFactory(res);
		
		// 3. 어플리케이션콘텍스트 객체 생성 (빈 팩토리를 상속받음)
		// 빈을 만들어주는아이
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		// 클래스패스(경로)에서 xml읽어와서 어플리케이션콘텍스트를 만들거다 ()안의 경로에서
		// 이렇게 되면 beans안에있는 객체 생성해놓은거를 메모리에 저장해줌
		
		MessageBean english = (MessageBean) factory.getBean("bean01");
		// 어떤 빈이 들어올지몰라서 오브젝트로 받아짐
		// 고로 형 변환해주자
		english.sayHello("Spring");
		
		MessageBean korean = (MessageBean) factory.getBean("bean02");
		korean.sayHello("스프링");
		
		// MTest와 MessageBean 사이에는 스프링 프레임워크(IoC가 존재한다(beans.xml))존재
		// beans.xml에서 객체를 생성해줌
		// 객체생성은 스프링에서 해줄거고
		// 필요한 객체는 스프링에서 가져다써라
		// 이것이 IoC 인버전 오브 컨트롤
		
		// 생성은 스프링이 사용은 사용되는 곳에서
		// 역전제어, 제어역전, 제어반전 이렇게 부름
	}
}



/*
BeanFactory <- ApplicationContext <- ClassPathXmlApplicationContext

스프링의 ApplicationContext 객체는 스프링 컨테이너 인스터스 인다.
스프링은 ApplicationContext 인터페이스의 여러 객체를 제공한다.
ClassPathXmlApplicationContext : 지정된 ClassPath에서 Xml파일을 읽어서 bean 생성

IoC : 제어 역전 (역전 제어 / 제어 반전)
-> 객체 생성(spring) != 사용 (?사용되는 곳)

인터페이스 사용, 스프링 사용 = 이것들이 약결합
스프링을 사용하면서 인터페이스도 같이 사용함(지금은 상관없지만 나중에는 꼭 이렇게하자!)

*/