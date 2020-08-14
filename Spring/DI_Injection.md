### DI

- constructor injection

  > 생성자 주입

```xml
<bean id="test" class="Test">
	<constructor-args name="A" value="A"></constructor-args>
    <constructor-args name="B" value="B"/>
</bean>

<!-- Test test = new Test("A","B")와 같은 의미 -->
```

> IoC에서 객체를 생성한 뒤에 생성자를 통해 주입하는 방식이다.
>
> name대신에 index를 통하여 0번지부터 순서대로 넣어도된다.
>
> index를 생략하고 순서대로 넣어도된다.



- setter injection

  > 수정자 주입

```xml
<bean id="test" class="Test">
	<property name="a" value="A"/>
    <property name="b" value="B"></property>
</bean>

<!-- Test test = new Test();
	 test.setA("A");
	 test.setB("B"); 와 같은 의미 -->
```

> property는 setter를 의미하는데 setA에서 set을 생략하고 set뒤에오는 첫 문자를 소문자로 변경시켜서 name에 대입하면 같은 뜻이 된다.