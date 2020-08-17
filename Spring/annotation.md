### annotation

- Spring Annotation

  > 어노테이션 자바 1.5부터 지원한다.
  >
  > 스프링은 어노테이션을 이용하여 빈과 관련된 정보를 설정할 수 있다.



- Spring Framework에서 annotation을 사용하려면 다음과 같은 설정들이 필요

  > CommonAnnotationBeanPostProcessor 클래스를 설정파일에 bean객체로 등록하여 annotation적용

```xml
<bean class="org.springframework.beans.factory.annotation.CommonAnnotationBeanPostProcessor"/> 
<!-- 요즘은 아예 사용 안함 -->
```



- *<*context:annotation-config/> 를 이용

  >  @Autowried, @Required, @Resource, @PostConstructor, @PreDestroy 등의 annotation을 자동처리해주는 bean post processor (이것도 요즘 거의 사용 안함)



- *<*context:component-scan base-package=""/*>* 를 이용

  > @Component, @Controller, @Service, @Repository 등의 annotation을 자동 처리



- *<*mvc:annotation-driven/*>* 를 이용

  > @RequestMappting, @Valid 등 spring mvc component들을 자동 처리.
  >
  > HandlerMapping, HandlerAdapter를 등록하여 @Controller에 요청을 연결.
  >
  > ** 해당 설정이 없어도 component-scan 태그가 있으면 mvc application 동작(있으면 컴퓨터가 편안하다.)



##### 4개의 stereotype annotation (commponent-scan에 의해 자동으로 등록)

> @Component : stereotype annotation의 조상
>
> @Controller : Spring MVC에서 controller로 인식
>
> @Service : 역할 부여 없이 스캔 대상이 됨. 비지니스 클래스(biz)에 사용
>
> @Repository : 일반적으로 dao에서 사용되며, Exception을 DataAccessException으로 변환



### Annotation 설명

- @Component

  > 패키지 : org.springframework.stereotype
  >
  > 버전 : spring 2.5
  >
  > 클래스에 선언하며 해당 클래스를 자동으로 bean 등록
  >
  > bean의 이름은 해당 클래스명이 사용됨 (첫글자는 소문자)
  >
  > 범위는 디폴트로 singleton이며 @Scope를 이용해 지정할 수 있다.



- @Autowired

  > 패키지 : org.springframework.beans.factory.annotation
  >
  > 버전 : spring 2.5
  >
  > @Autowired 어노테이션은 spring에서 의존관계를 자동으로 설정할 때 사용.
  >
  > 생성자, 필드, 메서드 세 곳에 적용이 가능하며 타입을 이용한 프로퍼티 자동 설정 기능을 제공 즉, 해당 타입의 빈 객체가 없거나 2개 이상일 경우 예외 발생
  >
  > 프로퍼티 설정 메서드(setter) 형식이 아닌 일반 메서드에도 적용이 가능하다.
  >
  > 프로퍼티 설정이 필수가 아닐 경우, @Autowired(required = false)로 선언한다. (기본값 : true) byType으로 의존관계를 자동으로 설정할 경우 같은 타입의 빈이 2개 이상 존재하게 되면 예외가 발생하는데, @Autowired도 같은 문제가 발생한다.
  >
  > 이럴때 @Qualifier를 사용하면 동일한 타입의 빈 중 즉정 빈을 사용하도록 하여 문제를 해결할 수 있다.

```java
@Autowired
@Qualifier("test")
private Test test;
```



- @Qualifier

  > 패키지 : org.springframework.beans.factory.annotation
  >
  > 버전 : spring 2.5
  >
  > @Autowired 어노테이션이 타입 기반이기 떄문에 2개 이상의 동일타입 빈 객체가 존재할 시 특정 빈을 사용하도록 선언한다.
  >
  > @Qualifier("beanName")의 형태로 @Autowired와 같이 사용하며, 메서드에서 두개 이상의 파라미터를 사용할 경우에는 파라미터 앞에 선언해야 한다.



- @Required

  > 패키지 : org.springframework.beans.factory.annotation
  >
  > 버전 : spring 2.0
  >
  > 필수 프로퍼티임을 명시하는 것으로, 프로퍼티 설정 메서드(setter)에 붙이면 된다.
  >
  > 필수 프로퍼티를 설정하지 않을 경우 빈 생성시 예외를 발생시킨다.



- @Repository

  > 패키지 : org.springframework.stereotype
  >
  > 버전 : spring 2.0
  >
  > dao에 사용되며 Exception을 DataAccessException으로 변환



- @Service

  > 패키지 : org.springframework.stereotype
  >
  > 버전 : spring 2.0
  >
  > @Service 어노테이션을 적용한 class는 biz로 등록이 된다.



- @Resource

  > 패키지 : javax.annotation.Resource
  >
  > 버전 : java 1.6 & jee5
  >
  > 어플리케이션에서 필요로 하는 자원을 자동 연결할 때 사용한다.
  >
  > name 속성에 자동으로 연결된 빈 객체의 이름을 입력한다.

```java
@Resource(name="testDao")	// byName -> byType
```



