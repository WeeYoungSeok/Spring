package hello.hellospring.domain;

public class Member {

	// 시스템이 정하는 아이디 시퀀스같은것
	private Long id;
	// 네임은 그냥 이름
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
