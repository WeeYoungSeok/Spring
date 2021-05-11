package hello.hellospring.domain;

// orm : 오브젝트와 릴레이션 데이타 테이블을 맵핑해준다.

import javax.persistence.*;

@Entity
public class Member {


	// 시스템이 정하는 아이디 시퀀스같은것
	// 시퀀스같이 자동으로 올려주는것을 IDENTITY라고 한다.
	// GeneratedValue는 PK를 의미
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	// 네임은 그냥 이름
	// Column안에 name = "db컬럼명"
	// 이렇게 하면 필드의 값고 db의 컬럼과 맵핑을 해준다.
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
