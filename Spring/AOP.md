### AOP(Aspect Oriented Programming)

> 관점지향 프로그래밍(AOP)은 객체지향 프로그래밍의 뒤를 이은 또 하나의 프로그래밍 언어구조이다.
>
> 관점지향의 중요한 개념은 '횡단 관점의 분리(Separation of Cross Cutting Concern)'이다.



- **CC (Core Concern)**

  > 주 관심사항

- **CCC (Cross Cutting Concern)**

  > 공통 관심사항, Logging, tracsaction 등.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FQAfeL%2FbtqGRRU4PbH%2FUBCOKBOPOh8w426iC6Av4K%2Fimg.png)



> 부가 설명으로는 CC는 프로그램의 흐름이다. (유니크한 부분을 의미)
>
> CCC는 공통된 것인데 프로젝트로 예를 들면 SNS로그인같은 기능이다.



- 특징

  > 문제를 해결하기 위한 핵심 관심사항과 전체에 적용되는 공통 관심사항을 기준으로 프로그래밍함으로써 공통모듈을 여러 코드에 쉽게 적용할 수 있도록 지원하는 기술
  >
  >  
  >
  > 공통으로 사용하는 기능들을 모듈화하고 해당 기능을 프로그램 코드에서 직접 명시하지 않고 선언적으로 처리하여 필요한 컴포넌트에 계층적으로 다양한 기능들을 적용한다.



| 용어               | 설명                                                         |
| ------------------ | ------------------------------------------------------------ |
| 결합점(Join Point) | 인스턴스의 생성시점. 메소드를 호출하는 시점. Exception이 발새하는 시점과 같이 애플리케이션이 실행될 떄 특정 작업이 실행되는 시점을 의미한다. (Aspect를 플러그인 할 수 있는 애플리케이션의 실행 시점) |
| 교차점(Pointcut)   | 충고가 어떤 결합점에 적용되어야 하는지 정의. 명시적인 클래스의 이름, 메소드의 이름이나 클래스나 메소드의 이름과 패턴이 일치하는 결합점을 지정 가능토록 해준다.(스프링 설정파일 안에 XML로 작성) |
| 충고(Advice)       | 교차점에서 지정한 결합점에서 실행(삽입)되어야 하는 코드, Aspect의 실제 구현체 |
| 에스펙트(Aspect)   | 에스펙트는 AOP의 중심 단위. Advice와 pointcut을 합친 것이다. 구현하고자 하는 횡단 관심사의 기능, 애플리케이션의 모듈화 하고자 하는부분 |
| 엮기(Weaving)      | 에스펙트를 대상 객체에 적용하여 새로운 프록시 객체를 생성하는 과정을 말한다. Aspect는 대상 객체의 지정된 결합점에 엮인다 |



![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbY9s3c%2FbtqGQbM1LVg%2FfCJvdRgwPzK7RKjPDT3owK%2Fimg.png)



- AOP 설정 구조

```xml
<aop:config>							<!-- 설정 구조 -->
	<aop:pointcut/>						<!-- : pointcut 설정-->
    <aop:aspect>						<!-- : aspect 설정-->
    	<aop:before/>					<!-- : method 실행 전-->
        <aop:after-returning/>			<!-- : method 정상 실행 후-->
        <aop:after-throwing/>			<!-- : method 예외 발생 시-->
        <aop:after/>					<!-- : method 실행 후 (예외 발생 여부 상관 없음-->
        <aop:around/>					<!-- : 모든 시점 적용 가능 -->					
    </aop:aspect>					
</aop:config>
```

