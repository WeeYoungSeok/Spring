package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import hello.hellospring.domain.Member;

// Repository도 마찬가지다 Service와
public class MemoryMemberRepository implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<Long, Member>();
	private static long sequence = 0L;
	
	@Override
	public Member save(Member member) {
		// 고객이 클라이언트 부분에서 회원가입할때
		// name은 넘겨주기 때문에 그건 member에 이미 셋팅되어 있는 상태고
		// id는 시스템적으로 우리가 시퀀스같은걸로 올려주어야하기 때문에 
		// 여기서 처리해준다.
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		// 만약 id가 null일 경우에는 Optional로 감싼다
		// 그러면 null이 들어와도 오류가 안나고 클라이언트에서 다른 작업을 할 수가 있음.
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream()
		.filter(member -> member.getName().equals(name))
		.findAny();
		// name을 받아서 stream으로 돌려서 그 name이 있는지 찾는다.
		// 하나라도 있으면 바로 반환
		// 끝까지 돌렷는데 없으면 Optional에 널이 포함돼서 반환된다
	}

	
	// 맵으로 선언했지만 루프 돌리기도 편해서
	// 맵에있는 것들을 List에 담아서 리턴해준다.
	@Override
	public List<Member> findAll() {
		// 자바 실무에서는 List 많이씀 루프 돌리기도 편함
		return new ArrayList<>(store.values());
	}

	// 저장소 map 지우기!
	// 테스트때문에
	public void clearStore() {
		store.clear();
	}
}
