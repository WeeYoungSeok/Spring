package hello.hellospring;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.service.MemberService;

@Configuration
public class SpringConfig {


	// 스프링 데이터 Jpa를 쓸때는 인터페이스만 가져다가 쓰면 된다.
	private final MemberRepository memberRepository;

	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	// 기존에는 DataSource가 필요하다
	// 하지만 Jpa는 EntityManager가 필요하기 때문에 기존에 쓰던 DataSource는 필요없다!.

	// private EntityManager em;

	// @Autowired
	// public SpringConfig(EntityManager em) {
	//	this.em = em;
	// }

	// 스프링이 porperties 파일에서 database설정을 가져온다.
	// 스프링에서 DataSource를 제공해준다
	// 그래서 굳이 Bean으로 등록안하고도
	// Autowired로 의존성 주입이 가능하다.
	// private DataSource dataSource;
	
	
	// 생성자 주입
	// @Autowired
	// public SpringConfig(DataSource dataSource) {
	//	this.dataSource = dataSource;
	// }
	
	
	
	// MemberService와 MemberRepository가 스프링이 구동될때 Bean으로 등록이 된다.
	// 스프링 Bean에 등록되어있는 MemberRepository가 MemberService 생성자에 들어가게 된다
	// 이게 곧 어노테이션 Repository와 Service를 걸어서 Bean으로 등록해서
	// @Autowired한 결과랑 같게 된다.
	// 물론 @Service 등 걸어서 하면 더 편하다
	// 하지만 각자 장단점이 존재 Typora참조
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}


	// 스프링 부트 Jpa를 이용하면 인터페이스가 알아서 부트에 등록이되기 때문에
	// Bean등록도 필요가 없다.

//	@Bean
//	public MemberRepository memberRepository() {
		// DB 연결 이후에는 그 DB 리포로 Bean을 등록해준다
		// 이러면 db리포지토리만 구현하고 여기서 이 한줄만 바꾸면 아무 코드도 안건드리고
		// DB 리포로 바꿀 수 있다.
		// 스프링이 정말 이걸 간편하게 편리하게 도와준다.
		// OCP라는 말이 여기서 나온다.
		// 확장에는 열려있고, 수정 변경에는 닫혀있다.
		// 그니깐 확장은 막 가능한데 수정 변경은 하지말아라~~ 라는 뜻
		// return new JdbcMemberRepository(dataSource);
		
		// return new JdbcTemplateMemberRepository(dataSource);
		// return new JpaMemberRepository(em);
		
		// 이것은 DB가 아닌 메모리로 사용했던 것
		// return new MemoryMemberRepository();
//	}

	@Bean
	public TimeTraceAop timeTraceAop () {
		return new TimeTraceAop();
	}

}
