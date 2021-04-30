package hello.hellospring.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;

// 이것은 메모리니깐 DB검사도 안하고 그냥 순수 자바를 테스트한 것이다.
// 그래서 엄청 빠르다.
class MemberServiceTest {

	// MemberService memberService = new MemberService();
	
	MemberService memberService;
	
	
	
	// 여기도 만약 회원가입메소드에서 setName을 spring으로 하면
	// 테스트가 통과가 안된다 마찬가지로 clear를 해주어야함
	// 근데 MemberService밖에 없어서 클리어를 못함 
	// 그래서 맴버 리포지토리를 가져와야함
	// MemoryMemberRepository memberRepository = new MemoryMemberRepository();
	// MemoryMemberRepositoryTest 여기서도 new 여기서도 new하면 다른 객체가 생성될수도 있어서 별로 안좋다..
	// 지금은 리파지토리에 map이나 이런게 static이라서 상관없지만
	// static이 없으면 다른 객체가되고
	// 심지어 static이 붙어도 지금 같은 저장소에서 검사하는 꼴이 아니다
	// 왜냐면 new로 새롭게 인스턴스를 생성해서 주소값이 다를거기 때문이다.
	
	// 그러면 MemberSerive에서 new로 만든 MemberRepository를 그냥 선언만하고
	// 생성자로 바꾼다.
	
	// 동작하기전에 주입해준다
	MemoryMemberRepository memberRepository;
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
		// 생성자 초기화
		// 외부에서 넣어줌
		// 이걸 DI라고 함
	}
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void 회원가입() {
		// given
		// 주여졌을 때
		Member member = new Member();
		member.setName("spring");
		// hello라는 이름으로 가입시키고
		
		// when
		// 이걸 실행 했을 때
		Long saveId = memberService.Join(member);
		// 그 가입된애가 중복됐는지 아닌지를 검사해서 아이디를 가져오고
		
		
		
		// then
		// 이게 나와야대
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
		// 그 아이디로 findOne해서 Member객체를 가져와서
		// 내가 가입시킨 네임이랑 아이디로 찾은 네임이랑 같은지 비교
	}
	
	// 테스트는 정상도 중요하지만 예외 상황이 더 중요함
	// 예외도 터뜨려봐야됨
	
	@Test
	public void 중복_회원_예외() {
		// given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		
		// when
		memberService.Join(member1);
		// 같은 익셉션이 발생하면 통과됨
		// member2를 넣으면 Service단에서 IllegalStateException 이 발생했으므로
		// 같은 익셉션이라서 통과됨
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.Join(member2));
		
		// 메시지 검증법은 e로 인스턴스 변수를 만들어서
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		// 이렇게하면 내가 만든 Service단에서의 예외 메세지랑 같은지 검증
		
		// 트라이캐치 넣는게 좀 애매함
		/*
		try {
			memberService.Join(member2);
			fail("예외가 발생해야 합니다.");
		} catch (IllegalStateException e) {
			// 익셉션이 터지면 여기로 온다.
			// assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.1212"); 여기는 Service단에서 만든 메세지와 달라서 실패함
			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		}
		// 이렇게 되면 member1을 넣었을때 실패가 안하지만
		// member2를 넣었을때 같은 이름이라서 중복된 회원이라고 예외가 발생함
		*/
		
		// then
	}
	
	@Test
	void findMembers() {
		
	}
	
	@Test
	void findOne() {
		
	}
}
