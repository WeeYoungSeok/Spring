package hello.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;

// 스프링 컨테이너 통에 Bean으로 등록된다.
// Controller라는 어노테이션 때문
// 객체로 등록
@Controller
public class MemberController {

	private final MemberService memberService;

	// 오토와이어는 생성자에도 걸수있다
	// 필드에도 걸 수 있지만 생성자에도 걸 수 있으면 거는게 낫다.
	// 하지만 오토와이어를 걸면 스프링 컨테이너에서 
	// Bean으로 등록되어있는 것 중에 MemberService를 가져오게 된다.
	// 지금은 MemberService가 컨테이너에 Bean으로 등록이 안되어있다.
	// 실행하면 에러난다.
	// MemberService에 @Service로 어노테이션을 걸어두면
	// Bean으로 등록되어서 MemberController가 생성이 될때
	// 오토와이어를 통해 Bean으로 생성된애랑 같이 연결해준다 DI
	
	// 모든 객체가 생성되면 생성자가 호출되므로
	// 호출이되면서 스프링이 오토와이어를 보고 파라미터를 본뒤
	// 아 너는 맴버 서비스가 필요하구나하면서 의존성 주입을 해준다.
	// 서비스단에서는 리포지토리를 의존성 주입하게 된다.
	// 서비스에는 @Service 리포지토리에는 @Repository 이런 어노테이션을 안걸고
	// Autowired를 쓰면 Bean으로 등록되어있지 않는 객체를 의존성 주입을 시키려고하니
	// 스프링이 실행될때 어노테이션들을 읽어들이면서 에러가 발생한다.
	// 하지만 서비스 리포지토리 등등 잘 어노테이션을 걸어서 스프링이 실행될때 Bean으로 먼저 등록을 시키고
	// 오토와이어드를 읽어들이면 에러가 발생하지 않는다.
	@Autowired
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
		// aop 가짜를 찍어보기 위해 (실제 proxy가 주입되는지)
		// DI라는 주입때문에 이런게 다 가능한거다 그냥 나는 주입만 받을게 같은 타입을 넣어줘
		// 하면 proxy같은 가짜 클래스도 받을 수가 있는거다.
		// 우리가 기존에 사용했던 new이런것들로 개발을 하면 불가능하다.
		System.out.println("memberService = " + memberService.getClass());
	}
	
	// 연결은 생성자로 연결해주자
	
	
	// private final MemberService memberService = new MemberService();
	// 로 만들 수 있다.
	// 근데 이렇게 만들면
	// 다른 컨트롤러에서 MemberService를 가져다가 쓸 경우
	// 계속 인스턴스가 만들어지기 때문에 같이 공용으로 쓰는게 더 효율적이다.
	
	// 그냥 getmapping으로 url이 들어오면 템플릿에서 html을 찾는다.
	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	
	// createMemberForm에서 넘어온 url은 여기로온다
	// 위와 url을 같지만 get이냐 post로 차이가 벌어진다
	// 회원 조회시에 get이고 등록할떄는 보통 post로 한다.
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		// 커맨드객체로 인해서 input에서 넘어온 name을 form에 전달해서 필드와 일치하면 
		// setter에 name을 우리가 넣은 name으로 셋팅을 해준다
		Member member = new Member();
		member.setName(form.getName());
		//System.out.println("member = " + form.getName());
		memberService.Join(member);
		
		return "redirect:/";
	}
	
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "members/memberlist";
	}
}
