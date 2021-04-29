### InVersion of Control

제어가 뒤바꼈다.



"내가 쓸 놈은 내가 만들어 쓸게..." (일반적인 의존성에 대한 제어권)



OwerController

만약 스프링을 안쓰거나 IoC를 안썻더라면

```java
class OwnerController {
    private OwnerRepository repository = new OwnerRepository();
}
```

이렇게 new연산자를 통해 선언 했을것이다.



내가 쓸놈을 누군가가 주입시켜준다.

그럼 나는 이걸 사용만 하면된다.



### IoC 컨테이너

빈(Bean)을 만들고 엮어주며 제공해준다.



빈 설정

- 이름 또는 ID
- 타입
- 스코프

아이러니 하게도 직접 쓸 일은 많지 않다.



OwnerController랑 OwnerRepository는 스프링 내부에서 빈으로 만들어준다.

어노테이션 컴포넌트 컨트롤러 서비스 리파지토리가 붙어있으면

빈으로 만들어진다 그리고 의존성을 엮어준다 스프링이 알아서





### Bean

스프링 IoC 컨테이너가 관리하는 객체



어떻게 등록하지?

- Component Scanning

  > @Repository
  >
  > @Service
  >
  > @Controller

- 또는 직접 일일히 XML이나 자바 설정 파일에 등록



- 어떻게 꺼내쓰지?

  > @Autowired 또는 @Inject
  >
  > 또는 ApplicationContext에서 getBean()으로 직접 꺼낸다.



일반적으로 base패키지가 존재하는데 우리가 처음에 설정한 패키지명이외에 다른 패키지에 만들어서 어노테이션을 걸어도 Bean으로 설정이 안된다.





### 의존성 주입 (Dependency Injection)

필요한 의존성을 어떻게 받아올 것인가..



@Autowired / @Inject를 어디에 붙일까?

- 생성자
- 필드
- Setter



클래스에 반드시 필요한 객체다! 그러면 생성자에 어노테이션을 거는 것을 추천

만약 생성자가 단 하나다.

그러면 파라미터로 받고 굳이 @Autowired를 걸지말자



Setter가 있다면 Setter에 의존성 주입하는게 낫다.

하지만 Setter가 없다면 굳이 Setter를 추가해서까지 의존성 주입을하는건 과하다.





### AOP

흩어진 코드를 한 곳으로 모아



흩어진 AAAA와 BBBB

```java
class A {
    method a() {
        AAAA
        오늘은 7월 4일 미국 독립 기념일이다.
        BBBB
    }
    
    method b() {
        AAAA
        저는 아침에 운동을 다녀와서 밥먹고 빨래를 했다.
        BBBB
    }
}

class B {
    mehtod c() {
        AAAA
        점심은 이거 찍느라 못먹었는데 저녁엔 제육볶음을 먹고 싶네요.
        BBBB
    }
}
// AAAA와 BBBB가 모든 메소드에 붙어있음
// 모든 메소드에 앞뒤로 붙으니깐 공통으로 뽑자
// 그게 AOP다
```



모아 놓은 AAAA와 BBBB

```java
class A {
    method a() {
        오늘은 7월 4일 미국 독립 기념일이다.
    }
    
    method b() {
        저는 아침에 운동을 다녀와서 밥먹고 빨래를 했다.
    }
}


class B {
    mehtod c() {
        점심은 이거 찍느라 못먹었는데 저녁엔 제육볶음을 먹고 싶네요.
    }
}

class AAAABBBB {
    method aaaabbbb(JoinPoint point) {
        AAAA
        point.excute();
        BBBB
    }
}

// AOP는
// 1. 바이트코드를 직접 조작가능
// 2. 프록시패턴을 통해 가능
```





### PSA 소개

잘 만든 인터페이스



나의 코드

잘 만든 인터페이스 (PSA)

확장성이 좋지 못한 코드 or 기술에 특화되어 있는 코드





