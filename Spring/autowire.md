##### autowire 속성

```xml
<bean id="favoriteFood" class="com.test02.Food">
			<!-- <bean id="favorite" name="favoriteFood" class="com.test02.Food"> 이러면 byName이 찾아간다 알아서 -->
			<!-- <bean id="favorite" class="com.test02.Food"> 이렇게 해서 constructor로 바꿔서 실행하면 favorite이라는 이름의 파라미터를 가진 생성자가 
			없기 때문에 그냥 기본생성자가 호출해서 둘다 null이 뜨는거임(밑에 unfavoriteFood라는 이름을 가진 생성자를 제대로 가지고 있다고해도 안됨) -->
				<constructor-arg index="0" value="사과"/>
				<constructor-arg index="1" value="1000000"/>
			</bean>
			
			<bean id="unfavoriteFood" class="com.test02.Food">
				<property name="name" value="가지"/>
				<property name="price" value="100"/>
			</bean>
			
			<!-- <bean id="myFood" class="com.test02.MyFood" autowire="default"></bean> -->
			<bean id="myFood" class="com.test02.MyFood" autowire="default"></bean>
			<!-- <bean id="myFood" class="com.test02.MyFood" autowire="constructor"></bean> -->
```



- default

  > 생성자에 할당할 type이 있는지 확인 후 (constructor)
  >
  > -> 없으면, setter에서 type이 있는지 확인하여 할당 (byType)
  >
  > ** 만일 기본생성자가 있으면, 기본 생성자 호출! (가장 최우선)
  >
  > ** @Autowired라는 어노테이션이 이 방식으로 동작!



- byName

  > setter와 같은 이름의 bean을 찾아서 자동 할당 (bean의 id나 name의 이름을 따라간다.)



- byType

  > setter와 같은 type의 bean을 찾아서 자동 할당 (유니크해야함 하나만 선언되어야하고, 위에처럼 두개 선언하면 이름은 무시하고 타입으로만 찾게되는데 2개중 뭘 넣어줘야할지 몰라서 에러 발생)



- constructor

  > 생성자의 parameter와 같은 타입, 같은 이름의 bean을 찾아서 자동 할당