package com.boot.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.mvc.biz.BoardBiz;
import com.boot.mvc.dto.BoardDto;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private BoardBiz biz;
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("list.do")
	public String selectList(Model model) {
		
		List<BoardDto> list = biz.selectList();
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@GetMapping("detail.do")
	public String selectOne(Model model, int myno) {
		
		BoardDto dto = biz.selectOne(myno);
		
		model.addAttribute("detail", dto);
		
		return "board/detail";
	}
}
