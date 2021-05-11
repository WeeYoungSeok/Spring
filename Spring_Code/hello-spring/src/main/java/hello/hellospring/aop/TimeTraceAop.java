package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

// 컴포넌트 어노테이션으로 Bean으로 등록해도 되지만
// 특별한 기능이기 때문에 Config에 등록하는게 좋다.
// 컴포넌트를 이용하면 그냥 바로 Bean으로 등록이 된다
// 하지만 SpringConfig에 Bean으로 등록하는 메서드를 만들어 놓으면
// 순환 참조를 하게 되는데 그때 Bean으로 등록하는 메서드에도 지금 우리가 설정한
// execution이 적용이 된다.
// 근데 하지만? 자기 자신을 자기가 부여하므로 순환 참조에서 에러가 발생한다.
// 고로 그래서 execution 뒤에 !target으로 SpringConfig 클래스 자체를 제외 시켜주면
// execution이 SpringConfig 클래스에 적용이 안되서 순환 참조할때 에러가 발생하지 않는다.
@Aspect
public class TimeTraceAop {
    // Controller에서 Service를 호출할때 AOP가 없으면 그냥 바로 호출이 된다.
    // AOP를 적용하고 나서는 프록시라는 기술로 가짜 Service클래스를 만들어 낸다.
    // 가짜 스프링 Bean이 끝나면 그 뒤에 진짜를 호출해준다.

    // @Around("execution(* hello.hellospring.service..*(..)) && !target(hello.hellospring.SpringConfig)")
    // 이렇게하면 패키지 service 안에 들어가서 그 하위 애들에만 공통 관심사항이 붙게 된다.

    // 패키지 하위에 있는건 다 적용하라는 뜻
    // 실제로 문법이 있는데 5퍼센트 정도 쓴다.. 공부는 해보자
    @Around("execution(* hello.hellospring..*(..)) && !target(hello.hellospring.SpringConfig)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
        }


    }
}
