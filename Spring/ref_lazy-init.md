- ref

  > 참조

```xml
<bean id="wee" class="com.test04.Emp">
	<property name="name" value="위영석"/>
	<property name="salary" value="5000000"/>
</bean>
	
<!-- ref : 참조 -->
<!-- 위의 wee라는걸 참조해서 값을 주입시켜줌 -->
<bean id="weess" class="com.test04.Engineer">
	<constructor-arg name="emp" ref="wee"/>
	<constructor-arg name="dept" value="기술팀"/>
</bean>
```

> Enginner라는 클래스 필드에 Emp라는 타입으로 이루어진 emp라는 변수가 존재함
>
> 그러면 먼저 Emp테이블에 값을 주입시킨 뒤 ref로 참조를하여 값을 주입시켜놓은 객체를 참조하여서 사용할 수 있다.



- lazy-init

  > lazy-init은 "true", "false", "default" 세 가지의 옵션을 가질 수 있다.
  >
  > default는 spring의 기본 동작에 맞게 bean을 생성하며 기본 동작은 false이다. true로 설정할 경우 나중에 Bean을 생성하게 된다.

```xml
<bean id="ig" class="com.test07.IgTV" lazy-init="true" />
<bean id="samsong" class="com.test07.SamsongTV" ></bean>
```

```java
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
```

> ApplicationContext factory =
> 				new ClassPathXmlApplicationContext("com/test07/applicationContext.xml"); 이 부분 자체가 컨테이너를 불러오는 것이다.
>
> IoC 컨테이너 안에서는 부르는 순간 객체가 생성된다.
>
> 그때 IgTV, SamsongTV 클래스안에 있는 기본 생성자가 호출이 된다.(기본 생성자안에 syso문 존재) 그러면 출력문이 기본 생성자에있는 syso문 각각 1개씩 2개와 main 메소드 안에있는 syso문이 출력된다.(lazy-init = true가 없을 경우)
>
> lazy-init = true가 있을 경우는 우리가 Bean을 호출하지 않는 이상 기본 생성자가 절대 생성되지 않는다.
>
> 위의 경우 호출을 하면 SamsongTV의 기본 생성자 호출이후 main 메소드 안에있는 syso문이 출력이 된 뒤에 SamsongTV의 메소드들 4개가 실행된 뒤 그 다음에 호출을 한 IgTV의 기본 생성자가 호출이 된다.