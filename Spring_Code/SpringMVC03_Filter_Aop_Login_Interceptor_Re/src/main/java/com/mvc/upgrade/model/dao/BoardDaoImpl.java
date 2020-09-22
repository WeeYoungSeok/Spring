package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	Logger logger = LoggerFactory.getLogger(BoardDaoImpl.class);

	@Override
	public List<BoardDto> selectList() {
		List<BoardDto> list = new ArrayList<BoardDto>();

		try {
			list = sqlSession.selectList(NAMESPACE + "selectlist");
		} catch (Exception e) {
			logger.info("ERROR BOARD LIST");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		BoardDto dto = null;

		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectone", myno);
		} catch (Exception e) {
			logger.info("ERROR BOARD DETAIL");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			logger.info("ERROR BOARD INSERT");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(BoardDto dto) {
		int res = 0;

		try {
			res = sqlSession.update(NAMESPACE + "update", dto);
		} catch (Exception e) {
			logger.info("ERROR BOARD UPDATE");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int myno) {
		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "delete", myno);
		} catch (Exception e) {
			logger.info("ERROR BOARD DELETE");
			e.printStackTrace();
		}
		return res;
	}

}
