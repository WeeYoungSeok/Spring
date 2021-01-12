package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {

	@Autowired
	private MemberBiz biz;
	
	Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("loginform.do")
	public String LoginForm() {
		return "mvclogin";
	}
	
	@ResponseBody
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public Map<String, Boolean> login(@RequestBody MemberDto dto, HttpSession session) {
		// 리퀘스트 바디는 객체에 넣을때 (ajax)
		// 객체에 안담을때는 굳이 쓸필요없음
		MemberDto res = biz.logincheck(dto);
		boolean check = false;
		if (res != null) {
			session.setAttribute("memberdto", res);
			check = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		return map;
	}
}
