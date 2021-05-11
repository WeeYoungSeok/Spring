package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    // jpa 라이브러리를 추가해줘서
    // 부트가 EntityManager이라는 Bean을 생성해줌 여기에 우리가 설정해놓은 데이터베이스 설정이 다 들어간다.
    // 그걸 우리는 인젝션만 받으면 된다.
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        // 이러면 insert 끝.
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // 조회할 타입이랑 식별자 넣어주면 됨 (PK)
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        // 리스트를 돌면서 그중에 찾았다면 리턴
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // select의 대상이 *이라고하거나 m.id등등을 다적어야하는데
        // jpa는 객체 m (entity) alias 자체를 select 한다.
        return em.createQuery("select m from Member as m", Member.class)
                .getResultList();
    }
}
