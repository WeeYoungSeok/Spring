package com.boot.mvc.biz;

import java.util.List;

import com.boot.mvc.dto.BoardDto;

public interface BoardBiz {

	// 전체 출력
	public List<BoardDto> selectList();
	
	// 글 작성
	public int insert(BoardDto dto);
	
	// 상세보기
	public BoardDto selectOne(int myno);
	
	// 수정하기
	public int update(BoardDto dto);
	
	// 삭제하기
	public int delete(int myno);
}
