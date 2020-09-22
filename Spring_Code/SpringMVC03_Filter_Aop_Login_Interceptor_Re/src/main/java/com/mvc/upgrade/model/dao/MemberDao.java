package com.mvc.upgrade.model.dao;

import com.mvc.upgrade.model.dto.MemberDto;

public interface MemberDao {

	String NAMESPACE = "member.";
	
	public MemberDto login(MemberDto dto);
}
