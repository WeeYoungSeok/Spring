package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;

public interface MemberRepository {

	Member save(Member member);
	// Optional은 java8버전부터 쓸 수 있음
	// id나 name에 null이 들어올 경우 null을 그대로 반환하는 것보단 Optional로 감싸서 리턴해줌
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
