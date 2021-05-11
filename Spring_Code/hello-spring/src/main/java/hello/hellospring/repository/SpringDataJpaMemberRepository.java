package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository를 상속 받고
// 그냥 인터페이스만 구현 해두면 스프링 부트가 Bean으로 등록을 한다..
// 안에 있는 구현체도 지가 알아서 만듬

// interface가 interface를 상속 받을땐 extends
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 공통적인 부분 말고는 우리가 규칙을 통해 짬 findByName 등 findByNameAndId(String name, Long Id) 이런식으로 짤수 있음
    // JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);


}
