package hello.hellospring.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

// 이렇게 static으로 임포트하면
// 밑에서 썻던 Assertions를 안붙이고
// 바로 assertThat을 쓸 수 있음
import static org.assertj.core.api.Assertions.*;

import java.util.List;

// 테스트 케이스를 먼저 작성할 수도 있다.
// 틀을 먼저 만든다.
// 이런것을 테스트 주도 개발 TDD라고 함
// TDD를 먼저 만들고 구현체를 만든다.

// 다른 곳에 가져다가 쓸것이 아니고 테스트만 할것이기 때문에
// 굳이 public으로 구현안해도된다.
class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	
	// 이것은 메소드가 하나 실행 될때마다
	// 이 메소드가 실행되게하는 것임 콜백 메서드라고 생각하면 됨
	// 결론적으로 메소드를 하나 테스트하고나서 이게 실행될거임
	// 그 다음 다른 메서드 실행 그리고 또 이거 실행 이렇게 반복
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		// 옵셔널에서는 get으로 꺼낸다.
		// get으로 바로 꺼내는건 안좋음 하지만 테스트에서는 그래도됨
		Member result = repository.findById(member.getId()).get();
		// System.out.println("result = " + (result==member));
		// 이 뜻이 내가 new해서 저장한 member와 메모리(나중에는 db)에서 꺼낸 값과 일치하냐?
		// 를 묻는것이다.
		// 이렇게 하면 내가 계속 syso문을 봐야됨 안좋음
		// 그럴때 쓰는게 assert
		
		// 위에서 static으로 import를 시켜서 앞에 Assertions를 안붙여도된다!
		assertThat(result).isEqualTo(member);
		
		// Assertions.assertThat(result).isEqualTo(member);
		// 이건 import를 import org.assertj.core.api.Assertions; 이거로 하면 된다.
		// 요즘은 이걸 더 많이 쓴다
		// 아래 것 보다.
		// that에 먼저들어온게 결과값
		// 결과값이 세이브 한거랑 똑같냐??라고 묻는것
		
		// Assertions.assertEquals(result, null); : 이렇게 되면 JUnit에 빨간불들어옴
		// Assertions.assertEquals(result, member);
		// 이건 import를 import org.junit.jupiter.api.Assertions;로 해야함
		// result랑 member랑 똑같냐고 묻는거임
		
	}
	
	@Test
	public void findByName() {
		// spring1, spring2라는 회원이 가입이 됨
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		
		
		// get으로 꺼낸다 옵셔널 이용 이러면 타입이 일치하게 됨
		Member result = repository.findByName("spring1").get();
		// spring1자리에 2넣으면 member1이랑 안같음 그러면 테스트 에러
		
		assertThat(result).isEqualTo(member1);
	}
	
	@Test
	public void findAll() {
		// 조회를 위해 여기도 두명 가입
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		
		// 간단하게 DB에 있는 맴버 수와 isEqualTo에 입력한 숫자와 동일하냐
		// 를 묻는다 
		// 2를 넣으면 테스트통과
		// 3 넣으면 실패
		assertThat(result.size()).isEqualTo(2);
		
		// 여기서 findAll작성후 
		// findAll만 테스트하면 통과하는데
		// 전체 테스트를하면 findByName이 테스트통과를 못한다.
		// 이유는??
		// 테스트 순서가 보장이 되지않음
		// findAll이 먼저 테스트 할 수도 있음 위에서부터 순서대로 된다는 보장이 없음
		// findAll이 먼저 실행이 되는 순간
		// spring1, spring2가 저장이되면서 다른 객체가 저장이 되어버려서
		// 위에서 실패가 뜸..
		// 해결법으로는 테스트가 하나가 끝나면 데이터를 깔끔하게 클리어해줘야 한다.
		// 맨 윗줄 AfterEach로 해결함
	}
}
