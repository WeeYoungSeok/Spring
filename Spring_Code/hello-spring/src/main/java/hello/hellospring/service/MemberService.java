package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import javax.transaction.Transactional;

// jpa를 쓸때 주의
// 항상 Transactional이 있어야한다 (데이터가 저장될때나 수정될때 삭제 등 이럴때 꼭)
// 메소드에 걸어도되지만 걍 클래스에 걸자
// Jpa는 Transactional안에서 꼭 실행이 되어야한다.

// 이 Service를 걸어주어야지
// Bean으로 스프링 컨테이너에 등록이된다.
// 만약 어노테이션을 안걸면 그냥 순수 자바객체가 되어버린다.
@Transactional
public class MemberService {

	// private final MemberRepository memberRepository = new MemoryMemberRepository();
	// new로 선언한걸 그냥 인스턴스 변수까지만 선언
	private final MemberRepository memberRepository;
	
	// 그리고 생성자 생성
	// 여기도 마찬가지로 오토와이어드를 걸어준다!
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	
	// 회원가입
	public Long Join(Member member) {

		// 메서드가 실행되는데 걸리는 시간 구하기
		// 이걸 전부 메소드에 적용하려면 미치고 코드 효율도 진짜 안좋음
		// 이럴때 필요한게 AOP다.
		// long start = System.currentTimeMillis();

		// 같은 이름이 있는 중복 회원X
		// Optional<Member> result = memberRepository.findByName(member.getName());
		// 이렇게도 쓰지만 바로 값을 바로써버려도된다

		// result가 만약 값이 있으면
		// 이미 존재하는 회원이라고 예외를 발생
		// null이 아니라 값이 있으면
		// 근데 null이 들어오면 if로 처리했겠지만
		// Optional때문에 null로 감싸서 반환이 가능하다.
		// result.ifPresent(m -> {
		/*
		 * memberRepository.findByName(member.getName()) .ifPresent(m -> { throw new
		 * IllegalStateException("이미 존재하는 회원입니다."); });
		 */
		// 메소드로 만들어서 이렇게 처리도 가능
		// try {
			validateDuplicateMember(member); // 중복 회원 검증
			// 하고나서 중복아니면 저장
			memberRepository.save(member);
			return member.getId();
		// } finally {
		//	long finish = System.currentTimeMillis();
		//	long timeMs = finish - start;
		//	System.out.println("join = " + timeMs + "ms");
		// }

	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}

	// 서비스 클래스는 비지니스에 관련된 이름을 써야된다.
	// 리포지토리는 개발에 관련되게 이름을 작업
	// 전체 회원조회
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}
