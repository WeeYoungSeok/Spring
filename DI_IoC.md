### Spring



- 서블릿 내부에 이미 만들어져있는 함수

  > doGet() : 읽기
  >
  > doPost() : 쓰기
  >
  > doPut() : 수정
  >
  > doDelete() : 삭제
  >
  > ***미리 만들어져있는 함수이므로 이 이름으로 쓰지말자 주의!!***



- URI

  > 유니파이드 리소스 아이덴티 파이어

- URL

  > 유니파이드 리소스 로케이션 (주소, 경로)

- URN

  > 유니파이드 리소스 네임 (이름)



##### Framework?

- 프로그램의 골격이 되는 기본 코드
- 소프트웨어 개발을 간소화하기 위해 개발됨
- 개발자는 프레임워크를 기반으로 소스코드를 작성하여 소프트웨어를 완성시키면 된다.



### Solution 

> 특정한 상황에 대한 해결 방안. 사용자의 요구에 대응되는 H/W, S/W, Skill 등 (ex. ERP, DBMS, POS등)



### Library

> 특정 목적을 위해 사용하는 함수들을 모듈화 시킨 것 (ex. *.jar)

***이것들은 면접에서도 물어볼수있으니 기억해두자!!***



##### Spring이란?

> EJB(Enterprise JavaBean) 기반 개발에서 POJO(Plain Old Java Object) 기반 개발로 바뀐 것이다.
>
> EJB : 서버마다 코드모듈화가 다르므로 서버마다 코드를 짜야함 (코드가 길어지고 안좋음)
>
> POJO : 순수한 자바가지고 객체를 만들어서 사용하자 (과거에는 경량 컨테이너였음 현재는 노드,디장고가 경량 컨테이너 오히려 스프링은 대용량서버에 적합함)



- 개요

  > 어플리케이션 프레임워크로 불리며, 웹 어플리케이션은 물론 콘솔 어플리케이션이나 스윙과 같은 GUI 어플리케이션 등 어떤 어플리케이션에도 적용 가능한 프레임워크이다.
  >
  >  
  >
  > 스프링은 EJB와 같이 복잡한 순서를 거치지 않아도 간단하게 이용할 수 있기 때문에 과거에는 '경량 컨테이너'라고도 부른다.
  >
  >  
  >
  > DI(Dependency Injection) 과 AOP(Aspect Oriented Programming), OCP(Open-Closed Principle)을 중점 기술로 사용하고 있지만, 이외에도 여러가지 기능을 제공한다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbhbwAE%2FbtqGxO66iiZ%2FlSbYKdzBemWggkjGZq6aVK%2Fimg.png)



- Spring 주요 3가지 특징

  > DI(Dependency Injection) / IoC(Inversion of Control) :  객체를 만드는곳과 사용하는 곳을 분리
  >
  > AOP(Aspect Oriented Programming) : 관점지향 프로그래밍(AOP)은 객체지향 프로그래밍의 뒤를 이은 또 하나의 프로그래밍 언어구조이다.
  >
  > OCP(Open Closed Principle) : 개발자가 건드려도되는 부분은 오픈 안되는 부분은 클로즈 (자바 OOP에서의 캡슐화와 비슷하다.)



##### DI(Dependency Injection)

- 객체간의 결합을 느슨하게 하는 스프링의 핵심 기술

> **의존관계를 관리하는 방법**
>
> > 1. Construction Injection
> > 2. Setter Injection
> > 3. Field Injection



- 강결합

> 객체 간 결합도가 강한 프로그램
>
> > HelloApp에서 MessageBean을 직접 객체 생성하여 사용하고 있다.
> >
> > MessageBean 클래스를 다른 클래스로 변경할 경우, HelloApp의 소스를 같이 수정해 주어야한다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FJOLxb%2FbtqGzX3AmEL%2FWtRoLCwaboFT6BUKNLdFKK%2Fimg.png)



- 약결합

> 인터페이스를 사용하여 객체 간 결합도를 낮춘 프로그램
>
> > HelloApp은 MessageBean이라는 인터페이스를 통해 객체를 사용
> >
> > 일반적으로 팩토리 메서드를 활용하여, 사용할 객체(MessageBeanKo or MessageBeanEn)를 생성한다. MessageBeanEn의 객체가 생성되는 HelloApp은 수정될 사항이 없다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fd4GFPQ%2FbtqGx8yaUVs%2F4tuFDmzUYSPyq5qieKtnk1%2Fimg.png)



- 약결합2

> 스프링을 사용하여 객체 간 결합도를 낮춘 프로그램
>
> > 프로그램에서 필요한 객체를 스프링컨테이너가 미리 생성하여 이 객체를 필요로하는 프로그램에 생성자, setter 또는 메서드를 통해 전달(주입)한다.
> >
> > 어떠한 객체를 생성하여 전달할지는 디스크립터 파일(XML로 작성)을 사용한다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FkwBaL%2FbtqGyJrmN6G%2FkCcEcOIx6b0hWsDkBjJXM1%2Fimg.png)



#####  IoC(Inversion of Control) 

- 프로그램의 제어 흐릅 구조가 뒤바뀌는 것

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FA3fxL%2FbtqGCdj6HRj%2FWzkV0pIyJ2KAC5cNKPANsk%2Fimg.png)