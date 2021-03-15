package com.wee.weestagram.dto;

import lombok.Getter;
import lombok.Setter;

// 테이블 이름은 MEMBER로 정함
@Getter
@Setter
public class UserDto {

	
	private int user_no;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String auth;
	private int enabled;
	private String flag;
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
