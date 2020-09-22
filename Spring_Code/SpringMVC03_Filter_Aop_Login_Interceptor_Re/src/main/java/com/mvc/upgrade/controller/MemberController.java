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
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class MemberController {

	
	@Autowired
	private MemberBiz biz;
	
	Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("로그인 페이지");
		return "mvclogin";
	}
	
	@RequestMapping("/ajaxlogin.do")
	@ResponseBody
	public Map<String, Boolean> login(@RequestBody MemberDto dto, HttpSession session) {
		logger.info("비동기 로그인");
		
		
		boolean check = false;
		MemberDto res = biz.login(dto);
		
		if (res != null) {
			session.setAttribute("login", res);
			check = true;
		}
		
		
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);
		return map;
	}
}
