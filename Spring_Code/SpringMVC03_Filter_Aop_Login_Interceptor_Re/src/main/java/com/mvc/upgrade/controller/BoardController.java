package com.mvc.upgrade.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

@Controller
public class BoardController {

	@Autowired
	private BoardBiz biz;

	Logger logger = LoggerFactory.getLogger(BoardController.class);

	@RequestMapping("/list.do")
	public String selectList(Model model) {
		logger.info("리스트");
		model.addAttribute("list", biz.selectList());

		return "mvclist";
	}

	@RequestMapping("/detail.do")
	public String selectOne(int myno, Model model) {
		logger.info("디테일");
		model.addAttribute("detail", biz.selectOne(myno));

		return "mvcdetail";
	}

	@RequestMapping("/updateform.do")
	public String updateForm(int myno, Model model) {
		logger.info("업데이트 페이지");
		model.addAttribute("detail", biz.selectOne(myno));

		return "mvcupdate";
	}

	@RequestMapping("/updateres.do")
	public String updateRes(BoardDto dto) {
		logger.info("업데이트 성공 여부");
		int res = biz.update(dto);

		if (res > 0) {
			return "redirect:detail.do?myno=" + dto.getMyno();
		} else {
			return "redirect:updateform.do?myno=" + dto.getMyno();
		}
	}

	@RequestMapping("/delete.do")
	public String delete(int myno) {
		logger.info("딜리트 성공 여부");
		int res = biz.delete(myno);

		if (res > 0) {
			return "redirect:list.do";
		} else {
			return "redirect:detail.do?myno=" + myno;
		}
	}

	@RequestMapping("/insertform.do")
	public String insertForm() {
		logger.info("인서트 페이지");

		return "mvcinsert";
	}

	@RequestMapping("/insertres.do")
	public String insertRes(BoardDto dto) {
		logger.info("인서트 성공 여부");
		int res = biz.insert(dto);
		
		if (res > 0) {
			return "redirect:list.do";
		} else {
			return "redirect:list.do";
		}
	}
}
