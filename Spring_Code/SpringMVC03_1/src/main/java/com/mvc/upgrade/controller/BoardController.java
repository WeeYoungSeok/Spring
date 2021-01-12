package com.mvc.upgrade.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

@Controller
public class BoardController {

	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardBiz biz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		list = biz.selectList();
		logger.info("리스트");
		model.addAttribute("list", list);
		//model.addAttribute("list", biz.selectList());
		
		return "mvclist";
	}
	
	@RequestMapping("/detail.do")
	public String selectOne(int myno, Model model) {
		logger.info("디테일");
		model.addAttribute("dto", biz.selectOne(myno));
		return "mvcdetail";
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		logger.info("인서트폼");
		return "mvcinsert";
	}
	
	@RequestMapping(value="/insertres.do" , method=RequestMethod.POST)
	public String insertRes(BoardDto dto) {
		logger.info("인서트결과");
		int res = biz.insert(dto);
		
		if (res > 0) {
			logger.info("글 작성 성공");
			return "redirect:list.do";
		} else {
			logger.info("글 작성 실패");
			return "redirect:insertform.do";
		}
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(int myno, Model model) {
		logger.info("업데이트 폼");
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "mvcupdate";
	}
	
	@RequestMapping(value="/updateres.do", method=RequestMethod.POST)
	public String updateRes(BoardDto dto) {
		logger.info("업데이트 결과");
		int res = biz.update(dto);
		
		if (res > 0) {
			logger.info("업데이트 성공");
			return "redirect:detail.do?myno=" + dto.getMyno();
		} else {
			logger.info("업데이트 실패");
			return "redirect:updateform.do?myno=" + dto.getMyno();
		}
	}
	
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		logger.info("글 삭제 여부");
		
		int res = biz.delete(myno);
		
		if (res > 0) {
			logger.info("글 삭제 성공");
			return "redirect:list.do";
		} else {
			logger.info("글 삭제 실패");
			return "redirect:detail.do?myno=" + myno;
		}
	}
}
