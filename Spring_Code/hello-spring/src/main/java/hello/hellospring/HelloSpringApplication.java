package hello.hellospring;
// 여기 패키지부터 컴포넌트 스캔을 한다.
// 그래서 이 패키지를 포함한 하위 패키지 이외에 다른이름으로 패키지를 만들어서
// 거기에 Java클래스를 만들어서 @Service나 @Repository 등등 걸어줘도 Bean으로 등록이 안된다.
// 이게 베이스패키지이다
// 하지만 등록하는 방법도 있다. 그건.. 백기선 썜..거에 나와있다.


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
