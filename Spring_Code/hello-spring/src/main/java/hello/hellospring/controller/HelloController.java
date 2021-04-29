package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	// return 값은 view를 의미 hello.html을 의미
	// resources/templates/ 있는 html을 찾는다. 기본적으로
	@GetMapping("hello")
	public String hello(Model model) {
		// view에서 data를 받아서 쓸 수 있다.
		model.addAttribute("data", "hello!!");
		return "hello";
	}
	
	
	// get 방식으로 http://localhost:8081/hello-mvc?name=???
	// ??? 부분에 내가 원하는 값을 넣으면 파람에 들어감
	// 그걸 모델에 담아서 다른 view에 던져서 그걸 받아서 사용함
	// required = false 라는 옵션을 넣으면 name 쿼리스트링을 넘겨주지 않아도 에러가 발생하지않음
	// required를 생략하면 기본적으로 true로 선언이 되어있음
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam(value="name", required = false) String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}
	
	
	// ResponseBody는 http 통신 프로토콜에 있는 응답 바디부에 이 데이터를 직접 넣어주겠다.
	@GetMapping("hello-string")
	@ResponseBody
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name; // name에 spring넣으면 hello spring으로 바뀐다.
		// 이 문자가 내가 요청한 클라이언트에 그대로 내려감
		// 템플릿에 전달해주는게 아니라 view가 없어도 내가 return한 데이터가 그대로 내려간다.
		// 그래서 빈곳에서도 찍힌다.
	}
	
	
	// 문자를 보내는 일은 잘 없고 데이터를 보낼때 사용
	// 이렇게 넘겨주면 JSON형태로 넘겨줌
	// {"name" : "spring!!!!!"}
	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		hello.setAge(55);
		return hello;
	}
	// 과거에는 xml방식을 많이 씀
	// 요즘은 거의 JSON으로 많이 쓴다.. XML방식이 많이 무겁고 열고 닫고를 두번 써야함 ex) <html></html>
	// 옛날에는 격돌을 많이 했었음
	// ResponseBody를 붙이고 객체를 반환하면 spring이 JSON으로 반환하게 디폴트로 설정되어있다.
	
	// 스프링이 맵핑을 먼저 찾고
	// 그 맵핑에 ResponseBody라는 어노테이션이 붙어있지 않으면 원래는 뷰 리졸버한테 던져서 템플릿을 호출했는데
	// 어노테이션이 붙어있으면 http 프로토콜 통신 바디에 그냥 바로 던져버린다.
	// 여기서 String같은 간편한 타입이면 바로 내려주는데
	// 객체가 오면 spring 내부에서 객체라고 판단해주고 그걸 디폴트형태의 JSON형태로 리턴해준다.
	// 객체면 JsonConverter가 동작하고 , String이면 StringConverter가 동작함.
	// ResponseBody가 붙으면 뷰 리졸버가아닌 HttpMessageConverter가 동작 여기안에 바로 윗줄 애들이 있음
	// Jackson이 우리객체를 Json으로 바꾸게 도와준다 (대표적으로 Gson도 있다. 사용해봤지?)
	
	
	
	// static 클래스는 클래스 안에서 또 사용가능
	static class Hello {
		// private이라 바로 필드를 가져다가 못쓴다
		// 그래서 게터 세터를 이용해 메소드로 접근
		// 프로퍼티 방식이다.
		private String name;
		private int age;
		
		public int getAge() {
			return age;
		}
		
		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}
}
