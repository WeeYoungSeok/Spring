package com.boot.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.boot.mvc.dto.BoardDto;

@Mapper
public interface BoardDao {

	// 전체 출력
	@Select(" SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE FROM MYBOARD ")
	public List<BoardDto> selectList();

	// 글 작성
	public int insert(BoardDto dto);

	// 상세보기
	@Select(" SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE FROM MYBOARD "
			+ " WHERE MYNO = #{myno} ")
	public BoardDto selectOne(int myno);

	// 수정하기
	public int update(BoardDto dto);

	// 삭제하기
	public int delete(int myno);
}
